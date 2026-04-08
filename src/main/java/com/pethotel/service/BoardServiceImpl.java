package com.pethotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pethotel.dto.BoardRequestDto;
import com.pethotel.dto.BoardResponseDto;
import com.pethotel.dto.ResListDto;
import com.pethotel.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardMapper boardMapper;
	
	public BoardServiceImpl(BoardMapper boardMapper) {
		
		this.boardMapper = boardMapper;
	}
	
	
	@Override
	public void postWrite(BoardRequestDto bdto) {
		
		boardMapper.postWrite(bdto);
	}
	
	
	@Override
	public BoardResponseDto detailBoard(BoardRequestDto bdto) {
		
		 return  boardMapper.detailBoard(bdto);
		
		
	}
	
	@Override
	public void postUpdate(BoardRequestDto bDto) {
		
		boardMapper.postUpdate(bDto);
	}
	
	@Override
	public void postDelete(int board_id) {
		
		boardMapper.postDelete(board_id);
	}
	
	
	
	@Override
	public List<ResListDto> myRes(int member_id) {
		
		return boardMapper.myRes(member_id);
	}
	
	@Override
	public List<BoardResponseDto> ListBoard(BoardRequestDto bdto) {
		
		return boardMapper.ListBoard(bdto);
	}
	
	
	
	
}
