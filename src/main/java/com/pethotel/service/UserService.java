package com.pethotel.service;

import java.util.List;


import com.pethotel.dto.LoginDto;
import com.pethotel.dto.MemberDto;
import com.pethotel.dto.MemberIdCheckRequestDto;
import com.pethotel.dto.MemberResponseDto;


public interface UserService {

	public boolean postMember(MemberDto memberDto);
	
	public MemberResponseDto loginUser(LoginDto ldto);
	
	public int idCheck(MemberIdCheckRequestDto requestDto);
	
}
