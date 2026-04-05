package com.pethotel.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pethotel.dto.BoardDto;
import com.pethotel.dto.MemberDto;
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
	public String postMember(MemberDto mdto,String p1,String p2,String p3,Model model) {
		
		if(mdto.getUserid() == null || mdto.getUserid().trim().isEmpty()) {
			
			model.addAttribute("msg","아이디 입력해라");
			return "user/member";
		}
        if(mdto.getPwd() == null || mdto.getPwd().trim().isEmpty()) {
			
			model.addAttribute("msg","비번입력해라");
			return "user/member";
		}
        
        if(mdto.getNickname() == null || mdto.getNickname().trim().isEmpty()) {
			
			model.addAttribute("msg","닉네임 입력해라");
			return "user/member";
		}
		
		
		String phone = p1 + "-" + p2 + "-" + p3;
		
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
	public String loginUser(MemberDto memberDto,HttpSession session) {
	
		MemberDto user =userService.loginUser(memberDto);	
		
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
