package com.pethotel.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ResResponseDto {

	private int member_id;
	
	private int res_id;
	
	private LocalDate check_in;
	
	private LocalDate check_out;
	
	private String status;
	
	private LocalDate created_at;
	
	private String nickname;
	
	private List<ResPetListDto> pets;
}
