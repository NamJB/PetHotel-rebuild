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
	private String check_in;
	
	@NotBlank
	private String check_out;
	
	@NotBlank
	private int res_id;
	
	@NotBlank
	private List<PetInfoDto> pets;
}
