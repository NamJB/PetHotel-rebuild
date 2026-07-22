package com.pethotel.reservation.service;

import java.util.List;

import com.pethotel.reservation.dto.ResDetailResponseDto;
import com.pethotel.reservation.dto.ResListResponseDto;
import com.pethotel.reservation.dto.ResSaveRequestDto;
import com.pethotel.reservation.dto.ReservationResponseDto;

public interface ResService {

	public void saveReservation(ResSaveRequestDto RDto);
	
	public void cancelReservation(Integer resId,Integer memberId);		
	
	public ResDetailResponseDto resDetail(Integer resId,Integer memberId);
	
	public List<ResListResponseDto> getMyReservationList(Integer memberId);
		
	public void getReservationInfo(Integer resId,Integer memberId);
	
}
	