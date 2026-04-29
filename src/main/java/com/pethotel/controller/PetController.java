package com.pethotel.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pethotel.dto.PetListRequestDto;
import com.pethotel.dto.PetUpdateRequestDto;
import com.pethotel.dto.PetUpdateResponseDto;
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
	
	
	//수정폼
	@GetMapping("/{petId}/update")
	public String updateForm(@PathVariable("petId")int petId,Model model){
				
		PetUpdateResponseDto pdto = petService.petDetail(petId);
		
		model.addAttribute("pdto",pdto);
		
		return "pet/update";
	}
	
	
	
   
	
	
}
