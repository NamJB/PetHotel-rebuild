package com.pethotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pethotel.dto.BoardFormRequestDto;
import com.pethotel.dto.BoardListResponseDto;
import com.pethotel.dto.ResListResponseDto;
import com.pethotel.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardMapper boardMapper;
	
	public BoardServiceImpl(BoardMapper boardMapper) {
		
		this.boardMapper = boardMapper;
	}
	
	
	
	@Override
	public List<BoardListResponseDto> getBoardList (String boardType) {
		
		return boardMapper.getBoardList(boardType);
	}
	
	@Override
	public void postWrite(BoardFormRequestDto bdto) {
		
		//권한 검증,도배방지,첨부파일(트랜잭션),
		
		boardMapper.postWrite(bdto);
	}
	
	
	@Override
	public BoardListResponseDto detailBoard(BoardFormRequestDto bdto) {
		
		 return  boardMapper.detailBoard(bdto);
		
		
	}
	
	@Override
	public void postUpdate(BoardFormRequestDto bDto) {
		
		boardMapper.postUpdate(bDto);
	}
	
	@Override
	public void postDelete(int board_id) {
		
		boardMapper.postDelete(board_id);
	}
	
	
	
	
	
	
	
	
	
	
}
