package com.pethotel.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDto {

	int board_id;
	
    int member_id;
    
    String userid;
	
	String title;
	
	String content;
	
	LocalDateTime created_at;
	
	
}
