package com.pethotel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberRequestDto {
    
	@NotBlank
	@Size(min = 4, max = 15, message = "아이디 4~15자 사이")
	@Pattern(regexp = "^[a-zA-Z0-9]*$") //영어 + 숫자
	String userId;
	
	@NotBlank
	@Size(min = 8,max= 20 ,message = "비민번호 8~20자 사이")
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$", message = "비빌번호는 영어 숫자 특수문자 넣어야합니다") //영어 +숫자 + 특수만자
	String pwd;	
	
	@NotBlank
	@Size(min = 3 ,max= 15 ,message = "이름 제대로 적어주세요")
	@Pattern(regexp = "^[가-힣]*$" ,message = "성함 한글만 가능") //한글만
	String userName;
	
	@NotBlank
	@Size(min = 1 ,max = 15 ,message = "닉네임 제대로 적어주세요")
	String nickName;
 
	int member_id;
	
	@NotBlank
	String phone;
	
}
