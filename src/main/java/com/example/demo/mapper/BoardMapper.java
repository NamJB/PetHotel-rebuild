package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.BoardDto;

@Mapper
public interface BoardMapper {

	
	public void postWrite(BoardDto bdto);
	
	public List<BoardDto> getList();
}
