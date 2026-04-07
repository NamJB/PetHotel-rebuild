package com.pethotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pethotel.dto.BoardDto;
import com.pethotel.dto.BoardListDto;
import com.pethotel.dto.BoardResponseDto;
import com.pethotel.dto.BoardUpdateDto;
import com.pethotel.dto.ResDto;
import com.pethotel.dto.ResListDto;
import com.pethotel.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardMapper boardMapper;
	
	public BoardServiceImpl(BoardMapper boardMapper) {
		
		this.boardMapper = boardMapper;
	}
	
	@Override
	public void postWrite(BoardDto bdto) {
		
		boardMapper.postWrite(bdto);
	}
	
	@Override
	public List<BoardListDto> getList() {
		
		return boardMapper.getList();
	}
	
	@Override
	public BoardResponseDto getView(int board_id) {
		
		return boardMapper.getView(board_id);
	}
	
	@Override
	public void postUpdate(BoardUpdateDto bDto) {
		
		boardMapper.postUpdate(bDto);
	}
	
	@Override
	public void postDelete(int board_id) {
		
		boardMapper.postDelete(board_id);
	}
	
	@Override
	public List<BoardListDto> myBoard(int member_id){
				
		return boardMapper.myBoard(member_id);
	}
	
	@Override
	public List<ResListDto> myRes(int member_id) {
		
		return boardMapper.myRes(member_id);
	}
	
	
	
	
}
