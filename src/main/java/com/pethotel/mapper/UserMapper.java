package com.pethotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pethotel.dto.BoardDto;
import com.pethotel.dto.LoginDto;
import com.pethotel.dto.MemberDto;
import com.pethotel.dto.MyResDto;

@Mapper
public interface UserMapper {

	
	//회원가입 요청
	public void postMember(MemberDto memberDto);
	
	//아이디 중복체크
	public int checkUserid(String User_id);
	
	public MemberDto loginUser(LoginDto ldto);
	
	public List<BoardDto> myBoard(int member_id);
	
	public List<MyResDto> myRes(int member_id);
}
