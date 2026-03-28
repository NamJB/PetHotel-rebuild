package com.pethotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pethotel.dto.BoardDto;
import com.pethotel.dto.MemberDto;
import com.pethotel.dto.MyResDto;

@Mapper
public interface UserMapper {

	public void postMember(MemberDto memberDto);
	
	public MemberDto loginUser(MemberDto memberDto);
	
	public List<BoardDto> myList(int member_id);
	
	public List<MyResDto> myRes(int member_id);
}
