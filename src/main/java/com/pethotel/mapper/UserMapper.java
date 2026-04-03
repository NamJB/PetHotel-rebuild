package com.pethotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pethotel.dto.BoardDto;
import com.pethotel.dto.UserDto;
import com.pethotel.dto.MyResDto;

@Mapper
public interface UserMapper {

	public void postMember(UserDto memberDto);
	
	public UserDto loginUser(UserDto memberDto);
	
	public List<BoardDto> myBoard(int member_id);
	
	public List<MyResDto> myRes(int member_id);
}
