package com.pethotel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pethotel.dto.BoardDto;
import com.pethotel.dto.LoginDto;
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
	@Transactional	
	public boolean postMember(MemberDto memberDto) {
		
		int count =userMapper.checkUserid(memberDto.getUserid());
		
		if(count > 0) {
			
			return false;
		}
		else {
			
			userMapper.postMember(memberDto);
			
			return true;
			
		}
				
			
	}


	@Override
	public MemberDto loginUser(LoginDto ldto) {
		
		return userMapper.loginUser(ldto);
	}
	
	@Override
	public List<BoardDto> myBoard(int member_id){
				
		return userMapper.myBoard(member_id);
	}
	
	@Override
	public List<MyResDto> myRes(int member_id) {
		
		return userMapper.myRes(member_id);
	}
	
}
