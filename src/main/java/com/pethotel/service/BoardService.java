package com.pethotel.service;

import java.util.List;


import com.pethotel.dto.BoardRequestDto;
import com.pethotel.dto.BoardResponseDto;
import com.pethotel.dto.ResListDto;

public interface BoardService {

	public List<BoardResponseDto> ListBoard(BoardRequestDto bdto);
	
	public void postWrite(BoardRequestDto bdto);
	
	public void postUpdate(BoardRequestDto bdto);

	public BoardResponseDto detailBoard(BoardRequestDto bdto);

	public void postDelete(int boardId);

	public List<ResListDto> myRes(int memberId);
	
	
}
