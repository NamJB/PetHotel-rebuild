package com.pethotel.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
    
	
	private int memberId;
	
	@NotBlank
	private  String checkIn;
	
	@NotBlank
	private String checkOut;
	
	@NotEmpty
	private List<Integer> petIds;
	
	private int resId;
	
	
	
	

	
}
