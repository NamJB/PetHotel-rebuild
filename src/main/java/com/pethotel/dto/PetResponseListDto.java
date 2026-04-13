package com.pethotel.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class PetResponseListDto {

	private int petId;
	
	private int age;
	
	private String name;
	
	private String type;
	
	private String gender;
	
	private String note;
	
	private double weight;
	
	private LocalDate createdAt;
	
}
