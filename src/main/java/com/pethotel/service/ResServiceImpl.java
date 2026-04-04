package com.pethotel.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pethotel.dto.MyResDto;
import com.pethotel.dto.PetInfoDto;
import com.pethotel.dto.ResDto;
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
    public void save(ResDto rdto) {
		
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
			
		}
		
		*/
		
		
		resMapper.save(rdto);
		
		int res_id = rdto.getRes_id();
		
		for(PetInfoDto pdto : rdto.getPets()) {
			pdto.setRes_id(res_id);			
		}
	    
		resMapper.savePet(rdto.getPets());
				
	}
	
	
	
	@Override
	public void resDelete(int res_id) {
		
		resMapper.resDelete(res_id);
	}
	
	
	@Override
	public ResDto getMyres(int res_id) {
		
		return resMapper.getMyres(res_id);
		
	}	
	
	
    @Override
    @Transactional
    public void postUpdate(ResDto rdto) {
    	
    	/* resMapper.postUpdate(rdto);
		
		int res_id = rdto.getId();
		
		resMapper.petDelete(res_id);
		
		
		if(rdto.getSmall_cnt() > 0) {
			
			PetInfoDto pdto = new PetInfoDto();
			pdto.setRes_id(res_id);
			pdto.setDog_type("small");
			pdto.setCount(rdto.getSmall_cnt());
			
			resMapper.savePet(pdto);
			
		}
        if(rdto.getMedium_cnt() > 0) {
			
			PetInfoDto pdto = new PetInfoDto();
			pdto.setRes_id(res_id);
			pdto.setDog_type("medium");
			pdto.setCount(rdto.getMedium_cnt());
			
			resMapper.savePet(pdto);
			
		}
        if(rdto.getLarge_cnt() > 0) {
			
			PetInfoDto pdto = new PetInfoDto();
			pdto.setRes_id(res_id);
			pdto.setDog_type("large");
			pdto.setCount(rdto.getLarge_cnt());
			
			resMapper.savePet(pdto);
			
			
			
		}
        */
    	resMapper.postUpdate(rdto);
    	resMapper.petDelete(rdto.getRes_id());
    	
    	int res_id = rdto.getRes_id();
    	
    	for(PetInfoDto pdto : rdto.getPets()) {
    		
    		pdto.setRes_id(res_id);
    	}
    	resMapper.savePet(rdto.getPets());
    	
    }
	
}


  
