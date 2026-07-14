package com.pethotel.reservation.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pethotel.payment.mapper.PaymentMapper;
import com.pethotel.payment.service.PaymentService;
import com.pethotel.reservation.dto.ResDetailResponseDto;
import com.pethotel.reservation.dto.ResListResponseDto;
import com.pethotel.reservation.dto.ResSaveRequestDto;
import com.pethotel.reservation.dto.ReservationResponseDto;
import com.pethotel.reservation.dto.ResupdateDto;
import com.pethotel.reservation.mapper.ResMapper;

@Service
public class ResServiceImpl implements ResService {

	private final ResMapper resMapper;
	private final PaymentService paymentService;
	private final PaymentMapper paymentMapper;
	
	public ResServiceImpl(
			ResMapper resMapper,
			PaymentService paymentService,
			PaymentMapper paymentMapper) {
		
		this.resMapper = resMapper;
		this.paymentService = paymentService;
		this.paymentMapper = paymentMapper;
	}
		
	@Override
	@Transactional 
    public void saveReservation(ResSaveRequestDto rdto) {
		
		//날짜비교 
		LocalDate checkInDate = LocalDate.parse(rdto.getCheckIn());
		LocalDate checkOutDate = LocalDate.parse(rdto.getCheckOut());
		LocalDate today = LocalDate.now();
		
		if(checkInDate.isBefore(today)) {
			
			throw new RuntimeException("과거의 날짜로는 예약이 불가능합니다 ");
		}
		
	    if(checkInDate.isAfter(checkOutDate)) {
	    	
	    	throw new RuntimeException("체크아웃날짜가 더 빠를 수 없습니다 ");
	    }
		
		resMapper.resSave(rdto);
		resMapper.petSave(rdto);
		
         
	}
	
	@Override
	@Transactional
	public void cancelReservation(Integer resId,Integer memberId) {
		
        if(memberId == null) {    		
        	
        	throw new RuntimeException("401 : 로그인필요");   		
    	}
	    
        Integer reservationMemberId = resMapper.getReservationMemberId(resId);
	    
        if(!memberId.equals(reservationMemberId)) {
    		
        	throw new RuntimeException("403 : 권한없음");
    	}        
        
        String impUid= paymentMapper.getImpUid(resId);
        
        if(impUid !=null && !impUid.isBlank()) {
        	
        	paymentService.cancelPayment(impUid);
    		
            paymentMapper.cancelStatus(resId);
        }        
        
		resMapper.cancelReservation(resId);
	}
	  
    
    @Override
	public ResDetailResponseDto resDetail(Integer resId,Integer memberId) {
		
		return resMapper.resDetail(resId,memberId);
		
	}
    
    @Override
	public List<ResListResponseDto> getMyReservationList(Integer memberId) {
		
		return resMapper.getMyReservationList(memberId);
	}
    
    
    
    @Override
    public void getReservationInfo(
    		Integer resId,
    		Integer memberId) {
        if(resId == null ) {
    		
    		throw new RuntimeException("400 : 잘못된 요청 ");
    	}
    	
    	ReservationResponseDto reservation =resMapper.getReservationInfo(resId);   
    	System.out.println(reservation);
    	if(reservation == null ) {
    		
    		throw new RuntimeException("404 : 예약이 존재하지않음");
    	}
    	
    	if(!reservation.getMemberId().equals(memberId)) {
    		
    		throw new RuntimeException("403 : 권한이 없음" );
    	}
    	
    	if(!reservation.getStatus().equals("PENDING_PAYMENT")) {
    		
    		throw new RuntimeException("409 : 이미 결제가 됐거나 취소된 예약");
    	}
 	
    	//
    	
    }
    
    
	
}


  
