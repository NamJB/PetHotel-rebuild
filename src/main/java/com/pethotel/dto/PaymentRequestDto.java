package com.pethotel.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PaymentRequestDto {

	private Integer resId; //예약 고유번호
	private Integer memberId; //유저의 고유번호
	
	
	private String impUid; // 포트원 결제 고유번호
	private String merchantUid; //  "RES_105" 형태의 주문번호
	
	private Integer amount;//실제 결제금액
	
	
	private String payMethod; //결제수단
	private String payStatus; //결제상태
	
	
	private LocalDateTime paidAt; //실제 결제 시간
	

	
	
}
