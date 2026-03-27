package com.pethotel.service;

import org.springframework.stereotype.Service;

import com.pethotel.dto.MemberDto;
import com.pethotel.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{

	private final UserMapper userMapper;
	
	public UserServiceImpl(UserMapper userMapper) {
		
		this.userMapper = userMapper;
	}
	
	@Override
	public void postMember(MemberDto memberDto) {
		
		userMapper.postMember(memberDto);
	}
	
	@Override
	public MemberDto loginUser(MemberDto memberDto) {
		
		return userMapper.loginUser(memberDto);
	}
	
}
