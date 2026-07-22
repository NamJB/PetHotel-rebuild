package com.pethotel.user.service;

import java.util.List;

import com.pethotel.user.dto.LoginDto;
import com.pethotel.user.dto.MemberIdCheckRequestDto;
import com.pethotel.user.dto.MemberRequestDto;
import com.pethotel.user.dto.MemberResponseDto;


public interface UserService {

	public void postMember(MemberRequestDto memberDto);
	
	public MemberResponseDto loginUser(LoginDto ldto);
	
	public void idCheck(String userId);
	
}
