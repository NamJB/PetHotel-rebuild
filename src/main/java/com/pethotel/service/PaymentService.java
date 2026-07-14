package com.pethotel.service;

import com.pethotel.dto.PaymentCheckDto;

public interface PaymentService {

	public void processPayment(PaymentCheckDto dto,Integer memberId);
	
	public void cancelPayment(String impUid);
}
