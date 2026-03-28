package com.pethotel.service;

import java.util.List;

import com.pethotel.dto.BoardDto;
import com.pethotel.dto.MyResDto;
import com.pethotel.dto.ResDto;

public interface MypageService {

	public List<BoardDto> myList(int member_id);
	
	public List<MyResDto> myRes(int member_id);

}
