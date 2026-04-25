package com.pethotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.pethotel.dto.BoardFormRequestDto;
import com.pethotel.dto.BoardListResponseDto;
import com.pethotel.dto.BoardUpdateRequestDto;
import com.pethotel.dto.BoardDetailResponseDto;
import com.pethotel.dto.ResListResponseDto;

@Mapper
public interface BoardMapper {

	
	
	//게시판 리스트 불러오기
    public List<BoardListResponseDto> getBoardList(String boardType);
	
    //게시판 글쓰기
  	public void postWrite(BoardFormRequestDto bdto);
	
	//게시판 수정
	public void postUpdate(BoardUpdateRequestDto bdto);
	
	//게시판 글보기
    public BoardDetailResponseDto detailBoard(Integer boardId);
	
    //게시판 글쓴이 가져오기 
    public Integer getWriterId(Integer boardId);
	
	
	
	//게시글 삭제(is_deleted 1로 업데이트)
	public void postDelete(Integer boardId);
	
	
	
	
	
}
