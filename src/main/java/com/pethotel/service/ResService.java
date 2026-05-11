package com.pethotel.service;

import java.util.List;

import com.pethotel.dto.ResDetailResponseDto;
import com.pethotel.dto.ResListResponseDto;
import com.pethotel.dto.ResSaveRequestDto;
import com.pethotel.dto.ReservationResponseDto;

public interface ResService {

	public void saveReservation(ResSaveRequestDto RDto);
	
	public void cancelReservation(Integer resId,Integer memberId);		
	
	public ResDetailResponseDto resDetail(Integer resId,Integer memberId);
	
	public List<ResListResponseDto> getMyReservationList(Integer memberId);
		
	public void getReservationInfo(Integer resId,Integer memberId);
	
}
	