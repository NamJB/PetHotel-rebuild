package com.pethotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.pethotel.dto.ResSaveRequestDto;
import com.pethotel.dto.ReservationResponseDto;
import com.pethotel.dto.ResDetailResponseDto;
import com.pethotel.dto.ResListResponseDto;
import com.pethotel.dto.ResupdateDto;

@Mapper
public interface ResMapper {

	//예약저장
	public void resSave(ResSaveRequestDto rdto);
     
	//펫예약 저장
	public void petSave(ResSaveRequestDto rdto);
	
	//사용자의 예약정보와 펫정보 가져오기
    public ResDetailResponseDto resDetail(
    		@Param("resId") Integer resId,
    		@Param("memberId") Integer memberId); 
      
    //예약취소(staus업데이트)
    public void cancelReservation(int resId);
	
    //나의 예약정보리스트
  	public List<ResListResponseDto> getMyReservationList(Integer memberId);
  	
  	
    //예약 금액 가져오기 
  	public Integer getAmount(Integer resId);
  	
  	
  	public void updatePaid(Integer resId);
  	
  	//예약 사용자id불러오기
    public Integer getReservationMemberId(Integer resId);
    
    //예약된 정보 가져오기
    public ReservationResponseDto getReservationInfo(Integer resId);
	
	
	
}
