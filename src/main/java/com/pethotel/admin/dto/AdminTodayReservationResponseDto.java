package com.pethotel.admin.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
/*
 *오늘의 날짜로 보내 오늘 체크인 하는 사람,체크아웃하는 사람 구분.
 * 
 * 
 * */
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminTodayReservationResponseDto {

	private List<AdminReservationDto> checkIns;
	
	private List<AdminReservationDto> checkOuts;
	
	private List<AdminReservationDto> stayReservation;
}
