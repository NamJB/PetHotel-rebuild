package com.pethotel.service;

import com.pethotel.dto.MemberDto;

public interface UserService {

	public void postMember(MemberDto memberDto);
	
	public MemberDto loginUser(MemberDto memberDto);
}
