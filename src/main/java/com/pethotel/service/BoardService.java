package com.pethotel.service;

import java.util.List;


import com.pethotel.dto.BoardFormRequestDto;
import com.pethotel.dto.BoardListResponseDto;
import com.pethotel.dto.ResListResponseDto;

public interface BoardService {

	public List<BoardListResponseDto> getBoardList(String boardType);
	
	public void postWrite(BoardFormRequestDto bdto);
	
	public void postUpdate(BoardFormRequestDto bdto);

	public BoardListResponseDto detailBoard(BoardFormRequestDto bdto);

	public void postDelete(int boardId);

	
	
	
}
