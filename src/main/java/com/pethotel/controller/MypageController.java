package com.pethotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MypageController {

	//마이페이지 뷰반환
	@GetMapping("/mypage/main")
	public String mypage(HttpSession session) {
		
		Integer member_id = (Integer) session.getAttribute("member_id");
		
		if(member_id == null) {
			
			return "redirect:/user/login";			
		}
				
		
		return "user/mypage";
	}
}
