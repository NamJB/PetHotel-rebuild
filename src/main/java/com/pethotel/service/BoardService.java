package com.pethotel.service;

import java.util.List;


import com.pethotel.dto.BoardRequestDto;
import com.pethotel.dto.BoardResponseDto;
import com.pethotel.dto.ResListDto;

public interface BoardService {

	public List<BoardResponseDto> getBoard(BoardRequestDto bdto);
	
	
	
	
	public void postWrite(BoardRequestDto bdto);
	
	public void postUpdate(BoardRequestDto bDto);

	public BoardResponseDto getView(BoardRequestDto bdto);

	public void postDelete(int board_id);

	public List<ResListDto> myRes(int member_id);
	
	
}
