package com.pethotel.admin.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pethotel.admin.dto.AdminDashboardResponseDto;
import com.pethotel.admin.dto.AdminReservationDto;

@Mapper
public interface AdminMapper {

	//오늘 체크인 하는 예약들 
	public List<AdminReservationDto> getReservationTodayCheckIns(LocalDate today);
	
	//오늘 체크아웃하는 예약들
	public List<AdminReservationDto> getReservationTodayCheckOuts(LocalDate today);
	
	//대시보드 
	public AdminDashboardResponseDto getCheckDashboard(LocalDate today);
	
}
