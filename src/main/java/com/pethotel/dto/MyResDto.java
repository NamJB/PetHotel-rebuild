package com.pethotel.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MyResDto {
   
	int id;
	
	int member_id;
	
	String check_in;
	
	String check_out;
	
	String status;
	
	LocalDateTime created_at;
	
	int res_id;
	
	String dog_type;
	
	int count;
	
	
	
}
