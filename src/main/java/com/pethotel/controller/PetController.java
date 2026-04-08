package com.pethotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pet")
public class PetController {

	//펫등록
	@GetMapping("/register")
	public String reserve() {
		
		return "pet/register";
	}
}
