package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.MemberDto;
import com.example.demo.service.UserService;

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
	public String postMember(MemberDto memberDto) {
		
		userService.postMember(memberDto);
		
		return "redirect:/user/login";
	}
	
	//로그인페이지 뷰 반환
	@GetMapping("/user/login")
	public String login() {
		
		return "user/login";
	}
	
	//로그인 요청
	@PostMapping("/user/loginUser")
	public String loginUser(MemberDto memberDto,HttpSession session) {
	
		MemberDto user =userService.loginUser(memberDto);
		
		if(user != null) {
			
			session.setAttribute("user", user.getUserid());
			
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
	
	
	
}
