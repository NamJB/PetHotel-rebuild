package com.pethotel.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.pethotel.dto.PaymentCheckDto;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;


@Service
public class PaymentServiceImpl implements PaymentService { 
	
	private IamportClient iamportClient;
   
	public PaymentServiceImpl() {
		
		this.iamportClient = new IamportClient("0336653451438854", "PuczZquVhkX6KtDJXbwL6myEYUUjZyRrvx8y4tSJP0WlklH5HgsFFUF3iYvYldtIUr79O97r90uBQrTK");
	}
	
	@Override
	public void processPayment(PaymentCheckDto dto) {
		
		try {
	        // 포트원 서버에서 실제 결제 정보를 조회함
	        IamportResponse<Payment> response = iamportClient.paymentByImpUid(dto.getImp_uid());
	        
	        Payment payment = response.getResponse();
	        // 여기에 이제 금액 비교(if문) 로직이 들어갈 예정입니다!
	        int actualAmount = payment.getAmount().intValue();
	        
	    } catch (IamportResponseException | IOException e) {
	        e.printStackTrace();
	        throw new RuntimeException("결제 검증 중 오류 발생");
	    }
	}
	


}
