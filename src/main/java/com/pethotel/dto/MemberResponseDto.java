package com.pethotel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class MemberResponseDto {

	private String userId;
	
	private String userName;
	
	private  String phone;
	
	private int memberId;
	
	private String nickName;
	
	
	
}
