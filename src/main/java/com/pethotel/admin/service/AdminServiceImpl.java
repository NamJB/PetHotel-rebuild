package com.pethotel.admin.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pethotel.admin.dto.AdminReservationDto;
import com.pethotel.admin.dto.AdminTodayReservationResponseDto;
import com.pethotel.admin.mapper.AdminMapper;

@Service
public class AdminServiceImpl implements AdminService {

	private final AdminMapper adminMapper;
	
	public AdminServiceImpl(AdminMapper adminMapper) {
		
		this.adminMapper = adminMapper;
	}
	
	
	
	public AdminTodayReservationResponseDto getReservationToday() {
		//오늘 날짜 불러오기
		LocalDate today = LocalDate.now();
		
		// 오늘 날짜 넣어서 오늘 체크인하는 예약가져오기 
	    List<AdminReservationDto> checkIns = adminMapper.getReservationTodayCheckIns(today);
	    
	    // 오늘 날짜 넣어서오늘 체크아웃 하는 예약 가져오기 
	    List<AdminReservationDto> checkOuts = adminMapper.getReservationTodayCheckOuts(today);
		
	    //리턴 해주기위해 하나로 합쳐주기 
	    AdminTodayReservationResponseDto response = new AdminTodayReservationResponseDto();
	    
	    response.setCheckIns(checkIns);
	    response.setCheckOuts(checkOuts);
	    
		// todo : db연동 전 임시데이터 나중엔 today만 보내서 db연결후 
		// 오늘체크인 예약,오늘 체크아웃인 예약 따로 표기예정,현재 투숙? 하고있는 예약은 보여줄지말지 고민중 

		return response;
	}
}
