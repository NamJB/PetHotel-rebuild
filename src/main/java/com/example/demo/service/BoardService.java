package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BoardDto;

public interface BoardService {

	public void postWrite(BoardDto bdto);
	
	public List<BoardDto> getList();
	
	public BoardDto getView(int id);
	
	public void postUpdate(BoardDto bDto);
	
	public void postDelete(int id);
	
}
