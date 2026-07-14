package com.pethotel.user.service;

import java.util.List;

import org.springframework.jdbc.support.CustomSQLExceptionTranslatorRegistrar;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pethotel.user.dto.LoginDto;
import com.pethotel.user.dto.MemberIdCheckRequestDto;
import com.pethotel.user.dto.MemberRequestDto;
import com.pethotel.user.dto.MemberResponseDto;
import com.pethotel.user.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{

	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserMapper userMapper,PasswordEncoder passwordEncoder) {
		
		this.userMapper = userMapper;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	@Transactional	
	public void postMember(MemberRequestDto mdto) {
			
		this.idCheck(mdto.getUserId());
		
		String encodedPwd = passwordEncoder.encode(mdto.getPwd());
		
		mdto.setPwd(encodedPwd);
			
	    userMapper.postMember(mdto);		
			
	}			
			
	
	@Override
	public MemberResponseDto loginUser(LoginDto ldto) {
		
		MemberResponseDto user = userMapper.loginUser(ldto);
		
		if(user == null) {
			
			throw new RuntimeException("아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		
		boolean result = passwordEncoder.matches(ldto.getPwd(), user.getPwd());
		
		if(result) {
			return user;
		}
		else {
			
			throw new RuntimeException("오류");
		}
	
	}
	
	
	@Override
	public void idCheck(String userId) {
			
		int count= userMapper.checkUserId(userId);
		
		if(count > 0) {
			
			throw new RuntimeException("중복된 아이디입니다");
		}
		
		
	}
	
	
	
}
