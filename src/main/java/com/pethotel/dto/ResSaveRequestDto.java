package com.pethotel.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ResSaveRequestDto {
    
	private int resId;
	
	@NotBlank
	private int memberId;
	
	@NotBlank
	private  String checkIn;
	
	@NotBlank
	private String checkOut;
	
	@NotBlank
	private List<Integer> petIds;
	
	
	
	
	
	

	
}
