package com.pethotel.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pethotel.dto.BoardDto;
import com.pethotel.service.BoardService;

@Controller
public class BoardController {

	private final BoardService boardService;
	
	public BoardController(BoardService boardService) {
		
		this.boardService = boardService;
	}
	
	//게시판 뷰 반환
	@GetMapping("/board/list")
	public String question(Model model) {
        
		List<BoardDto> list = boardService.getList();
		
		model.addAttribute("list",list);
		
		return "board/list";
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
		
		return "redirect:/board/list";
	}
	
	//게시판 글보기 뷰 반환
	@GetMapping("/board/view")
	public String getView(@RequestParam int id,Model model) {
		
		BoardDto board = boardService.getView(id);
		
		model.addAttribute("board",board);
		
		return "board/view";
	}
	
	//게시판 수정 뷰 반환
	@GetMapping("/board/update")
	public String update(@RequestParam int id,Model model) {
		
		BoardDto board = boardService.getView(id);
		
		model.addAttribute("board",board);
		
		return "board/update";
	}
	
	//게시판 수정 요청
	@PostMapping("/board/update")
	public String postUpdate(BoardDto bDto) {
		
		boardService.postUpdate(bDto);
		
		return "redirect:/board/view?id="+bDto.getId();
	}
	//게시판 삭제 요청
	@PostMapping("/board/delete")
	public String postDelete(int id) {
		
		boardService.postDelete(id);
		
		return "redirect:/board/list";
			
	}
}
