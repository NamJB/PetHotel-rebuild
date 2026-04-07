package com.pethotel.service;

import java.util.List;

import com.pethotel.dto.BoardDto;
import com.pethotel.dto.BoardListDto;
import com.pethotel.dto.BoardResponseDto;
import com.pethotel.dto.BoardUpdateDto;
import com.pethotel.dto.MyResDto;

public interface BoardService {

	public void postWrite(BoardDto bdto);
	
	public List<BoardListDto> getList();
	
	public BoardResponseDto getView(int board_id);
	
	public void postUpdate(BoardUpdateDto bDto);
	
	public void postDelete(int board_id);
	
	public List<BoardDto> myBoard(int member_id);
	
	public List<MyResDto> myRes(int member_id);
}
