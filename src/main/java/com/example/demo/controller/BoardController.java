package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.BoardDto;
import com.example.demo.service.BoardService;

@Controller
public class BoardController {

	private final BoardService boardService;
	
	public BoardController(BoardService boardService) {
		
		this.boardService = boardService;
	}
	
	//게시판 뷰 반환
	@GetMapping("/board/question")
	public String question(Model model) {
        
		List<BoardDto> list = boardService.getList();
		
		model.addAttribute("list",list);
		
		return "board/question";
	}
	
	//게시판 글쓰기 뷰 반환
	@GetMapping("/board/write")
	public String write() {
		
		return "board/write";
	}
	
	//게시판 글쓰기 요청
	@PostMapping("/board/write")
	public String postWrite(BoardDto bDto) {
		
		boardService.postWrite(bDto);
		
		return "redirect:/board/question";
	}
	
	//게시판 글보기 뷰 반환
	@GetMapping("/board/view")
	public String getView(@RequestParam int id,Model model) {
		
		BoardDto board = boardService.getView(id);
		
		model.addAttribute("board",board);
		
		return "board/view";
	}
}
