package com.planner.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.planner.dto.ReplyDTO;
import com.planner.dto.ReplyViewDTO;
import com.planner.service.ReplyService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyController {

	private final ReplyService replyService;
	
	@PostMapping("/insert")
	@ResponseBody
	public int replyInsert(ReplyDTO dto) {
		dto.setReply_reg(LocalDateTime.now());
		return replyService.replyInsert(dto);
	}
	
	@GetMapping("/list")
	public String replyList(Model model, @RequestParam("team_board_id")long team_board_id) {
		List<ReplyViewDTO> replyList = replyService.replyList(team_board_id);
		model.addAttribute("replyList", replyList);
		return "/team/board/reply";
	}
}