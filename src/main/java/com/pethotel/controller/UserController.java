package com.pethotel.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pethotel.dto.BoardDto;
import com.pethotel.dto.UserDto;
import com.pethotel.dto.MyResDto;
import com.pethotel.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller

public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
	    this.userService = userService;
	}
	
	//회원가입페이지 뷰 반환
	@GetMapping("/user/member")
	public String member() {
		
		return "user/member";
	}
	
	//회원가입 요청
	@PostMapping("/user/member")
	public String postMember(UserDto memberDto,String p1,String p2,String p3) {
		
		String phone = p1 + "-" + p2 + "-" + p3;
		
		memberDto.setPhone(phone);
			
		boolean result =userService.postMember(memberDto);
			
		if(result) {
				
			return "redirect:/user/login";	
		}
		else{
				
			return "redirect:/user/member";	
		}	
		
	}
	
	//로그인페이지 뷰 반환
	@GetMapping("/user/login")
	public String login() {
		
		
		return "user/login";
	}
	
	//로그인 요청
	@PostMapping("/user/login")
	public String loginUser(UserDto memberDto,HttpSession session) {
	
		UserDto user =userService.loginUser(memberDto);	
		
		if(user != null) {
			
			session.setAttribute("nickname", user.getNickname());
			session.setAttribute("member_id", user.getMember_id());
			
			return "redirect:/main/home";
		}
		
		return "redirect:/user/login";
	}
	
	//로그아웃 요청
	@PostMapping("/user/logout")
	public String logOut(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/main/home";
	}
	
	//마이페이지 뷰반환
	@GetMapping("/user/mypage")
	public String mypage(HttpSession session,Model model) {
		
		Integer member_id = (Integer) session.getAttribute("member_id");
		

		
		List<BoardDto> Blist =userService.myBoard(member_id);
		List<MyResDto> Rlist = userService.myRes(member_id);
		
		model.addAttribute("boardlist",Blist);
		model.addAttribute("reslist",Rlist);
		
		return "user/mypage";
	}
	

	
	
	
}
