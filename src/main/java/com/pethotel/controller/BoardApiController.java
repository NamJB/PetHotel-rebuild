package com.pethotel.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pethotel.dto.BoardListRequestDto;
import com.pethotel.dto.BoardListResponseDto;
import com.pethotel.service.BoardService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/board")
public class BoardApiController {

	private final BoardService boardService;
	
	public BoardApiController(BoardService boardService) {
		
		this.boardService = boardService;
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> getList(
			@RequestParam(value = "boardType", defaultValue = "ALL") String boardType){
		
		try {
			
			List<BoardListResponseDto> list = boardService.getBoardList(boardType);	
			
			return ResponseEntity.ok(list);	
		
		}catch(RuntimeException e) {
			
			return ResponseEntity.status(400).body("badrequest"+e.getMessage());
		}
		catch(Exception e) {
			
			return ResponseEntity.status(500).body("서"+e.getMessage());
		}
			
	}
	
	//게시판 글쓰기 요청
	@PostMapping("/write")
	public String postWrite(@Valid BoardListRequestDto bdto,HttpSession session) {
			
		Integer memberId = (Integer) session.getAttribute("memberId");
			
		bdto.setMemberId(memberId);
			
		boardService.postWrite(bdto);
			
		return "redirect:/board/list";
		
	
	}
	
}
