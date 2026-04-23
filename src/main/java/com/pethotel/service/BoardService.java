package com.pethotel.service;

import java.util.List;


import com.pethotel.dto.BoardListRequestDto;
import com.pethotel.dto.BoardListResponseDto;
import com.pethotel.dto.ResListResponseDto;

public interface BoardService {

	public List<BoardListResponseDto> getBoardList(String boardType);
	
	public void postWrite(BoardListRequestDto bdto);
	
	public void postUpdate(BoardListRequestDto bdto);

	public BoardListResponseDto detailBoard(BoardListRequestDto bdto);

	public void postDelete(int boardId);

	
	
	
}
