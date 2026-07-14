package com.pethotel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardUpdateRequestDto {

	@NotNull
	private Integer boardId;
	
	@NotBlank
	private String boardType;
	
	@NotBlank
	private String content;
	
	@NotBlank
	private String title;
	
	private String secretYN ="N";
	
	
	private Integer memberId;
	
}
