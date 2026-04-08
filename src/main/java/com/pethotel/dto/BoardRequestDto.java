package com.pethotel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter 
@ToString
@NoArgsConstructor
public class BoardRequestDto {

	
	private Integer board_id;
	
	private Integer member_id;
	
	private String title;
	
	private String content;
	
	
}
