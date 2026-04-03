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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pethotel.dto.MyResDto;
import com.pethotel.dto.PetInfoDto;
import com.pethotel.dto.ResDto;
import com.pethotel.service.ResService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ResController {

	private final ResService resService;
	
	public ResController(ResService resService) {
		
		this.resService=resService;
		
	}
	
	//예악사이트 뷰반환
	@GetMapping("/reservation/main")
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
	@PostMapping("/reservation/postConfirm")
	public String postConfirm(@ModelAttribute ResDto rdto,Model model) {
		
		model.addAttribute("rdto",rdto);
		
		return "/reservation/confirm";
	}
	  
	//예약 요청
	@PostMapping("/reservation/save")
	public String save(ResDto Rdto,HttpSession session) {
		
		Integer member_id = (Integer) session.getAttribute("member_id");
		
		if(member_id == null) {
			
			return "redirect:/user/login";
		}		
		
		Rdto.setMember_id(member_id);
		
		resService.save(Rdto);
		
		return "redirect:/reservation/complete";
	}
	
	//예약후 성공한 화면 뷰반환
	@GetMapping("reservation/complete")
	public String complete() {
		
		
		return "reservation/complete";
	}
	
	//마이페이지 예약글 상세보기 뷰반환
    @GetMapping("/reservation/resview")
	public String rescontent(@RequestParam int res_id,Model model,HttpSession session) {
			
	   Integer member_id = (Integer) session.getAttribute("member_id");
	   
			
	   if(member_id == null) {
		   
		   return "redirect:/user/login";			
			
	   }
	   
	 /*  
	   int resMember_id = resService.getResMember_id(id);
	   
	   if(!member_id.equals(resMember_id)) {
		   
		   return "redirect:/user/mypage";
	   }
	   
	   List<PetInfoDto> plist=resService.resPet(id);
	   MyResDto myResDto = resService.getView(id);
	   
	   
	   model.addAttribute("res",myResDto);
	   model.addAttribute("plist",plist);*/
	   
	   ResDto rdto = resService.getMyres(res_id);
	   
	   if(rdto.getMember_id()!= member_id) {
		   
		   return "redirect:/user/mypage";
	   }
	   
	   model.addAttribute("rdto",rdto);
	   
			
	   return "reservation/resview";
		
    }
    //예약 취소 요청
    @PostMapping("/reservation/delete")
    public String resDelete(int res_id,HttpSession session) {
    	
    	Integer member_id = (Integer) session.getAttribute("member_id");
    	
    	if(member_id == null) {
    		
    		return "redirect:/user/login";
    	}
    	
    	/*int resMember_id = resService.getResMember_id(id);
    	
    	if(!member_id.equals(resMember_id)) {
    		
    		return "redirect:/user/mypage";
    	}
    	*/
    	
    	resService.resDelete(res_id);
    	
    	return "redirect:/user/mypage";
    }
    
    //예약 업데이트 뷰반환
    @GetMapping("/reservation/update")
    public String resUpdate(@RequestParam int id,HttpSession session,Model model) {
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
    
    }
    //예약 업데이트 요청
    @PostMapping("/reservation/update")
    public String postUpdate(ResDto rdto) {
    	
    	resService.postUpdate(rdto);
    	
    	return "redirect:/reservation/resview?id="+rdto.getId();
    }
	
	
	
}
