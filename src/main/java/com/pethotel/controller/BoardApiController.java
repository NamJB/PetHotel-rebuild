package com.pethotel.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pethotel.dto.BoardFormRequestDto;
import com.pethotel.dto.BoardListResponseDto;
import com.pethotel.dto.BoardUpdateRequestDto;
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
	
	@GetMapping
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
	@PostMapping
	public ResponseEntity<?> postWrite(
			@Valid @RequestBody BoardFormRequestDto bdto,
			HttpSession session,
			BindingResult bindingResult) {
			
		System.out.println(bdto);
	    
		
		
		if(bindingResult.hasErrors()) {
			
			return ResponseEntity.badRequest().body(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		
		Integer memberId = (Integer) session.getAttribute("memberId");
		bdto.setWriterId(memberId);
		
	    try {
	    	
	    	boardService.postWrite(bdto);
	    	
	    	return ResponseEntity.ok("");
	    }
	    catch(Exception e){
	    	
	    	
	    	return ResponseEntity.status(500).body("글쓰기 서버 오류" + e.getMessage()); 
	    }
	
	}
	
	//게시판 수정 요청
    @PutMapping("/{boardId}")
    public ResponseEntity<?> postUpdate(
    		@PathVariable ("boardId") Integer boardId,
			@Valid @RequestBody BoardUpdateRequestDto bdto,
			BindingResult bindingResult,
			HttpSession session) {
		
        bdto.setBoardId(boardId);
    	
    	Integer memberId = (Integer) session.getAttribute("memberId");
    	
    	bdto.setMemberId(memberId);
        if(bindingResult.hasErrors()) {
			
		    return ResponseEntity.badRequest().body(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
        try {
        	
        	boardService.postUpdate(bdto);
			
    		return ResponseEntity.ok("수정성공");
        }
        catch(RuntimeException e) {
        	
        	return ResponseEntity.status(401).body("권한없음" + e.getMessage());
        }
        
        catch(Exception e) {
        	
        	return ResponseEntity.status(500).body("게시판수정500 오류 "+ e.getMessage());
        }
        
		
	}
    
    //게시판 삭제 요청
    @DeleteMapping("/{boardId}")
    public ResponseEntity<?> postDelete(
    		@PathVariable("boardId") Integer boardId,
    		HttpSession session) {
  	    
        Integer memberId = (Integer) session.getAttribute("memberId");
    	
  		boardService.boardDelete(boardId,memberId);
  		
  		return ResponseEntity.ok("");
  			
  	}
    
    //나의 글 가져오기 
    @GetMapping("/my")
    public ResponseEntity<?> getMyBoard(HttpSession session){
    	
    	Integer memberId = (Integer) session.getAttribute("memberId");
    	
    	List<BoardListResponseDto> board = boardService.getMyBoard(memberId);
    	
    	
    	return ResponseEntity.ok(board);
    	
    }
	
}
