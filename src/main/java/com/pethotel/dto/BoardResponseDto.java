package com.pethotel.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class BoardResponseDto {

	private int board_id;
	
	private String title;
	
	private String content;
	
    private String nickname;
    
    private LocalDate created_at;
    
    private int view_count;
    
  
    
}
