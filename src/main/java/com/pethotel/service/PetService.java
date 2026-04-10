package com.pethotel.service;

import java.util.List;

import com.pethotel.dto.PetRequestDto;

public interface PetService {

	
	public void add(List<PetRequestDto> pdto,Integer memberId);
}
