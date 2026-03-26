package com.example.demo.service;

import com.example.demo.dto.MemberDto;

public interface UserService {

	public void postMember(MemberDto memberDto);
	
	public MemberDto loginUser(MemberDto memberDto);
}
