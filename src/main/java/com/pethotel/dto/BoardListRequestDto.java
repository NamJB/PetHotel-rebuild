package com.pethotel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter 
@ToString
@NoArgsConstructor
public class BoardListRequestDto {

	
	private Integer boardId;
	
	private Integer memberId;
	
	private String title;
	
	private String content;
	
	
}
