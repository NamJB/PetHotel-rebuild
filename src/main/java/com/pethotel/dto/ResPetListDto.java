package com.pethotel.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ResPetListDto {

	private int petId;
	
	private String name;
	
	private String age;
	
	private String size;
	
	private String content;
	
	
}
