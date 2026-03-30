package com.pethotel.service;

import java.util.List;
import java.util.Map;

import com.pethotel.dto.MyResDto;
import com.pethotel.dto.PetInfoDto;
import com.pethotel.dto.ResDto;

public interface ResService {

	Map<String, Object> check(ResDto RDto);
	
	public void save(ResDto RDto);
	
	public List<PetInfoDto> resPet(int id);
	
	public MyResDto getView(int id);
	
	public void resDelete(int id);
}
