package com.pethotel.service;

import java.util.List;

import com.pethotel.dto.PetRequestDto;
import com.pethotel.dto.PetResponseListDto;

public interface PetService {

	
	public void add(List<PetRequestDto> pdto,int memberId);
	
    public List<PetResponseListDto> petList(int memberId);
    
}
