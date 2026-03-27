package com.pethotel.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@PostMapping("/reservation/check")
	@ResponseBody
	public Map<String, Object> check(@RequestBody ResDto RDto) {
	    	   
	        return resService.check(RDto);
	}
	
	//예약 다시 확인
	@PostMapping("/reservation/postConfirm")
	public String postConfirm(ResDto Rdto,Model model) {
		
		model.addAttribute("dto",Rdto);
		
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
	
	@GetMapping("reservation/complete")
	public String complete() {
		
		
		return "reservation/complete";
	}
	
	
	
}
