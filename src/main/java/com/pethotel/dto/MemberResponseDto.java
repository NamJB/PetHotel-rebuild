package com.pethotel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class MemberResponseDto {

	private String userid;
	
	private String username;
	
	private  String phone;
	
	private int member_id;
	
	private String nickname;
	
	
	
}
