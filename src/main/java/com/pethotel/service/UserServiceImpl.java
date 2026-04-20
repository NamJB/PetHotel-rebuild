package com.pethotel.service;

import java.util.List;

import org.springframework.jdbc.support.CustomSQLExceptionTranslatorRegistrar;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.pethotel.dto.LoginDto;
import com.pethotel.dto.MemberDto;
import com.pethotel.dto.MemberIdCheckRequestDto;
import com.pethotel.dto.MemberResponseDto;
import com.pethotel.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{

	private final UserMapper userMapper;
	
	public UserServiceImpl(UserMapper userMapper) {
		
		this.userMapper = userMapper;
	}
	
	@Override
	@Transactional	
	public void postMember(MemberDto mdto) {
			
		this.idCheck(mdto.getUserId());
			
	    userMapper.postMember(mdto);		
			
	}			
			
	


	@Override
	public MemberResponseDto loginUser(LoginDto ldto) {
		
		MemberResponseDto user = userMapper.loginUser(ldto);
		
		if(user == null) {
			
			throw new RuntimeException("아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		
		return user;
		
		
	}
	
	
	@Override
	public void idCheck(String userId) {
			
		int count= userMapper.checkUserId(userId);
		
		if(count > 0) {
			
			throw new RuntimeException("중복된 아이디입니다");
		}
		
		
	}
	
	
	
}
