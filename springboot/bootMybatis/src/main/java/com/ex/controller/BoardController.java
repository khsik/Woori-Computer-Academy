package com.ex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ex.data.BoardDTO;
import com.ex.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
	private final BoardService boardService;

	// 글 작성
	@GetMapping("writeForm")
	public String writeForm(BoardDTO boardDTO, @RequestParam(name = "num", defaultValue = "0") int num, Model model) {
		if(num != 0) {
			boardDTO = boardService.boardNum(num);
			model.addAttribute("boardDTO", boardDTO);
		}
		return "writeForm";
	}
	
	@PostMapping("writePro")
	public String writePro(BoardDTO boardDTO) {
		boardService.boardInsert(boardDTO);
		return "redirect:/board/list";
	}
	
	@GetMapping("list")
	public String list(Model model,
					@RequestParam(name = "pageNum", defaultValue = "1") int pageNum) {
		int pageSize = 10;
		int currentPage = pageNum;
		int start = (currentPage-1)*pageSize + 1;
		int end = currentPage*pageSize;
		int count = boardService.boardCount();
		List<BoardDTO> list = null;
		if(count > 0) {
			list = boardService.boardList(start, end);
		}
		
		int pageCount = count / pageSize + (count%pageSize == 0 ? 0 : 1);
		int pageBlock = 10;
		int startPage = (int)((currentPage-1)/pageBlock) * pageBlock + 1;
		int endPage = startPage + pageBlock - 1;
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		model.addAttribute("count", count);
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("pageBlock", pageBlock);
		
		model.addAttribute("list", list);
		return "list";
	}
	
	@GetMapping("content")
	public String view(@RequestParam("num") int num, Model model, @ModelAttribute("pageNum")int pageNum) {
		BoardDTO boardDTO = boardService.boardNum(num);
		boardService.readCountUp(num);
		model.addAttribute("boardDTO", boardDTO);
		return "content";
	}
	
	// 삭제
	@GetMapping("delete")
	public String boardDelete(@RequestParam("num") int num, Model model) {
		model.addAttribute("num", num);
		return "delete";
	}
	
	@PostMapping("delete")
	public String boardDelete(@RequestParam("num") int num, @RequestParam("passwd") String passwd, Model model) {
		if(passwd.equals(boardService.passwdNum(num))) {
			boardService.boardDelete(num);
			return "redirect:/board/list";
		}else {
			model.addAttribute("num", num);
			return "delete";
		}
	}
	
	// 수정
	@GetMapping("update")
	public String boardUpdate(@RequestParam("num") int num, Model model) {
		BoardDTO boardDTO = boardService.boardNum(num);
		model.addAttribute("boardDTO", boardDTO);
		return "updateForm";
	}
	
	@PostMapping("update")
	public String boardUpdate(BoardDTO boardDTO) {
		String orgPasswd = boardService.passwdNum(boardDTO.getNum());
		if(orgPasswd.equals(boardDTO.getPasswd())) {
			boardService.boardUpdate(boardDTO);
			return "redirect:/board/list";
		}else {
			return "updateForm";
		}
	}
	
}
