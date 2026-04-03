package com.pethotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pethotel.dto.MyResDto;
import com.pethotel.dto.PetInfoDto;
import com.pethotel.dto.ResDto;

@Mapper
public interface ResMapper {

	//예약저장
	public void save(ResDto RDto);
    
	//펫예약 저장
	public void savePet(List<PetInfoDto> list);
	
	//사용자의 예약정보와 펫정보 가져오기
    public ResDto getMyres(int res_id);
    
	
	
	public MyResDto getView(int id);
	
	public void resDelete(int id);
			
	public ResDto getResById(int id);
	
	public void petDelete(int id);
	
	public void postUpdate(ResDto rdto);
	
}
