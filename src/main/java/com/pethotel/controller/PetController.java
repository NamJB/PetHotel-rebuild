package com.pethotel.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pethotel.dto.PetRequestDto;
import com.pethotel.service.PetService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/pet")
public class PetController {

	
	private final PetService petService;
	
	public PetController(PetService petService) {
		
		this.petService= petService;
	}
	
	//펫등록
	@GetMapping("/register")
	public String reserve() {
		
		return "pet/register";
	}
	
	//펫등록 요청
	@PostMapping("/add")
	@ResponseBody
	public String add(@RequestBody List<PetRequestDto> pdto,HttpSession session) {
		
		Integer memberId = (Integer) session.getAttribute("memberId");
	    
		petService.add(pdto,memberId);
				
		return "success";
	}
	
	
}
