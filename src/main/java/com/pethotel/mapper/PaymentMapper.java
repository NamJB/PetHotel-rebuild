package com.pethotel.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.pethotel.dto.PaymentRequestDto;

@Mapper
public interface PaymentMapper {

	public void insertPayment(PaymentRequestDto pamentDto);
}
