package com.pethotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pethotel.dto.BoardDto;
import com.pethotel.dto.BoardListDto;
import com.pethotel.dto.BoardResponseDto;
import com.pethotel.dto.BoardUpdateDto;
import com.pethotel.dto.MyResDto;

@Mapper
public interface BoardMapper {

	//게시판 리스트 뷰
	public List<BoardListDto> getList();
	
	//게시판 상세보기	
	public BoardResponseDto getView(int board_id);
	
	//게시판 수정
	public void postUpdate(BoardUpdateDto bDto);
	
	//게시판 글쓰기
	public void postWrite(BoardDto bdto);
    
	//게시글 삭제(is_deleted 1로 업데이트)
	public void postDelete(int board_id);
	
	public List<BoardDto> myBoard(int member_id);
	
	public List<MyResDto> myRes(int member_id);
}
