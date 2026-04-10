package com.pethotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pethotel.dto.PetRequestDto;
import com.pethotel.mapper.PetMapper;

@Service
public class PetServiceImpl implements PetService{

	private final PetMapper petMapper;
	
	public PetServiceImpl(PetMapper petMapper) {
		
		this.petMapper = petMapper;
	}
	
	
	@Override
	public void add(List<PetRequestDto> pdto,Integer memberId) {
		
		for(PetRequestDto pet : pdto ) {
			
			pet.setMemberId(memberId);
		}
	    System.out.println(pdto + "db들어가기전");
		petMapper.add(pdto);
		
	}
	
}
