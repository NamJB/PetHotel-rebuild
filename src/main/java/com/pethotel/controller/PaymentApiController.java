package com.pethotel.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethotel.dto.PaymentCheckDto;
import com.pethotel.service.PaymentService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/payment")
public class PaymentApiController {

	private final PaymentService paymentService;
	
	public PaymentApiController(PaymentService paymentService) {
		
		this.paymentService = paymentService;
	}
	
	@PostMapping("/verify")
	public ResponseEntity<?> verifyPayment(
			@RequestBody PaymentCheckDto dto
			,HttpSession session) {
		Integer memberId = (Integer) session.getAttribute("memberId");
		
		System.out.println("===== 컨트롤러 진입 =====");
	    System.out.println("dto = " + dto);
	    try {	    
	    	paymentService.processPayment(dto,memberId);
	    	
	    	return ResponseEntity.ok("");	    	
	    }
	    catch(Exception e) {	    	
	    	return ResponseEntity.status(500).body(e.getMessage());
	    }
		
		
	}
	
}
