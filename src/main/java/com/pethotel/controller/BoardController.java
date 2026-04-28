package com.pethotel.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pethotel.dto.BoardFormRequestDto;
import com.pethotel.dto.BoardListResponseDto;
import com.pethotel.dto.BoardDetailResponseDto;
import com.pethotel.dto.PetListResponseDto;
import com.pethotel.dto.ResSaveRequestDto;
import com.pethotel.dto.ResListResponseDto;
import com.pethotel.service.BoardService;
import com.pethotel.service.PetService;
import com.pethotel.service.ResService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/board")
public class BoardController {

	private final BoardService boardService;
	
	
	public BoardController(BoardService boardService) {
		
		this.boardService = boardService;				
	}
	
	//게시판 리스트 뷰 반환
	@GetMapping("/list")
	public String listForm(Model model,BoardFormRequestDto bdto) {
		
		return "board/list";
	}
	
	//게시판 글쓰기 뷰 반환
	@GetMapping("/write")
	public String writeForm() {
		
		return "board/write";
	}
	
	
	
	//게시판 글보기 뷰 반환
	@GetMapping("/{boardId}")
	public String getView(
			@PathVariable("boardId") Integer boardId,
			Model model){
		//뷰카운트 늘리기 
		BoardDetailResponseDto board = boardService.detailBoard(boardId);
				
		model.addAttribute("board",board);
	    
		return "board/detail";
	}
	
	//게시판 수정 뷰 반환
	@GetMapping("/{boardId}/update")
	public String update(
			@PathVariable("boardId") Integer boardId,
			Model model) {
		
		BoardDetailResponseDto board = boardService.detailBoard(boardId);
		
		model.addAttribute("board",board);
		
		return "board/write";
	}
	
	//마이페이지 뷰반환
	@GetMapping("/mypage")
	public String mypage(HttpSession session,Model model,BoardFormRequestDto bdto) {
			
		Integer memberId = (Integer) session.getAttribute("memberId");
		
		if(memberId == null) {
			
			return "user/login";
		}
			
		return "board/mypage";			
	}

}
