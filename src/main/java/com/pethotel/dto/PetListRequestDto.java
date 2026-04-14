package com.pethotel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PetListRequestDto {

	private int memberId; //멤버아이디
	
	private String name; // 이름
	
	private String type; //견종
	
	private int age; //나이
	
	private double weight; //무게
	
	private String gender; //성별
	
	private String note; //메모,주의사항?
	
	
}
