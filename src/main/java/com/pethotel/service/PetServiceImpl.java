package com.pethotel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public List<PetListResponseDto> add(PetListRequestDto pdto) {	
			
	    petMapper.add(pdto);
	    
	    return  this.petList(pdto.getMemberId()); 
		
	}
	
	@Override
	public List<PetListResponseDto> petList(Integer memberId) {
		
		
		return petMapper.petList(memberId);
	}
	
	@Override
	public PetUpdateResponseDto petDetail(int petId) {
		
		
		return petMapper.petDetail(petId);
	}
	
	@Override
	public void petUpdate(PetUpdateRequestDto pdto) {
		
		petMapper.petUpdate(pdto);
	
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
