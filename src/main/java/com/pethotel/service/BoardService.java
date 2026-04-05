package com.pethotel.service;

import java.util.List;

import com.pethotel.dto.BoardDto;

public interface BoardService {

	public void postWrite(BoardDto bdto);
	
	public List<BoardDto> getList();
	
	public BoardDto getView(int board_id);
	
	public void postUpdate(BoardDto bDto);
	
	public void postDelete(int board_id);
	
}
