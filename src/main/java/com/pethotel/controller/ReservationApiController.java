package com.pethotel.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethotel.dto.ResListResponseDto;
import com.pethotel.dto.ResSaveRequestDto;
import com.pethotel.service.ResService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

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
	//예약 요청
	@PostMapping("/save")
	public ResponseEntity<?> saveReservation(
			@Valid @RequestBody  ResSaveRequestDto rdto
			,HttpSession session,
			BindingResult bindingResult) {
			
	    System.out.println(rdto);
			
		Integer memberId = (Integer) session.getAttribute("memberId");
			
		if(memberId == null) {
				
			return ResponseEntity.status(401).body("예약권한 없음");
		}
			
	    if(bindingResult.hasErrors()) {
				
			return ResponseEntity.badRequest().body(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
									
		try{			
				
			rdto.setMemberId(memberId);
			
		    resService.saveReservation(rdto);
				
			return ResponseEntity.ok(rdto.getResId());
				
		}catch(RuntimeException e){
				
			return ResponseEntity.status(400).body(e.getMessage());
		}
		catch(Exception e) {
				
			return ResponseEntity.status(500).body("예약 요청 오류 :" +e.getMessage());
		}	
						
	}
}
