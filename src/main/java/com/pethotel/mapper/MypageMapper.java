package com.pethotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pethotel.dto.BoardDto;
import com.pethotel.dto.MyResDto;
import com.pethotel.dto.ResDto;

@Mapper
public interface MypageMapper {

	public List<BoardDto> myList(int member_id);
	
	public List<MyResDto> myRes(int member_id);

	
}
