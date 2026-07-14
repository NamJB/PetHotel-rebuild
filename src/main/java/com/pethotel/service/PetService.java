package com.pethotel.service;

import java.util.List;

import com.pethotel.dto.PetListRequestDto;
import com.pethotel.dto.PetUpdateRequestDto;
import com.pethotel.dto.PetListResponseDto;
import com.pethotel.dto.PetUpdateResponseDto;

public interface PetService {

	
	public List<PetListResponseDto> add(PetListRequestDto pdto);
	
    public List<PetListResponseDto> petList(Integer memberId);
    
    public PetUpdateResponseDto petDetail(int petId);
    
    public List<PetListResponseDto> petUpdate(PetUpdateRequestDto pdto,Integer memberId);
    
    public List<PetListResponseDto> petDelete(Integer petId,Integer MemberId);
    
    public List<PetListResponseDto> petResList(List<Integer> petIds);
    
}
