package com.pethotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pethotel.dto.BoardDto;

@Mapper
public interface MypageMapper {

	public List<BoardDto> myList(int member_id);

	
}
