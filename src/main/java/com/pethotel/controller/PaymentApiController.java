package com.pethotel.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethotel.dto.PaymentCheckDto;
import com.pethotel.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentApiController {

	private final PaymentService paymentService;
	
	public PaymentApiController(PaymentService paymentService) {
		
		this.paymentService = paymentService;
	}
	
	@PostMapping("/verify")
	public ResponseEntity<?> verifyPayment(PaymentCheckDto dto) {
		
	    try {
	    
	    	paymentService.processPayment(dto);
	    	
	    	return ResponseEntity.ok(null);
	    	
	    }
	    catch(Exception e) {
	    	
	    	return ResponseEntity.status(500).body(e.getMessage());
	    }
		
		
	}
	
}
