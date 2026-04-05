package com.pethotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pethotel.dto.BoardDto;
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
	public List<BoardDto> getList() {
		
		return boardMapper.getList();
	}
	
	@Override
	public BoardDto getView(int board_id) {
		
		return boardMapper.getView(board_id);
	}
	
	@Override
	public void postUpdate(BoardDto bDto) {
		
		boardMapper.postUpdate(bDto);
	}
	
	@Override
	public void postDelete(int id) {
		
		boardMapper.postDelete(id);
	}
	
	
}
