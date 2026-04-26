package com.pethotel.service;

import java.util.List;
import java.util.Map;

import com.pethotel.dto.ResSaveRequestDto;
import com.pethotel.dto.ResDetailResponseDto;
import com.pethotel.dto.ResListResponseDto;
import com.pethotel.dto.ResupdateDto;

public interface ResService {

	public void saveReservation(ResSaveRequestDto RDto);
	
	public void cancelReservation(int resId);		
	
	public ResDetailResponseDto resDetail(int resId);
	
	public List<ResListResponseDto> getMyReservationList(Integer memberId);
	
}
	