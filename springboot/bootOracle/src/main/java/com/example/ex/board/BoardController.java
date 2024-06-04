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
	
	// 게시글 목록 (검색, 페이지처리 포함)
	@GetMapping("list")
	public String list(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "search", defaultValue = "") String search) {
		Page<Board> paging = this.boardService.getPaging(page, search);
		model.addAttribute("paging", paging);
		model.addAttribute("search", search);
		return "/board/list";
	}
	
	// 게시글 ㅈ가성
	@PreAuthorize("isAuthenticated()")
	@GetMapping("upload")
	public String uploadPost(BoardForm boardForm) {
		
		return "/board/upload";
	}
	
	// 게시글 작성
	@PostMapping("upload")
	public String uploadPost(@Valid BoardForm boardForm, BindingResult bindingResult, Principal principal) {
		if(bindingResult.hasErrors()) {
			return "board/upload";
		}
		Member member = this.memberService.getMember(principal.getName());
		long num = this.boardService.save(boardForm, member);
		
		return "redirect:/board/post/"+num;
	}
	
	// 게시글 확인(보기)
	@GetMapping("post/{num}")
	public String getPost(@PathVariable("num") long num, Model model) {
		Board board = this.boardService.getBoard(num);
		model.addAttribute("board", board);
		return "/board/post";
	}
	
	// 게시글 수정
	@PreAuthorize("isAuthenticated()")
	@GetMapping("update/{num}")
	public String updatePost(Principal principal, @PathVariable("num") long num, BoardForm boardForm) {
		Board board = this.boardService.getBoard(num);
		if(board.getWriter().getId().equals(principal.getName())) { // 작성자 본인이 접근하면
			boardForm.setTitle(board.getTitle());
			boardForm.setContent(board.getContent());
			return "/board/upload";
		}else { // 작성자가 아닌데 접근한 경우
			return "redirect:/board/list";
		}
	}
	
	// 게시글 수정
	@PostMapping("update/{num}")
	public String updatePost(@PathVariable("num") long num, @Valid BoardForm boardForm, BindingResult bindingResult) {
		this.boardService.update(boardForm, num);
		return String.format("redirect:/board/post/%d", num);
	}
	
	// 게시글 삭제
	@GetMapping("delete/{num}")
	public String deletePost(Principal principal, @PathVariable("num") long num) {
		Board board = this.boardService.getBoard(num);
		if(board.getWriter().getId().equals(principal.getName())) {
			this.boardService.delete(board);
			return "redirect:/board/list";
		}else {
			return String.format("redirect:/board/post/%d", num);
		}
		
	}
	
}
