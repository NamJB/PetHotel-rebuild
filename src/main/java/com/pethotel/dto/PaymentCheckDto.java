package com.pethotel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PaymentCheckDto {

	private String imp_uid;     // 포트원 결제 고유번호
    
	private String merchant_uid; // 우리가 보낸 "RES_105" 형태의 주문번호
    
	private int resId;          // 실제 DB 업데이트에 쓸 예약 번호
   
	private int amount;         // 검증용 결제 금액
	
}
