package com.pethotel.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criteria {


	private int page = 1;
	private int size = 10;
	
	public int getOffset() {
		
		return (page - 1)* size;
	}
	
	//페이지 음수로 안가게
	public void setPage(int page) {
		
		if(page <= 0 ) {
			this.page = 1;
		}
		else {
			this.page = page;
		}		
	}
	
	//사이즈값 어느정도 제한걸어서 보여줄게시물 db부담 줄이기
	public void setSize(int size) {
		
		if(size <= 0 || size > 100) {
			this.size = 10;
		}
		else {
			this.size = size;
		}
		
		
	}
}
