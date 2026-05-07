package com.pethotel.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pethotel.dto.PaymentCheckDto;
import com.pethotel.mapper.ResMapper;



@Service
public class PaymentServiceImpl implements PaymentService { 
	
	//private IamportClient iamportClient;
	private final ResMapper resMapper;
   
	public PaymentServiceImpl(ResMapper resMapper) {
		
			
		this.resMapper = resMapper;
	}
	
	@Override
	@Transactional
	public void processPayment(PaymentCheckDto dto) {
		
		try {
			
			String token = getAccessToken();
            System.out.println("토큰: " + token);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.iamport.kr/payments/" + dto.getImp_uid() + "?include_sandbox=true"))
                .header("Authorization", token)
                .GET()
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("응답: " + response.body());
            
            
            String json = response.body();
            System.out.println("응답: " + json);
            
            int idx = json.indexOf("\"amount\":") + 9;
            int actualAmount = Integer.parseInt(json.substring(idx, json.indexOf(",", idx)));
            System.out.println("실제 결제금액: " + actualAmount);
            
            int expectedPrice = 101; // 나중에 resMapper.getPrice(dto.getResId())로 교체

            if (actualAmount == expectedPrice) {
                System.out.println("결제 검증 성공!");
                // resMapper 결제완료 업데이트
                // 결제 내역 DB 인서트
            } else {
                throw new RuntimeException("결제 금액 불일치");
            }
	        		
	    } catch (Exception e) {
	      
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
