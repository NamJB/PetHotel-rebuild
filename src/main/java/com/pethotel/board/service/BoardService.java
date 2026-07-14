package com.pethotel.board.service;

import java.util.List;

import com.pethotel.board.dto.BoardDetailResponseDto;
import com.pethotel.board.dto.BoardFormRequestDto;
import com.pethotel.board.dto.BoardListResponseDto;
import com.pethotel.board.dto.BoardUpdateRequestDto;
import com.pethotel.reservation.dto.ResListResponseDto;

public interface BoardService {

	public List<BoardListResponseDto> getBoardList(String boardType);
	
	public void postWrite(BoardFormRequestDto bdto);
	
	public void postUpdate(BoardUpdateRequestDto bdto);

	public BoardDetailResponseDto detailBoard(Integer boardId);

	public void boardDelete(Integer boardId,Integer memberId);
	
	public List<BoardListResponseDto> getMyBoard(Integer memberId);

	
	
	
}
