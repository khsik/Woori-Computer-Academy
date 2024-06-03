package com.example.ex.board;

import java.security.Principal;

import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ex.member.Member;
import com.example.ex.member.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board/*")
public class BoardController {

	private final BoardService boardService;
	private final MemberService memberService;
	
	@GetMapping("list")
	public String list(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "search", defaultValue = "") String search) {
		Page<Board> paging = this.boardService.getPaging(page, search);
		model.addAttribute("paging", paging);
		model.addAttribute("search", search);
		return "board/list";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("upload")
	public String uploadPost(BoardForm boardForm) {
		
		return "board/upload";
	}
	
	@PostMapping("upload")
	public String uploadPost(@Valid BoardForm boardForm, BindingResult bindingResult, Principal principal) {
		if(bindingResult.hasErrors()) {
			return "board/upload";
		}
		Member member = this.memberService.getMember(principal.getName());
		long num = this.boardService.save(boardForm, member);
		
		return "redirect:/board/post/"+num;
	}
	
	@GetMapping("post/{num}")
	public String getPost(@PathVariable("num") long num, Model model) {
		Board board = this.boardService.getBoard(num);
		model.addAttribute("board", board);
		return "board/post";
	}
}
