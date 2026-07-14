package com.pethotel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PetListRequestDto {

	
	private Integer memberId; //멤버아이디
	
    @NotBlank
	private String name; // 이름
	
    @NotBlank
	private String type; //견종
	
    //int로0값을 받을지 아니면 Integer로 null이면 -1값 고정시킬지 고민중
	private int age; //나이
	
    @NotNull
	private Double weight; //무게
	
    @NotBlank
	private String gender; //성별
	
	private String note; //메모,주의사항?
	
	
}
