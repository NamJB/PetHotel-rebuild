package com.pethotel.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.pethotel.dto.ResSaveRequestDto;
import com.pethotel.dto.ResDetailResponseDto;
import com.pethotel.dto.ResListResponseDto;
import com.pethotel.dto.ResupdateDto;
import com.pethotel.mapper.ResMapper;

@Service
public class ResServiceImpl implements ResService {

	private final ResMapper resMapper;
	
	public ResServiceImpl(ResMapper resMapper) {
		
		this.resMapper = resMapper;
	}
		
	@Override
	@Transactional
    public void saveReservation(ResSaveRequestDto rdto) {
		
		//날짜비교 
		LocalDate checkInDate = LocalDate.parse(rdto.getCheckIn());
		LocalDate checkOutDate = LocalDate.parse(rdto.getCheckOut());
		LocalDate today = LocalDate.now();
		
		if(checkInDate.isBefore(today)) {
			
			throw new RuntimeException("과거의 날짜로는 예약이 불가능합니다 ");
		}
		
	    if(checkInDate.isAfter(checkOutDate)) {
	    	
	    	throw new RuntimeException("체크아웃날짜가 더 빠를 수 없습니다 ");
	    }
		
		resMapper.resSave(rdto);
		resMapper.petSave(rdto);
		
         
	}
	
	@Override
	public void cancelReservation(int resId) {
		
		resMapper.cancelReservation(resId);
	}
	  
    
    @Override
	public ResDetailResponseDto resDetail(int resId) {
		
		return resMapper.resDetail(resId);
		
	}
    
    @Override
	public List<ResListResponseDto> getMyReservationList(int memberId) {
		
		return resMapper.getMyReservationList(memberId);
	}
	
}


  
