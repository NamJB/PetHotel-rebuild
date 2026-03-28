package com.pethotel.service;

import java.util.List;

import com.pethotel.dto.BoardDto;
import com.pethotel.dto.MemberDto;
import com.pethotel.dto.MyResDto;

public interface UserService {

	public void postMember(MemberDto memberDto);
	
	public MemberDto loginUser(MemberDto memberDto);
	
	public List<BoardDto> myList(int member_id);
	
	public List<MyResDto> myRes(int member_id);
}
