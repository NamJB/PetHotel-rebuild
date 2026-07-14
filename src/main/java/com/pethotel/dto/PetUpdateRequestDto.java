package com.pethotel.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PetUpdateRequestDto {

	private Integer petId;
	
	private String name;
	
	private String type;
	
	private int age;
	
	private String gender;
	
	private double weight;
	
	private String note;
	
	
	
}
