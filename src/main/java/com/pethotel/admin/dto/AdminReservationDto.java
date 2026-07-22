package com.pethotel.admin.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AdminReservationDto {

	private int memberId;
	
	private int reservationId;
	
	private LocalDate checkIn;
	
	private LocalDate checkOut;
	
}
