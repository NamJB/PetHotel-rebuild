package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	//메인홈으로 리다이렉트
	@GetMapping("/")
	public String home() {
		
		return "redirect:/main/home";
	}
	
	//메인페이지 뷰반환
	@GetMapping("/main/home")
	public String main() {
		
		return "main/home";
	}
	
}
