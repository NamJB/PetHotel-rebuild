package com.pethotel.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pethotel.dto.PetListResponseDto;
import com.pethotel.dto.ResSaveRequestDto;
import com.pethotel.dto.ResDetailResponseDto;
import com.pethotel.dto.ResupdateDto;
import com.pethotel.service.PetService;
import com.pethotel.service.ResService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/reservation")
public class ResController {

	private final ResService resService;
	private final PetService petService;
	
	public ResController(ResService resService,PetService petService) {
		
		this.resService = resService;
		
		this.petService = petService;
		
	}
	
	//예악사이트 뷰반환
	@GetMapping("/new")
	public String reservationForm(HttpSession session,Model model) {
		
		Integer memberId = (Integer)session.getAttribute("memberId");
		
		List<PetListResponseDto> petList = petService.petList(memberId);
		
		model.addAttribute("petList",petList);
		
		return "reservation/new";
	}
	
	  
	//예약 요청
	@PostMapping("/save")
	@ResponseBody
	public ResponseEntity<String> saveReservation(
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
			
			return ResponseEntity.ok("예약 성공!!");
			
		}catch(RuntimeException e){
			
			return ResponseEntity.status(400).body(e.getMessage());
		}
		catch(Exception e) {
			
			return ResponseEntity.status(500).body("예약서버오류");
		}	
		
		
	}
	
	
    //예약 취소 요청
    @PatchMapping ("/{resId}/cancel")
    @ResponseBody
    public String cancelReservation(@PathVariable("resId") int resId,HttpSession session) {
    	
    	Integer memberId = (Integer) session.getAttribute("memberId");
    	
    	if(memberId == null) {
    		//리다이렉트 고치기
    		return "redirect:/user/login";
    	}
    			
    	try {   		
    		resService.cancelReservation(resId);
    		return "success";   		
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		return "fail";	
    	}
    	 	
    }
     
    
	//마이페이지 예약글 상세보기 뷰반환
    @GetMapping("/{resId}")
	public String resDetail(@PathVariable("resId") int resId,Model model,HttpSession session) {
			
	   Integer memberId = (Integer) session.getAttribute("memberId");
	   
	   ResDetailResponseDto detail = resService.resDetail(resId);
	   
	   if(detail.getMemberId()!= memberId) {
		  
		   return "redirect:/user/mypage";
	   }
	   
	   model.addAttribute("detail",detail);
	   
			
	   return "reservation/detail";
		
    }
	
	
	
}
