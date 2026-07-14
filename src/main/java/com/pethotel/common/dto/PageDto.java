package com.pethotel.common.dto;

import lombok.Getter;

@Getter
public class PageDto {

	
	private int startPage; //첫페이지 번호
	private int endPage; //마지막 페이지 번호
	
	private boolean prev; //이전버튼 보여줄지말지
	private boolean next; //다음페이지 보여줄지말지
	
	private int total; //전체 게시글 수
	private Criteria cri; // page,size정보
	
	public PageDto(Criteria cri,int total) {
		
		this.cri = cri;
		this.total = total;
		
		int viewSize = 10; // 페이지 10개씩 보여주기
		
		//현제페이지에서 끝페이지 계산하기 ,,올림
		this.endPage = (int) Math.ceil(cri.getPage() / (double) viewSize) * viewSize;
		
		//시작페이지 계산
		this.startPage = this.endPage - viewSize +1;
		
		//실제 마지막페이지 계산
		int realEnd = (int) Math.ceil(total/(double) cri.getSize());
		
		//끝페이지가 실제 페이지보다 크면 보정
		if(this.endPage > realEnd) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		
		this.next = this.endPage < realEnd;
	}
	
	
	
}
