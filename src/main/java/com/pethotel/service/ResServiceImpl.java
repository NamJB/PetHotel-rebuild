package com.pethotel.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.pethotel.dto.ResSaveRequestDto;
import com.pethotel.dto.ResDetailResponseDto;
import com.pethotel.dto.ResListResponseDto;
import com.pethotel.dto.ResupdateDto;
import com.pethotel.mapper.ResMapper;

@Service
public class ResServiceImpl implements ResService {

	private final ResMapper resMapper;
	
	public ResServiceImpl(ResMapper resMapper) {
		
		this.resMapper = resMapper;
	}
	
	
	/*@Override
	public Map<String, Object> check(ResDto RDto) {
		
		Map<String,Object> result = new HashMap<>();
		
		
		//체크인 체츠카웃 값 비어있는지 검사
		if(RDto.getCheck_in() ==null || RDto.getCheck_in().isEmpty() 
				|| RDto.getCheck_out() == null || RDto.getCheck_out().isEmpty()) {
			
			result.put("State", false);
			result.put("message", "체크인 체크아웃 날짜 입력해주세요");
			
			return result;
		}
		
		
		//반려 동물 마리수 검사
        if(RDto.getSmall_cnt() == 0 && RDto.getMedium_cnt() == 0 && RDto.getLarge_cnt() == 0) {
	    	
	    	result.put("State", false);
	    	result.put("message", "반려동물 수를 한마리 이상 입력");
	    	
	    	return result;	
	    }
        
        
        //날짜 비교를 위해 변환  
        LocalDate check_in = LocalDate.parse(RDto.getCheck_in());
        LocalDate check_out = LocalDate.parse(RDto.getCheck_out());
       
        
        //체크인아웃날짜가 체크인날짜보다 빠르면
        if(check_in.isAfter(check_out)) {
        	
        	result.put("State", false);
        	result.put("message", "날짜를 다시 체크해주세요");
        	
        	return result;
        }
        int max_Cnt = 20;
        
        LocalDate check_Date = check_in;
        
        //나중에 날짜 체크 만들어야함
        
        
	        result.put("State", true);
	        result.put("message", "예약가능");	
		
	
	    return result;
	    
	}
	*/
	
	//
	@Override
	@Transactional
    public void resSave(ResSaveRequestDto rdto) {
		
		/*resMapper.save(RDto);
		
		int res_id = RDto.getId();
		
		
		if(RDto.getSmall_cnt() > 0) {
			
			PetInfoDto pdto = new PetInfoDto();
			pdto.setRes_id(res_id);
			pdto.setDog_type("small");
			pdto.setCount(RDto.getSmall_cnt());
			
			resMapper.savePet(pdto);
			
		}
        if(RDto.getMedium_cnt() > 0) {
			
			PetInfoDto pdto = new PetInfoDto();
			pdto.setRes_id(res_id);
			pdto.setDog_type("medium");
			pdto.setCount(RDto.getMedium_cnt());
			
			resMapper.savePet(pdto);
			
		}
        if(RDto.getLarge_cnt() > 0) {
			
			PetInfoDto pdto = new PetInfoDto();
			pdto.setRes_id(res_id);
			pdto.setDog_type("large");
			pdto.setCount(RDto.getLarge_cnt());
			
			resMapper.savePet(pdto);		
			
		}*/
		

       
            
     /*       resMapper.save(rdto); 
           
            int resId = rdto.getResId();

            
            for (PetDto pet : rdto.getPets()) {
               
                pet.setResId(resId);
            }
         
            resMapper.savePet(rdto.getPets());
        */
		
		resMapper.resSave(rdto);
		
		if(rdto.getPetIds() !=null && !rdto.getPetIds().isEmpty()) {
			
			resMapper.petSave(rdto);
		}
         
	}
	
	@Override
	public void cancelReservation(int resId) {
		
		resMapper.cancelReservation(resId);
	}
	  
    
    @Override
	public ResDetailResponseDto resDetail(int resId) {
		
		return resMapper.resDetail(resId);
		
	}
    
    @Override
	public List<ResListResponseDto> getMyReservationList(int member_id) {
		
		return resMapper.getMyReservationList(member_id);
	}
	
}


  
