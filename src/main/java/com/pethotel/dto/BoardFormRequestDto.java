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
public class BoardFormRequestDto {

	
	private Integer writerId; //작성자
	
	@NotBlank
	private String boardType; // 보드타입 
	
	@NotBlank
	private String title; // 제목 
	
	@NotBlank
	private String content; // 내용 
	
	
	private String secretYN = "N"; //비밀글 여부 	
	
}
