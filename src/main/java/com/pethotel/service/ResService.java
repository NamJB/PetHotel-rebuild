package com.pethotel.service;

import java.util.Map;

import com.pethotel.dto.ResDto;

public interface ResService {

	Map<String, Object> check(ResDto RDto);
	
	public void save(ResDto RDto);
}
