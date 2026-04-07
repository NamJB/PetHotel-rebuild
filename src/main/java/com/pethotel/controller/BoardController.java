package com.pethotel.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pethotel.dto.BoardDto;
import com.pethotel.dto.BoardListDto;
import com.pethotel.dto.BoardResponseDto;
import com.pethotel.dto.BoardUpdateDto;
import com.pethotel.dto.ResDto;
import com.pethotel.dto.ResListDto;
import com.pethotel.service.BoardService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {

	private final BoardService boardService;
	
	public BoardController(BoardService boardService) {
		
		this.boardService = boardService;
	}
	
	//게시판 리스트 뷰 반환
	@GetMapping("/board/list")
	public String question(Model model) {
        
		List<BoardListDto> list = boardService.getList();
		
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
	public String postWrite(BoardDto bDto,HttpSession session) {
		
		Integer member_id = (Integer) session.getAttribute("member_id");
		
		bDto.setMember_id(member_id);		
		boardService.postWrite(bDto);
		
		return "redirect:/board/list";
	}
	
	//게시판 글보기 뷰 반환
	@GetMapping("/board/view")
	public String getView(@RequestParam int board_id,Model model) {
		
		BoardResponseDto board = boardService.getView(board_id);
		
		model.addAttribute("board",board);
		
		return "board/view";
	}
	
	//게시판 수정 뷰 반환
	@GetMapping("/board/update")
	public String update(@RequestParam int board_id,Model model) {
		
		BoardResponseDto board = boardService.getView(board_id);
		
		model.addAttribute("board",board);
		
		return "board/update";
	}
	
	//게시판 수정 요청
	@PostMapping("/board/update")
	public String postUpdate(BoardUpdateDto budto) {
		
		boardService.postUpdate(budto);
		System.out.println(budto);
		return "redirect:/board/view?board_id="+budto.getBoard_id();
	}
	//게시판 삭제 요청
	@PostMapping("/board/delete")
	public String postDelete(int board_id) {
		
		boardService.postDelete(board_id);
		
		return "redirect:/board/list";
			
	}
	
	//마이페이지 뷰반환
	@GetMapping("/board/mypage")
	public String mypage(HttpSession session,Model model) {
			
		Integer member_id = (Integer) session.getAttribute("member_id");
			
			
		List<BoardListDto> Blist =boardService.myBoard(member_id);
		List<ResListDto> Rlist = boardService.myRes(member_id);
			
		model.addAttribute("boardlist",Blist);
		model.addAttribute("reslist",Rlist);
			
		return "board/mypage";
	
	}
	

	
	
	
}
