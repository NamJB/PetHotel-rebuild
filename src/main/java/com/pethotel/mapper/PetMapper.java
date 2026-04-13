package com.pethotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pethotel.dto.PetRequestDto;
import com.pethotel.dto.PetResponseListDto;

@Mapper
public interface PetMapper {
    //회원의 펫 정보들 저장
	public void add (List<PetRequestDto> pdto);
	
	//펫정보 불러오기
	public List<PetResponseListDto> petList(int memberId);
}
