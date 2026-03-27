package com.pethotel.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.pethotel.dto.PetInfoDto;
import com.pethotel.dto.ResDto;

@Mapper
public interface ResMapper {

	public void save(ResDto RDto);

	public void savePet(PetInfoDto pdto);
}
