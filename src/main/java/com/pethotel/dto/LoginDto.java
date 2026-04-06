package com.pethotel.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LoginDto {
   
	@NotBlank(message = "아이디를 입력")
	private String userid;
	
	@NotBlank(message = "비밀번호를 입력")
	private String pwd;
	
	
}
