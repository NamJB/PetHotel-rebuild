package com.pethotel.service;

import java.util.List;

import com.pethotel.dto.PetRequestDto;
import com.pethotel.dto.PetRequestUpdateDto;
import com.pethotel.dto.PetResponseListDto;
import com.pethotel.dto.PetResponseUpdateDto;

public interface PetService {

	
	public void add(List<PetRequestDto> pdto,int memberId);
	
    public List<PetResponseListDto> petList(int memberId);
    
    public PetResponseUpdateDto petDetail(int petId);
    
    public void petUpdate(int petId,PetRequestUpdateDto pdto);
    
}
