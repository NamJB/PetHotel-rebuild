package com.pethotel.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pethotel.dto.PetListResponseDto;
import com.pethotel.dto.ResConfirmDto;
import com.pethotel.dto.ResSaveRequestDto;
import com.pethotel.dto.ResDetailResponseDto;
import com.pethotel.dto.ResupdateDto;
import com.pethotel.service.PetService;
import com.pethotel.service.ResService;

import jakarta.servlet.http.HttpSession;

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
		
		int memberId = (Integer)session.getAttribute("memberId");
		
		List<PetListResponseDto> petList = petService.petList(memberId);
		
		model.addAttribute("petList",petList);
		
		return "reservation/new";
	}
	
	
	//아작스 요일,펫카운트
	/*@PostMapping("/reservation/check")
	@ResponseBody
	public Map<String, Object> check(@RequestBody ResDto RDto) {
	    	   
	        return resService.check(RDto);
	}*/
	
	//예약 다시 확인
	@PostMapping("/confirm")
	public String Confirm(
			@RequestParam("reservationDates") String reservationDates,
			@RequestParam("petId") List<Integer> petIds,
			Model model) {
		
		ResConfirmDto confirm = new ResConfirmDto();
		
		String [] dateParts = reservationDates.split("~");
		
		String checkIn = dateParts[0].trim();
		String checkOut = dateParts[1].trim();
		
		confirm.setCheckIn(checkIn);
		confirm.setCheckOut(checkOut);
		
		List<PetListResponseDto> petList = petService.petResList(petIds);
		
		confirm.setSelectPets(petList);
		
		model.addAttribute("confirm",confirm);
		
		return "/reservation/confirm";
	
	}
	  
	//예약 요청
	@PostMapping("/save")
	public String save(ResSaveRequestDto rdto,HttpSession session) {
		
		Integer memberId = (Integer) session.getAttribute("memberId");
				
		rdto.setMemberId(memberId);
		
		resService.resSave(rdto);
		
		return "redirect:/reservation/complete";
		
	}
	
	//예약후 성공한 화면 뷰반환
	@GetMapping("/complete")
	public String complete() {
		
		
		return "reservation/complete";
	}
	
	
    //예약 취소 요청
    @PostMapping("/delete")
    public String resDelete(int resId,HttpSession session) {
    	
    	Integer memberId = (Integer) session.getAttribute("memberId");
    	
    	if(memberId == null) {
    		
    		return "redirect:/user/login";
    	}
    	
    	/*int resMember_id = resService.getResMember_id(id);
    	
    	if(!member_id.equals(resMember_id)) {
    		
    		return "redirect:/user/mypage";
    	}
    	*/    	
    	resService.resDelete(resId);
    	
    	return "redirect:/user/mypage";
    }
    
    //예약 업데이트 뷰반환
    @GetMapping("/update")
    public String resUpdate(@RequestParam int resId,HttpSession session,Model model) {
    	/*
    	Integer member_id = (Integer) session.getAttribute("member_id");
        
    	
    	if(member_id == null) {
    		
    		return "redirect:/user/login";
    	}
    	
    	int resMember_id = resService.getResMember_id(id);
    	
    	if(!member_id.equals(resMember_id)) {
    		
    		return "redirect:/user/mypage";
    	}
    	
    	ResDto resdto =resService.getUpdate(id);  
    	
    	model.addAttribute("res",resdto);
    	
    	return "reservation/update";*/
    	
    	ResDetailResponseDto rdto = resService.resDetail(resId);
    	
    	model.addAttribute("rdto",rdto);
    	
    	
    	return "reservation/update";
    
    }
    //예약 업데이트 요청
    @PostMapping("/update")
    public String postUpdate(ResupdateDto rdto) {
    	
    	resService.postUpdate(rdto);
    	
    	return "redirect:/reservation/resview?res_id="+rdto.getResId();
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
