package com.pethotel.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ResupdateDto {

	@NotBlank
	private String checkIn;
	
	@NotBlank
	private String checkOut;
	
	@NotBlank
	private int resId;
	
	//@NotBlank
	//private List<PetDto> pets;
}
