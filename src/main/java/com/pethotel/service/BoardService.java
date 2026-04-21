package com.pethotel.service;

import java.util.List;


import com.pethotel.dto.BoardRequestDto;
import com.pethotel.dto.BoardResponseDto;
import com.pethotel.dto.ResListResponseDto;

public interface BoardService {

	public List<BoardResponseDto> listBoard(String boardType);
	
	public void postWrite(BoardRequestDto bdto);
	
	public void postUpdate(BoardRequestDto bdto);

	public BoardResponseDto detailBoard(BoardRequestDto bdto);

	public void postDelete(int boardId);

	
	
	
}
