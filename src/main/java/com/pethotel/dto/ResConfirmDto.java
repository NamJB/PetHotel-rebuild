package com.pethotel.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@Setter
public class ResConfirmDto {

	private String checkIn;
	
	private String checkOut;
	
	//나중에 가격합,몇박몇일넣어야함
	
	private List<PetListResponseDto> selectPets;
	
	
	
	
	
	
}
