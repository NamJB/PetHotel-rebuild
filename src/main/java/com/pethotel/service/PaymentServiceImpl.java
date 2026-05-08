package com.pethotel.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pethotel.dto.PaymentCheckDto;
import com.pethotel.dto.PaymentRequestDto;
import com.pethotel.mapper.PaymentMapper;
import com.pethotel.mapper.ResMapper;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;



@Service
public class PaymentServiceImpl implements PaymentService { 
	
	
	private final ResMapper resMapper;
	private final PaymentMapper paymentMapper;
   
	public PaymentServiceImpl(ResMapper resMapper,PaymentMapper paymentMapper) {
		
		this.paymentMapper = paymentMapper;
			
		this.resMapper = resMapper;
	}
	
	@Override
	@Transactional
	public void processPayment(PaymentCheckDto checkdto,Integer memberId) {
	
		
		try {
			//토큰호출
			String token = getAccessToken();
			
			// 자바에서 외부 API 요청을 보내기 위한 HttpClient 생성
			HttpClient client = HttpClient.newHttpClient();
			
			//테스트환경 결제 조회용 ?include_sandbox=true 트루값 줘야함
			String url =
		            "https://api.iamport.kr/payments/"
		            + checkdto.getImpUid()
		            + "?include_sandbox=true";
			
			// 실제 GET 요청 만들기
	        HttpRequest request = HttpRequest.newBuilder()
	            .uri(URI.create(url))              // 요청 보낼 주소
	            .header("Authorization", token)    // 포트원 토큰
	            .GET()                             // GET 방식 요청
	            .build();
	        
	        // 포트원 서버에 요청 보내고 응답 받기
	        HttpResponse<String> response =
	            client.send(request, HttpResponse.BodyHandlers.ofString());
	        
	        //문자열로 꺼내기 
	        String json = response.body();
	        
	        // JSON 문자열을 자바에서 읽을 수 있게 변환하는 도구
	        ObjectMapper mapper = new ObjectMapper();
	        
	        //json문자열을 jsonnode구조로 변환
	        JsonNode root = mapper.readTree(json);
	        
	        //결제 정보는 response    payment루트로
	        JsonNode payment = root.get("response");
	        System.out.println(payment);
	        //response가 null인지 , 
	        if(payment == null || payment.isNull()) {
	        	
	        	throw new RuntimeException("금액 불일치");
	        }
	        
	        
	        
	        //포트원 조회금액 
	        Integer actualAmount = payment.get("amount").asInt();
	        
	        // 포트원 결제 고유번호
	        String impUid = payment.get("imp_uid").asText();
	        
	        // 주문번호
	        String merchantUid = payment.get("merchant_uid").asText();
	        
	        // 결제수단
	        String payMethod = payment.get("pay_method").asText();
	        
	        // 결제 완료 시간
	        Long paidAtTimestamp = payment.get("paid_at").asLong();
	        
	        LocalDateTime paidAt = LocalDateTime.ofEpochSecond(
	                paidAtTimestamp,
	                0,
	                ZoneOffset.ofHours(9)
	            );
	        	        
	        Integer expectedPrice = resMapper.getAmount(checkdto.getResId());
	        
	        //결제 if문
	        if(expectedPrice == null) {
	        	
	        	throw new RuntimeException("예약금액 조회실패");
	        }
	        	                
	        // 포트원 실제 결제금액과 DB 예약금액 비교
	        if (!actualAmount.equals(expectedPrice)) {
	            
	        	throw new RuntimeException("결제 금액 불일치");
	        }
	        
	        PaymentRequestDto paymentDto = new PaymentRequestDto();
	        
	        // 예약번호 저장
	        paymentDto.setResId(checkdto.getResId());

	        // 로그인한 회원번호 저장
	        paymentDto.setMemberId(memberId);

	        // 포트원에서 조회한 진짜 impUid 저장
	        paymentDto.setImpUid(impUid);

	        // 포트원에서 조회한 주문번호 저장
	        paymentDto.setMerchantUid(merchantUid);

	        // 포트원에서 조회한 실제 결제금액 저장
	        paymentDto.setAmount(actualAmount);

	        // 결제수단 저장
	        paymentDto.setPayMethod(payMethod);

	        // 결제상태 저장
	        paymentDto.setPayStatus("PAID");

	        // 결제완료 시간 저장
	        paymentDto.setPaidAt(paidAt);
	        
	        //포트원결제내역 db insert
	        paymentMapper.insertPayment(paymentDto);
	        //resmapper로 예약상태 업데이트
	        resMapper.updatePaid(checkdto.getResId());
	        		
		}
		catch(Exception e) {
			 
			e.printStackTrace();
			 
			throw new RuntimeException("결제 검증 중 오류 발생");
		}
		        		
	}
	
		
		
	// 토큰 발급 메서드 추가
    private String getAccessToken() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        String body = "{\"imp_key\":\"0336653451438854\",\"imp_secret\":\"AQGsjN1oO4ULOJzIJYQ6XCKzWMV3d9OuBHVhJaEHUGDqz4em9b99h9n6VEakpeMFWhNr5wKWnhPZKSCZ\"}";
        
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.iamport.kr/users/getToken"))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(body))
            .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        int idx = json.indexOf("\"access_token\":\"") + 16;
        return json.substring(idx, json.indexOf("\"", idx));
    }
	


}
