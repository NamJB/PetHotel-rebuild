package com.pethotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;



import com.pethotel.dto.ResSaveRequestDto;
import com.pethotel.dto.ResDetailResponseDto;
import com.pethotel.dto.ResupdateDto;

@Mapper
public interface ResMapper {

	//예약저장
	public void resSave(ResSaveRequestDto rdto);
    
	//펫예약 저장
	public void petSave(ResSaveRequestDto rdto);
	
	//사용자의 예약정보와 펫정보 가져오기
    public ResDetailResponseDto resDetail(int resId);
    
    //예약 수정
    public void postUpdate(ResupdateDto rdto);
    
    //펫삭제
    public void petDelete(int resId);
      
    //예약취소(staus업데이트)
    public void resDelete(int resId);
	
	
	
	
	
}
