package com.example.demo.service;

import java.util.Map;

import com.example.demo.dto.ResDto;

public interface ResService {

	Map<String, Object> check(ResDto RDto);
	
	public void save(ResDto RDto);
}
