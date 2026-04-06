package com.pethotel.dto;

public class Criteria {

	int page;
	
	int size;
	
	public Criteria() {
		
		this.page = 1;
		
		this.size = 10;
	}
	
	public int offset() {
		
		return (this.page-1)*this.size;
	}

}
