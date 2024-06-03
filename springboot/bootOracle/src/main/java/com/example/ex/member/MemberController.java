package com.example.ex.member;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MemberController {

	private final MemberService memberService;
	
	@GetMapping("/main")
	public String goMain() {
		return "main";
	}
	
	@GetMapping("/")
	public String goMain2() {
		return "redirect:/main";
	}
	
	@GetMapping("/member/join")
	public String join(MemberCreateForm memberCreateForm) {
		return "/member/join";
	}
	
	@PostMapping("/member/join")
	public String join(@Valid MemberCreateForm memberCreateForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "/member/join";
		}else if(!memberCreateForm.getPw().equals(memberCreateForm.getPw2())) { // 비밀번호 확인
			bindingResult.reject("password double check", "두 비밀번호가 일치하지 않습니다.");
			return "/member/join";
		}else if(this.memberService.overlap(memberCreateForm.getId())) { // id 중복
			bindingResult.reject("id overlap check", "이미 사용중인 아이디 입니다.");
			return "/member/join";
		}
		
		this.memberService.joinMember(memberCreateForm);
		return "redirect:/main";
	}
	
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
}
