package com.pethotel.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pethotel.dto.BoardRequestDto;
import com.pethotel.dto.BoardResponseDto;
import com.pethotel.dto.ResDto;
import com.pethotel.dto.ResListDto;
import com.pethotel.service.BoardService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {

	private final BoardService boardService;
	
	public BoardController(BoardService boardService) {
		
		this.boardService = boardService;
	}
	
	//게시판 리스트 뷰 반환
	@GetMapping("/list")
	public String question(Model model,BoardRequestDto bdto) {
        
		List<BoardResponseDto> list = boardService.ListBoard(bdto);
		
		model.addAttribute("list",list);
		
		return "board/list";
	}
	
	//게시판 글쓰기 뷰 반환
	@GetMapping("/write")
	public String write() {
		
		return "board/write";
	}
	
	//게시판 글쓰기 요청
	@PostMapping("/write")
	public String postWrite(BoardRequestDto bdto,HttpSession session) {
		
		Integer member_id = (Integer) session.getAttribute("member_id");
		
		bdto.setMember_id(member_id);
		
		boardService.postWrite(bdto);
		
		return "redirect:/board/list";
	}
	
	//게시판 글보기 뷰 반환
	@GetMapping("/view")
	public String getView(@RequestParam int board_id,Model model,BoardRequestDto bdto) {
		
		bdto.setBoard_id(board_id);
		
		BoardResponseDto board = boardService.detailBoard(bdto);
		
		model.addAttribute("board",board);
	   
	    
	    
		return "board/view";
	}
	
	//게시판 수정 뷰 반환
	@GetMapping("/update")
	public String update(@RequestParam int board_id,Model model,BoardRequestDto bdto) {
		
		BoardResponseDto board = boardService.detailBoard(bdto);
		
		model.addAttribute("board",board);
		
		return "board/update";
	}
	
	//게시판 수정 요청
	@PostMapping("/update")
	public String postUpdate(BoardRequestDto budto) {
		
		boardService.postUpdate(budto);
				
		return "redirect:/board/view?board_id="+budto.getBoard_id();
	}
	//게시판 삭제 요청
	@PostMapping("/delete")
	public String postDelete(int board_id) {
		
		boardService.postDelete(board_id);
		
		return "redirect:/board/list";
			
	}
	
	//마이페이지 뷰반환
	@GetMapping("/mypage")
	public String mypage(HttpSession session,Model model,BoardRequestDto bdto) {
			
		Integer member_id = (Integer) session.getAttribute("member_id");
		
		bdto.setMember_id(member_id);
			
		List<BoardResponseDto> Blist =boardService.ListBoard(bdto);
		List<ResListDto> Rlist = boardService.myRes(member_id);
			
		model.addAttribute("boardlist",Blist);
		model.addAttribute("reslist",Rlist);
			
		return "board/mypage";
	
	}
	

	
	
	
}
