package com.pethotel.reservation.controller;

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

import com.pethotel.pet.dto.PetListResponseDto;
import com.pethotel.pet.service.PetService;
import com.pethotel.reservation.dto.ResDetailResponseDto;
import com.pethotel.reservation.dto.ResSaveRequestDto;
import com.pethotel.reservation.dto.ResupdateDto;
import com.pethotel.reservation.service.ResService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	private final ResService resService;
	private final PetService petService;
	
	public ReservationController(ResService resService,PetService petService) {
		
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
	
   
     
    
	//마이페이지 예약글 상세보기 뷰반환
    @GetMapping("/{resId}")
	public String resDetail(
			@PathVariable("resId") Integer resId,
			Model model,
			HttpSession session) {
			
	   Integer memberId = (Integer) session.getAttribute("memberId");
	   
	   ResDetailResponseDto detail = resService.resDetail(resId,memberId);
	   
	   if(detail == null) {
		  
		   return "redirect:/user/mypage";
	   }
	   
	   model.addAttribute("detail",detail);
	   
			
	   return "reservation/detail";
		
    }
	
	
	
}
