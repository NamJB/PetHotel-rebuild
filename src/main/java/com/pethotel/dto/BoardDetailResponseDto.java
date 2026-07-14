package com.pethotel.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 * 
 */

@Getter
@ToString
@NoArgsConstructor
public class BoardDetailResponseDto {

    private Integer boardId; //게시판 고유번호 
	
	private String nickName ; //게시판 작성자 // 
	
	private Integer viewCount; // 조회수
	
	private String title; //게시판 제목 
	
	private String boardType; //게시판 타	
	
	private String secretYN; //비밀글 여부YES or No
	
	private LocalDate createdAt; // 게시글 작성일 
	
	private LocalDate updateAt; // 게시글 수정
	
	private String content; //게시글 내용 
	
}
