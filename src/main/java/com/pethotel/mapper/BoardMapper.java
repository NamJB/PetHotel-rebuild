package com.pethotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pethotel.dto.BoardDto;
import com.pethotel.dto.BoardListDto;
import com.pethotel.dto.BoardResponseDto;
import com.pethotel.dto.BoardUpdateDto;
import com.pethotel.dto.ResListDto;

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
	
	//나의 게시판 
	public List<BoardListDto> myBoard(int member_id);
	
	//나의 예약정보
	public List<ResListDto> myRes(int member_id);
}
