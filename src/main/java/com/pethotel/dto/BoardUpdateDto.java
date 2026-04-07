package com.pethotel.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardUpdateDto {
	
	
	@NotBlank
	private int board_id;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String content;
	
	
}
