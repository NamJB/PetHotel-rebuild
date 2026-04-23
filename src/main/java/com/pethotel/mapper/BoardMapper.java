package com.pethotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.pethotel.dto.BoardListRequestDto;
import com.pethotel.dto.BoardListResponseDto;
import com.pethotel.dto.ResListResponseDto;

@Mapper
public interface BoardMapper {

	
	
	//게시판 리스트 불러오기
    public List<BoardListResponseDto> getBoardList(String boardType);
	
	
	
	
	
	
	
	
	
	//게시판 수정
	public void postUpdate(BoardListRequestDto bDto);
	
	//게시판 글쓰기
	public void postWrite(BoardListRequestDto bdto);
    
	//게시글 삭제(is_deleted 1로 업데이트)
	public void postDelete(int boardId);
	
	
	
	//게시판 글보기
	public BoardListResponseDto detailBoard(BoardListRequestDto bdto);
}
