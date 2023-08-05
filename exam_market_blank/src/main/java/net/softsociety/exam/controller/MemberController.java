package net.softsociety.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.exam.domain.Member;
import net.softsociety.exam.service.MemberService;

/**
 * 회원 정보 관련 콘트롤러
 */

@Slf4j
@RequestMapping("member")
@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	
	//회원가입 폼 이동
	@GetMapping("join")
	public String join() {
		return "/member/join";
	}
	
	// 회원가입 저장
	@PostMapping("join")
	public String MemberJoin(Member member){
		
		int i = service.MemberJoin(member);
		
		return "redirect:/";
		
	}
	
	// 로그인 요청
	@PostMapping("login")
	public String login(Member member, Model model) {
		
		int i = service.login(member);
		String NoID = "아이디가 존재하지 않습니다";
		
		if(i < 1) {
			model.addAttribute("NoID",NoID);
		}
		
		return "redirect:/";
	}
	
}