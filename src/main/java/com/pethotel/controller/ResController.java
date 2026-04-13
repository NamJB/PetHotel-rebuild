package com.pethotel.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import com.pethotel.dto.ResDto;
import com.pethotel.dto.ResResponseDto;
import com.pethotel.dto.ResupdateDto;
import com.pethotel.service.ResService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/reservation")
public class ResController {

	private final ResService resService;
	
	public ResController(ResService resService) {
		
		this.resService=resService;
		
	}
	
	//예악사이트 뷰반환
	@GetMapping("/main")
	public String list() {
		
		return "reservation/main";
	}
	
	
	//아작스 요일,펫카운트
	/*@PostMapping("/reservation/check")
	@ResponseBody
	public Map<String, Object> check(@RequestBody ResDto RDto) {
	    	   
	        return resService.check(RDto);
	}*/
	
	//예약 다시 확인
	@PostMapping("/postConfirm")
	public String postConfirm(@ModelAttribute ResDto rdto,Model model) {
		
		model.addAttribute("rdto",rdto);
		
		return "/reservation/confirm";
	}
	  
	//예약 요청
	@PostMapping("/save")
	public String save(ResDto Rdto,HttpSession session) {
		
		Integer memberId = (Integer) session.getAttribute("member_id");
				
		Rdto.setMemberId(memberId);
		
		resService.save(Rdto);
		
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
    	
    	ResResponseDto rdto = resService.getMyres(resId);
    	
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
    @GetMapping("/resview")
	public String rescontent(@RequestParam int resId,Model model,HttpSession session) {
			
	   Integer memberId = (Integer) session.getAttribute("memberId");
	   
	 /*  
	   int resMember_id = resService.getResMember_id(id);
	   
	   if(!member_id.equals(resMember_id)) {
		   
		   return "redirect:/user/mypage";
	   }
	   
	   List<PetInfoDto> plist=resService.resPet(id);
	   MyResDto myResDto = resService.getView(id);
	   
	   
	   model.addAttribute("res",myResDto);
	   model.addAttribute("plist",plist);*/
	   
	   ResResponseDto rdto = resService.getMyres(resId);
	   
	   if(rdto.getMemberId()!= memberId) {
		  
		   return "redirect:/user/mypage";
	   }
	   
	   model.addAttribute("rdto",rdto);
	   
			
	   return "reservation/resview";
		
    }
	
	
	
}
