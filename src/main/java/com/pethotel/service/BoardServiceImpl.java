package com.pethotel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pethotel.dto.BoardFormRequestDto;
import com.pethotel.dto.BoardListResponseDto;
import com.pethotel.dto.BoardUpdateRequestDto;
import com.pethotel.dto.BoardDetailResponseDto;
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
	public BoardDetailResponseDto detailBoard(Integer boardId) {
		
		 return  boardMapper.detailBoard(boardId);
		
		
	}
	
	
	@Override
	@Transactional
	public void postUpdate(BoardUpdateRequestDto bdto) {
		
		if(!bdto.getMemberId().equals(boardMapper.getWriterId(bdto.getBoardId()))) {
			
			throw new RuntimeException("");
		}
			
	    boardMapper.postUpdate(bdto);
	}
	
	@Override
	public void boardDelete(Integer boardId, Integer memberId) {
		
        if(!memberId.equals(boardMapper.getWriterId(boardId))){
			
			throw new RuntimeException("권한없음");
		}
		
		boardMapper.boardDelete(boardId);
	}
	
	
	
	
	
	
	
	
	
	
}
