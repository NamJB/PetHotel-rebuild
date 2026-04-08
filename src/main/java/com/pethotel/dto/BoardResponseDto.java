package com.pethotel.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class BoardResponseDto {

	private int boardId;
	
	private String title;
	
	private String content;
	
    private String nickName;
    
    private LocalDate createdAt;
    
    private int viewCount;
    
  
    
}
