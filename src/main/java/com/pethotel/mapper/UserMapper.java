package com.pethotel.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.pethotel.dto.MemberDto;

@Mapper
public interface UserMapper {

	public void postMember(MemberDto memberDto);
	
	public MemberDto loginUser(MemberDto memberDto);
}
