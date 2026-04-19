package com.pethotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.pethotel.dto.LoginDto;
import com.pethotel.dto.MemberDto;
import com.pethotel.dto.MemberIdCheckRequestDto;
import com.pethotel.dto.MemberResponseDto;


@Mapper
public interface UserMapper {

	
	//회원가입 요청
	public void postMember(MemberDto memberDto);
	
	//아이디 중복체크
	public int checkUserId(MemberIdCheckRequestDto requestDto);
	
	public MemberResponseDto loginUser(LoginDto ldto);
	
	
	
	
}
