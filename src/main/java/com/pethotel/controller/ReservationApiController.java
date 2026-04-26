package com.pethotel.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethotel.dto.ResListResponseDto;
import com.pethotel.service.ResService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/reservation")
public class ReservationApiController {

	private final ResService resService;
	
	public ReservationApiController(ResService resService) {
		
		this.resService = resService;
	}
	
	@GetMapping("/my")
	public ResponseEntity<?> getMyReservation(HttpSession session) {
		
		Integer memberId = (Integer) session.getAttribute("memberId");
		
		List<ResListResponseDto> res = resService.getMyReservationList(memberId);
		
		return ResponseEntity.ok(res);
	}
}
