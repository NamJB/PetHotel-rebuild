package com.pethotel.service;

import java.util.List;
import java.util.Map;

import com.pethotel.dto.PetInfoDto;
import com.pethotel.dto.ResDto;
import com.pethotel.dto.ResResponseDto;
import com.pethotel.dto.ResupdateDto;

public interface ResService {

	/*Map<String, Object> check(ResDto RDto);*/
	/*public List<PetInfoDto> resPet(int id);*/
	public void save(ResDto RDto);
	
	public void resDelete(int res_id);		
	
	public void postUpdate(ResupdateDto rdto);
	
	public ResResponseDto getMyres(int res_id);
}
