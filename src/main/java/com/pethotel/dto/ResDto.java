package com.pethotel.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class ResDto {
    
 
	int res_id;	
	
	int member_id;
	
	String check_in;
	
	String check_out;
	
	List<PetInfoDto> pets;

	
}
