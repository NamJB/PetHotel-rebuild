package com.pethotel.service;

import java.util.List;
import java.util.Map;

import com.pethotel.dto.MyResDto;
import com.pethotel.dto.PetInfoDto;
import com.pethotel.dto.ResDto;

public interface ResService {

	/*Map<String, Object> check(ResDto RDto);*/
	
	public void save(ResDto RDto);
	
	public List<PetInfoDto> resPet(int id);
	
	public MyResDto getView(int id);
	
	public void resDelete(int id);	
	
	public ResDto getUpdate(int id);
	
	public void postUpdate(ResDto rdto);
	//사용자의 예약정보와 펫정보 가져오기
	public ResDto getMyres(int res_id);
}
