package com.pethotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pethotel.dto.BoardDto;
import com.pethotel.dto.MyResDto;
import com.pethotel.dto.ResDto;
import com.pethotel.mapper.MypageMapper;

@Service
public class MypageServiceImpl implements MypageService {

	private final MypageMapper mypageMapper;
	
	public MypageServiceImpl(MypageMapper mypageMapper) {
		
		this.mypageMapper = mypageMapper;
	}
	
	@Override
	public List<BoardDto> myList(int member_id){
				
		return mypageMapper.myList(member_id);
	}
	
	@Override
	public List<MyResDto> myRes(int member_id) {
		
		return mypageMapper.myRes(member_id);
	}
	
}
