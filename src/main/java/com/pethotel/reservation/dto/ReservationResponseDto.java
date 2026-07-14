package com.pethotel.reservation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class ReservationResponseDto {

	private Integer resId;
	
	private Integer memberId;
	
	private String status;
	
}
