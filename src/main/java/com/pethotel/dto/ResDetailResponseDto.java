package com.pethotel.dto;


import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ResDetailResponseDto {

	private Integer resId; //예약 고유번호
	private String checkIn; //예약 체크인
	private String checkOut; //예약 체크아웃
	private String status; //예약상태
    private String reservationCreatedAt; //예약한날짜
	private Integer reservationAmount; //결제해야할 금액
	
	private String nickName; // 유저 닉네임
	
	private Integer payId; //결제 고유번호 	
	private Integer paymentAmount; //결제된 금액
	private String payMethod; //결제 수단
	private String payStatus; //결제 상태
	private String paidAt; //결제된 날짜
	
	private List<PetListResponseDto> pets;
}
