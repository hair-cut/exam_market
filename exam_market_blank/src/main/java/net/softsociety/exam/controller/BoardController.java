package net.softsociety.exam.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.exam.domain.Board;
import net.softsociety.exam.service.BoardService;

/**
 * 상품게시판 관련 콘트롤러
 */
@Slf4j
@RequestMapping("board")
@Controller
public class BoardController {
	
	@Autowired
	BoardService service;
	
	// 게시판 form 이동 후 조회
	@GetMapping("BoardInformation")
	public String BoardInformation(Model model) {
		
		ArrayList<Board> board = service.select();
		model.addAttribute("board", board);
		
		return "board/BoardInformation";
	}
	
	// 게시판 작성 form 이동
	@GetMapping("write")
	public String write() {
		return "board/write";
	}
	
	// 게시판 내용 저장
	@PostMapping("write")
	public String form_write(Board board,
			@AuthenticationPrincipal UserDetails user) {
		
		String id = user.getUsername();
		board.setMemberid(id);
		
		int i = service.form_write(board);
		
		return "redirect:/board/BoardInformation";
	}
	
	// 게시글 상세 조회
	@GetMapping("read")
	public String read(int boardnum) {
		
		int i = service.read(boardnum);
		
		return "redirect:/";
	}
}
