package com.pethotel.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pethotel.dto.BoardResponseDto;
import com.pethotel.service.BoardService;



@RestController
@RequestMapping("/api/board")
public class BoardApiController {

	private final BoardService boardService;
	
	public BoardApiController(BoardService boardService) {
		
		this.boardService = boardService;
	}
	
	@GetMapping("list")
	public ResponseEntity<?> getListData(
			@RequestParam(value = "boardType", defaultValue = "B02") String boardType){
		
		List<BoardResponseDto> list = boardService.listBoard(boardType);
		
		return ResponseEntity.ok(list);
		
	}

}
