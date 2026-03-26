package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.MemberDto;

@Mapper
public interface UserMapper {

	public void postMember(MemberDto memberDto);
}
