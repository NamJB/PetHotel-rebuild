package com.pethotel.admin.service;

import java.util.List;

import com.pethotel.admin.dto.AdminDashboardResponseDto;
import com.pethotel.admin.dto.AdminReservationDto;
import com.pethotel.admin.dto.AdminTodayReservationResponseDto;

public interface AdminService {

	public AdminTodayReservationResponseDto getReservationToday();
	
	public AdminDashboardResponseDto getDashboard();
}
