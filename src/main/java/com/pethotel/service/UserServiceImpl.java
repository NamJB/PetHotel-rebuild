package com.pethotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pethotel.dto.BoardDto;
import com.pethotel.dto.MemberDto;
import com.pethotel.dto.MyResDto;
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
	
	@Override
	public List<BoardDto> myList(int member_id){
				
		return userMapper.myList(member_id);
	}
	
	@Override
	public List<MyResDto> myRes(int member_id) {
		
		return userMapper.myRes(member_id);
	}
	
}
