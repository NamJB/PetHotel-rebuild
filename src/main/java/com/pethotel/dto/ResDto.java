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
public class ResDto {
    
	private int res_id;
	
	@NotBlank
	private int member_id;
	
	@NotBlank
	private  String check_in;
	
	@NotBlank
	private String check_out;
	
	@NotBlank
	private List<PetInfoDto> pets;
	
	
	
	

	
}
