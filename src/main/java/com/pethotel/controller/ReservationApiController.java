package com.pethotel.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pethotel.dto.ResListResponseDto;
import com.pethotel.dto.ResSaveRequestDto;
import com.pethotel.dto.ReservationResponseDto;
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
	
	 //예약 취소 요청
    @PostMapping ("/{resId}/cancel")    
    public ResponseEntity<?> cancelReservation(@PathVariable("resId") Integer resId,
    		HttpSession session) {
    	
    	Integer memberId = (Integer) session.getAttribute("memberId");
    					
    	try {   		
    		resService.cancelReservation(resId,memberId);
    		
    		return ResponseEntity.ok("");   		
    	}
    	catch(RuntimeException e) {
    		
            String [] error = e.getMessage().split(":");
    		
    		int status = Integer.parseInt(error[0]);
    		
    		return ResponseEntity.status(status).body(error[1]);
    	}
    	catch(Exception e){
    		
    		e.printStackTrace();
    		
    		return ResponseEntity.status(500).body(e.getMessage());	
    	}
    	 	
    }
    
    @PostMapping("/{resId}/ready")
    public ResponseEntity<?> ready(
    		@PathVariable("resId") Integer resId,
    		HttpSession session){
    	
    	Integer memberId = (Integer) session.getAttribute("memberId");
    		
    	try {
    		//나중에 페이먼트dto만들어서 값리턴해주기 지금은 하드코딩
    		resService.getReservationInfo(resId,memberId);
    		
    		return ResponseEntity.ok("");	
    		
    	}
    	catch(RuntimeException e) {
    		
    		String [] error = e.getMessage().split(":");
    		
    		int status = Integer.parseInt(error[0]);
    		
    		return ResponseEntity.status(status).body(error[1]);
    	}
    	
    	catch(Exception e) {
    		
    		return ResponseEntity.status(500).body(e.getMessage());
    	}
    	
    	
    }
}
