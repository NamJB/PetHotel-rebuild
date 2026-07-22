package com.pethotel.admin.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.pethotel.admin.dto.AdminReservationDto;

@Service
public class AdminServiceImpl implements AdminService {

	public AdminReservationDto getReservationToday() {
		
		LocalDate today = LocalDate.now();
		
		// todo : db연동 전 임시데이터 나중엔 today만 보내서 db연결후 
		// 오늘체크인 예약,오늘 체크아웃인 예약 따로 표기예정,현재 투숙? 하고있는 예약은 보여줄지말지 고민중 
		AdminReservationDto dto = new AdminReservationDto();
		dto.setCheckIn(today);
		dto.setCheckOut(LocalDate.of(2026, 7, 24));
		dto.setMemberId(1);
		dto.setReservationId(1);
		return dto;
	}
}
