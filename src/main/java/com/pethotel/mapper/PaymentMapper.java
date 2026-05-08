package com.pethotel.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.pethotel.dto.PaymentRequestDto;

@Mapper
public interface PaymentMapper {
	//포트원결제내역 db insert
	public void insertPayment(PaymentRequestDto pamentDto);
}
