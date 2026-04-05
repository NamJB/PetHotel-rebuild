package com.pethotel.service;

import java.util.List;

import com.pethotel.dto.BoardDto;
import com.pethotel.dto.UserDto;
import com.pethotel.dto.MyResDto;

public interface UserService {

	public boolean postMember(UserDto memberDto);
	
	public UserDto loginUser(UserDto memberDto);
	
	public List<BoardDto> myBoard(int member_id);
	
	public List<MyResDto> myRes(int member_id);
}
