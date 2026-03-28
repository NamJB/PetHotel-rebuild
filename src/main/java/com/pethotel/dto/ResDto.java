package com.pethotel.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ResDto {
    
	String check_in;
	
	String check_out;
	
	int small_cnt;
	
	int medium_cnt;
	
	int large_cnt;
	
	int member_id;
	
	int id;

	
}
