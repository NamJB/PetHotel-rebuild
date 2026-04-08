package com.pethotel.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PetInfoDto {

	
	@NotBlank
	private int resId;
	
	@NotBlank
	private String size;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private int age;
	
	private String content;
	
	
	
	
	
	
	
	
}
