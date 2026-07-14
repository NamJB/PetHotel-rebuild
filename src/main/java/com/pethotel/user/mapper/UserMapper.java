package com.pethotel.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pethotel.user.dto.LoginDto;
import com.pethotel.user.dto.MemberIdCheckRequestDto;
import com.pethotel.user.dto.MemberRequestDto;
import com.pethotel.user.dto.MemberResponseDto;


@Mapper
public interface UserMapper {

	
	//회원가입 요청
	public void postMember(MemberRequestDto memberDto);
	
	//아이디 중복체크
	public int checkUserId(String userId);
	
    //유저 로그
	public MemberResponseDto loginUser(LoginDto ldto);
	
	
	
	
}
