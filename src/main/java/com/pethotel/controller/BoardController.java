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
	private final PetService petService;
	private final ResService resService;
	
	public BoardController(BoardService boardService,PetService petService,ResService resService) {
		
		this.boardService = boardService;
		
		this.petService = petService;
		
		this.resService = resService;
		
	}
	
	
	//게시판 리스트 뷰 반환
	@GetMapping("/list")
	public String list(Model model,BoardRequestDto bdto) {
		
		return "board/list";
	}
	
	//게시판 글쓰기 뷰 반환
	@GetMapping("/write")
	public String write() {
		
		return "board/write";
	}
	
	//게시판 글쓰기 요청
	@PostMapping("/write")
	public String postWrite(@Valid BoardRequestDto bdto,HttpSession session) {
		
		Integer memberId = (Integer) session.getAttribute("memberId");
		
		bdto.setMemberId(memberId);
		
		boardService.postWrite(bdto);
		
		return "redirect:/board/list";
	}
	
	//게시판 글보기 뷰 반환
	@GetMapping("/view")
	public String getView(Model model,BoardRequestDto bdto) {
		
		/*bdto.setBoardId(bdto.getBoardId());*/
		
		BoardResponseDto board = boardService.detailBoard(bdto);
		
		model.addAttribute("board",board);
	   
    
		return "board/view";
	}
	
	//게시판 수정 뷰 반환
	@GetMapping("/update")
	public String update(Model model,BoardRequestDto bdto) {
		
		BoardResponseDto board = boardService.detailBoard(bdto);
		
		model.addAttribute("board",board);
		
		return "board/update";
	}
	
	//게시판 수정 요청
	@PostMapping("/update")
	public String postUpdate(BoardRequestDto bdto) {
		
		boardService.postUpdate(bdto);
				
		return "redirect:/board/view?board_id="+bdto.getBoardId();
	}
	//게시판 삭제 요청
	@PostMapping("/delete")
	public String postDelete(@RequestParam int  boardId) {
		
		boardService.postDelete(boardId);
		
		return "redirect:/board/list";
			
	}
	
	//마이페이지 뷰반환
	@GetMapping("/mypage")
	public String mypage(HttpSession session,Model model,BoardRequestDto bdto) {
			
		Integer memberId = (Integer) session.getAttribute("memberId");
		
		bdto.setMemberId(memberId);
			
		List<BoardResponseDto> Blist =boardService.ListBoard(bdto);
		List<ResListResponseDto> Rlist = resService.getMyReservationList(memberId);
		List<PetListResponseDto> plist = petService.petList(memberId);
			
		model.addAttribute("boardlist",Blist);
		model.addAttribute("reslist",Rlist);
		model.addAttribute("petList",plist);
			
		return "board/mypage";
	
		
	}
	
	
}
