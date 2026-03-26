package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.MemberDto;
import com.example.demo.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{

	private final UserMapper userMapper;
	
	public UserServiceImpl(UserMapper userMapper) {
		
		this.userMapper = userMapper;
	}
	
	public void postMember(MemberDto memberDto) {
		
		userMapper.postMember(memberDto);
	}
	
	public MemberDto loginUser(MemberDto memberDto) {
		
		return userMapper.loginUser(memberDto);
	}
	
}
