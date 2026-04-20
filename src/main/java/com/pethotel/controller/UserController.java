package com.pethotel.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pethotel.dto.LoginDto;
import com.pethotel.dto.MemberDto;
import com.pethotel.dto.MemberIdCheckRequestDto;
import com.pethotel.dto.MemberResponseDto;
import com.pethotel.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
	   
		this.userService = userService;
	}
	
	//회원가입페이지 뷰 반환
	@GetMapping("/member")
	public String member() {
		
		return "user/member";
	}	
	
	//회원가입 요청
	@PostMapping("/member")
	public ResponseEntity<String> postMember(
			@Valid @RequestBody MemberDto mdto,
			BindingResult bindingResult ,Model model) {
		
		System.out.println(mdto);
		
		if(bindingResult.hasErrors()) {
				    			
			return ResponseEntity.badRequest().body(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
							
		try {
					
			userService.postMember(mdto);
			
			return ResponseEntity.ok("회원가입 완료되었습니다"); 
			
		}
		catch(RuntimeException e) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
		
		catch(Exception e){			
			
			return ResponseEntity.status(500).body("서버오류");
		}
	}
	
	//로그인페이지 뷰 반환
	@GetMapping("/login")
	public String login() {
		
		
		return "user/login";
	}
	
	//로그인 요청
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<String> loginUser(@Valid @RequestBody LoginDto ldto,
			BindingResult bindingResult,
			HttpSession session,
			Model model) {
	
		System.out.println(ldto);
		if(bindingResult.hasErrors()) {
			
			return ResponseEntity.badRequest().body(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		
			
		try {
			
			MemberResponseDto user = userService.loginUser(ldto);
			
			session.setAttribute("nickName", user.getNickName());
			session.setAttribute("memberId", user.getMemberId());
			
			return ResponseEntity.ok("로그인성공 ");
		
		}catch(RuntimeException e){
			
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
		catch(Exception e) {
			
			return ResponseEntity.status(500).body("서버오류");
		}
		
		
	}
	
	//로그아웃 요청
	@PostMapping("/logout")
	public String logOut(HttpSession session) {
		
		session.invalidate();
		
	
		return "redirect:/main/home";
	
	}
	
	//아이디중복확인
	@GetMapping("/idCheck")
	@ResponseBody
	public ResponseEntity<String> idCheck(
			@Valid MemberIdCheckRequestDto requestDto,
			BindingResult bindingResult) {	
		
		
		if (bindingResult.hasErrors()) {
	        String errorMessage = bindingResult.getAllErrors().get(0).getDefaultMessage();
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
	    }
		
		try {
			userService.idCheck(requestDto.getUserId());
			
			return ResponseEntity.ok("사용가능한 아이디입니다");
		}
		catch(RuntimeException e){
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
						
		}			
	}
	
	
	
}
