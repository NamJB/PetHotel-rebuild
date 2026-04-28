package com.pethotel.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pethotel.dto.PetListRequestDto;
import com.pethotel.dto.PetListResponseDto;
import com.pethotel.dto.PetUpdateRequestDto;
import com.pethotel.service.PetService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pet")
public class PetApiController {

	private final PetService petService;
	
	public PetApiController(PetService petService) {
		
		this.petService = petService;
	}
	
	//마이페이지 펫리스트
	@GetMapping("/my")
	public ResponseEntity<?> getMyPet(
			HttpSession session){
		
		Integer memberId = (Integer) session.getAttribute("memberId");
		
		List<PetListResponseDto> pet = petService.petList(memberId);
		
		return ResponseEntity.ok(pet);
		
	}
	
	//펫등록 요청
	@PostMapping("/add")	
	public ResponseEntity<?> add(
			@ModelAttribute PetListRequestDto pdto,
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
			
			pdto.setMemberId(memberId);	
			
			List<PetListResponseDto> pList = petService.add(pdto);
				
			return ResponseEntity.ok(pList);
									
		}catch(Exception e){
				
			return ResponseEntity.status(500).body("서버오류 "+e.getMessage());
		}
	}
	//수정요청 
	@PutMapping("/{petId}")
	public ResponseEntity<?> update(
			@PathVariable("petId") Integer petId,
			@Valid @ModelAttribute PetUpdateRequestDto pdto) {
		
		pdto.setPetId(petId);
		
		petService.petUpdate(pdto);
		
		return ResponseEntity.ok("");
	}
	
	
}
