package com.pethotel.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pethotel.dto.BoardDto;
import com.pethotel.dto.LoginDto;
import com.pethotel.dto.MemberDto;
import com.pethotel.dto.MemberResponseDto;
import com.pethotel.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

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
	public String postMember(@Valid MemberDto mdto,BindingResult br ,Model model) {
		
		if(br.hasErrors()) {
				    
			model.addAttribute("msg",br.getFieldError().getDefaultMessage());
			model.addAttribute("mdto",mdto);
			
			return "/user/member";
		}
		
		//휴대폰 조합
		String phone = mdto.getP1() + "-" + mdto.getP2() + "-" + mdto.getP3();
		
		mdto.setPhone(phone);
			
		boolean result =userService.postMember(mdto);
			
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
	public String loginUser(@Valid LoginDto ldto,BindingResult br,HttpSession session,Model model) {
	
		if(br.hasErrors()) {
			
			model.addAttribute("msg",br.getFieldError().getDefaultMessage());
			
			return "user/login";
		}
		
		MemberResponseDto user = userService.loginUser(ldto);	
		
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
	
	
	

	
	
	
}
