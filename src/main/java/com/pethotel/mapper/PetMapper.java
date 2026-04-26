package com.pethotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.pethotel.dto.PetListRequestDto;
import com.pethotel.dto.PetUpdateRequestDto;
import com.pethotel.dto.PetListResponseDto;
import com.pethotel.dto.PetUpdateResponseDto;

@Mapper
public interface PetMapper {
    //회원의 펫 정보들 저장
	public void add (List<PetListRequestDto> pdto);
	
	//펫정보 리스트 불러오기
	public List<PetListResponseDto> petList(Integer memberId);
	
	//펫한마리 정보 보기
	public PetUpdateResponseDto petDetail(int petId);
	
	//펫정보 수정
	public void petUpdate(@Param("petId") int petId,
			              @Param("pdto") PetUpdateRequestDto pdto);
	
	//펫삭제(상태 1로업데이트)
	public void petDelete(int petId);
	
	//컨펌폼에서 보여줄 펫리스트
	public List<PetListResponseDto> petResList(List<Integer> petIds);
	
}
