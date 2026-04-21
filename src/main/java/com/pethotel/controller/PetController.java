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
	
	//펫등록 요청
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity<String> add(
			@RequestBody List<PetListRequestDto> pdto,
			HttpSession session,
			BindingResult bindingResult) {
		
		Integer memberId = (Integer) session.getAttribute("memberId");
		
		if(bindingResult.hasErrors()) {
			
			return ResponseEntity.badRequest().body(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
	    
		if(memberId == null) {
			
			return ResponseEntity.status(401).body("권한이 없습니다");
		}
		try {
			
			petService.add(pdto,memberId);
			
			return ResponseEntity.ok("등록되었습니다");
								
		}catch(Exception e){
			
			return ResponseEntity.status(500).body("서버오류 ");
		}
		
					
		
	
	}
	//수정폼
	@GetMapping("/{petId}/update")
	public String updateForm(@PathVariable("petId")int petId,Model model){
				
		PetUpdateResponseDto pdto = petService.petDetail(petId);
		
		model.addAttribute("pdto",pdto);
		
		return "pet/update";
	}
	
	//수정 요청
	@PostMapping("/{petId}/update")
	public String update(@PathVariable("petId")int petId,
			             @ModelAttribute PetUpdateRequestDto pdto) {
		
		petService.petUpdate(petId,pdto);	
		
		return "redirect:/board/mypage";
	}
	
	@PostMapping("/{petId}/delete")
	public String delete(@PathVariable("petId") int petId) {
		
		petService.petDelete(petId);
		
		return "redirect:/board/mypage";
	
	}
	
	
}
