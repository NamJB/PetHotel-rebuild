package com.pethotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pethotel.dto.MyResDto;
import com.pethotel.dto.PetInfoDto;
import com.pethotel.dto.ResDto;

@Mapper
public interface ResMapper {

	public void save(ResDto RDto);

	public void savePet(PetInfoDto pdto);
    
	public List<PetInfoDto> resPet(int id);
	
	public MyResDto getView(int id);
}
