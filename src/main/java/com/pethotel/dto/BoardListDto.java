package com.pethotel.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class BoardListDto {

	private int board_id;
	
	private int member_id;
	
	private String title;
	
	private int view_count;
	
	private LocalDate created_at;
	
	private String nickname;
	
	
}
