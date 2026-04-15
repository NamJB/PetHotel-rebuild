package com.pethotel.service;

import java.util.List;
import java.util.Map;

import com.pethotel.dto.ResSaveRequestDto;
import com.pethotel.dto.ResDetailResponseDto;
import com.pethotel.dto.ResupdateDto;

public interface ResService {

	/*Map<String, Object> check(ResDto RDto);*/
	/*public List<PetInfoDto> resPet(int id);*/
	public void resSave(ResSaveRequestDto RDto);
	
	public void resDelete(int resId);		
	
	public void postUpdate(ResupdateDto rdto);
	
	public ResDetailResponseDto resDetail(int resId);
}
