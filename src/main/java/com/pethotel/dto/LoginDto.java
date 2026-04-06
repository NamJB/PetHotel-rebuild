package com.pethotel.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDto {
   
	@NotBlank(message = "아이디를 입력")
	String userid;
	
	@NotBlank(message = "비밀번호를 입력")
	String pwd;
}
