package com.pethotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pethotel.dto.PetRequestDto;
import com.pethotel.dto.PetRequestUpdateDto;
import com.pethotel.dto.PetResponseListDto;
import com.pethotel.dto.PetResponseUpdateDto;
import com.pethotel.mapper.PetMapper;

@Service
public class PetServiceImpl implements PetService{

	private final PetMapper petMapper;
	
	public PetServiceImpl(PetMapper petMapper) {
		
		this.petMapper = petMapper;
	}
	
	
	@Override
	public void add(List<PetRequestDto> pdto,int memberId) {
		
		for(PetRequestDto pet : pdto ) {
			
			pet.setMemberId(memberId);
		}
	    System.out.println(pdto + "db들어가기전");
		petMapper.add(pdto);
		
	}
	
	@Override
	public List<PetResponseListDto> petList(int memberId) {
		
		
		return petMapper.petList(memberId);
	}
	
	@Override
	public PetResponseUpdateDto petDetail(int petId) {
		
		
		return petMapper.petDetail(petId);
	}
	
	@Override
	public void petUpdate(int petId,PetRequestUpdateDto pdto) {
		
		petMapper.petUpdate(petId,pdto);
	}
	
}
