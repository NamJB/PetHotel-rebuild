package com.pethotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.pethotel.dto.PetRequestDto;
import com.pethotel.dto.PetRequestUpdateDto;
import com.pethotel.dto.PetResponseListDto;
import com.pethotel.dto.PetResponseUpdateDto;

@Mapper
public interface PetMapper {
    //회원의 펫 정보들 저장
	public void add (List<PetRequestDto> pdto);
	
	//펫정보 리스트 불러오기
	public List<PetResponseListDto> petList(int memberId);
	
	//펫한마리 정보 보기
	public PetResponseUpdateDto petDetail(int petId);
	
	//펫정보 수정
	public void petUpdate(@Param("petId") int petId,
			              @Param("pdto") PetRequestUpdateDto pdto);
	
	public void petDelete(int petId);
	
}
