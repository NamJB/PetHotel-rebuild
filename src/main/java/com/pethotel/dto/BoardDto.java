package com.pethotel.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDto {

	int id;
	
    int member_id;
    
    String user_id;
	
	String title;
	
	String content;
	
	LocalDateTime created_at;
	
	
}
