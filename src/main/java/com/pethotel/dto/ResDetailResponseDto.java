package com.pethotel.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ResDetailResponseDto {

	private int memberId;
	
	private int resId;
	
	private LocalDate checkIn;
	
	private LocalDate checkOut;
	
	private String status;
	
	private LocalDate createdAt;
	
	private String nickName;
	
	private List<PetListResponseDto> pets;
}
