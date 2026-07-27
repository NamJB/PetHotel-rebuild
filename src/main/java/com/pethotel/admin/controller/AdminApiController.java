package com.pethotel.admin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethotel.admin.dto.AdminReservationDto;
import com.pethotel.admin.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminApiController {
	
	private final AdminService adminService;
	
	public AdminApiController(AdminService adminService) {
		
		this.adminService = adminService;
	}
	
	
	@GetMapping("/reservation/today")
	public ResponseEntity<?> todayReservation() {
				
		return ResponseEntity.ok(adminService.getReservationToday());
	}
	
	@GetMapping("/reservation/dashboard")
	public ResponseEntity<?> dashboard(){
		
		
		return ResponseEntity.ok(adminService.getDashboard());
	}

}
