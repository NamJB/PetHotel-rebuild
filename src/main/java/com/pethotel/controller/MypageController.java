package com.pethotel.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pethotel.dto.BoardDto;
import com.pethotel.service.MypageService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MypageController {

	private final MypageService mypageService;
	
	public MypageController(MypageService mypageService) {
		
		this.mypageService = mypageService;
	}
	
	//마이페이지 뷰반환
	@GetMapping("/mypage/main")
	public String mypage(HttpSession session,Model model) {
		
		Integer member_id = (Integer) session.getAttribute("member_id");
		
		if(member_id == null) {
			
			return "redirect:/user/login";			
		}
		
		List<BoardDto> list =mypageService.myList(member_id);
		
		model.addAttribute("boardlist",list);
		
		return "mypage/main";
	}
}

