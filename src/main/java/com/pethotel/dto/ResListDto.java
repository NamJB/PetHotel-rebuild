package com.pethotel.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ResListDto {
   
	private int resId;
	
	private LocalDate checkIn;
	
	private LocalDate checkOut;
	
	private String status;
	
	private LocalDate createdAt;
	
	private String nickName;
}
