package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.ResDto;

@Mapper
public interface ResMapper {

	public void save(ResDto RDto);
}
