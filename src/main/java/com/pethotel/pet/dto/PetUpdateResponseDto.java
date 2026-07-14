package com.pethotel.pet.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class PetUpdateResponseDto {

	private int petId;
	
	private String name;
	
	private String type;
	
	private int age;
	
	private String gender;
	
	private double weight;
	
	private String note;
	
	
	
	
	
}
