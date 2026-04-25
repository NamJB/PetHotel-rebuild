package com.pethotel.service;

import java.util.List;


import com.pethotel.dto.BoardFormRequestDto;
import com.pethotel.dto.BoardListResponseDto;
import com.pethotel.dto.BoardUpdateRequestDto;
import com.pethotel.dto.BoardDetailResponseDto;
import com.pethotel.dto.ResListResponseDto;

public interface BoardService {

	public List<BoardListResponseDto> getBoardList(String boardType);
	
	public void postWrite(BoardFormRequestDto bdto);
	
	public void postUpdate(BoardUpdateRequestDto bdto);

	public BoardDetailResponseDto detailBoard(Integer boardId);

	public void boardDelete(Integer boardId,Integer memberId);

	
	
	
}
