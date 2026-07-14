package com.pethotel.payment.service;

import com.pethotel.payment.dto.PaymentCheckDto;

public interface PaymentService {

	public void processPayment(PaymentCheckDto dto,Integer memberId);
	
	public void cancelPayment(String impUid);
}
