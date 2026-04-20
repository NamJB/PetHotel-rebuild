package com.pethotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pethotel.dto.PetListRequestDto;
import com.pethotel.dto.PetUpdateRequestDto;
import com.pethotel.dto.PetListResponseDto;
import com.pethotel.dto.PetUpdateResponseDto;
import com.pethotel.mapper.PetMapper;

@Service
public class PetServiceImpl implements PetService{

	private final PetMapper petMapper;
	
	public PetServiceImpl(PetMapper petMapper) {
		
		this.petMapper = petMapper;
	}
	
	
	@Override
	public void add(List<PetListRequestDto> pdto,int memberId) {	
		
		for(PetListRequestDto pet : pdto ) {
			
			pet.setMemberId(memberId);
		}
	    System.out.println(pdto + "db들어가기전");
		petMapper.add(pdto);
		
	}
	
	@Override
	public List<PetListResponseDto> petList(int memberId) {
		
		
		return petMapper.petList(memberId);
	}
	
	@Override
	public PetUpdateResponseDto petDetail(int petId) {
		
		
		return petMapper.petDetail(petId);
	}
	
	@Override
	public void petUpdate(int petId,PetUpdateRequestDto pdto) {
		
		petMapper.petUpdate(petId,pdto);
	
	}
	
	@Override
	public void petDelete(int petId) {
		
		petMapper.petDelete(petId);
	}
	
	@Override
	public List<PetListResponseDto> petResList(List<Integer> petIds) {
		
		return petMapper.petResList(petIds); 
	}
	
	
}
