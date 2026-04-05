package com.pethotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pethotel.dto.BoardDto;

@Mapper
public interface BoardMapper {

	
	public void postWrite(BoardDto bdto);
	
	public List<BoardDto> getList();
	
	public BoardDto getView(int board_id);
	
	public void postUpdate(BoardDto bDto);
	
	public void postDelete(int id);
}
