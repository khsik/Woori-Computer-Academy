package com.planner.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.planner.dto.TeamDTO;
import com.planner.dto.TeamMemberDTO;
import com.planner.service.MemberService;
import com.planner.service.TeamMemberService;
import com.planner.service.TeamService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/team/member")
public class TeamMemberController {

	private final TeamService teamService;
	private final TeamMemberService tmService;
	private final MemberService memberService;
	
	@GetMapping("/insert")
	public String tmInsert(Model model, @RequestParam(name = "team_id", defaultValue = "-1") Long team_id, @RequestParam("member_id") Long member_id) {
		TeamDTO dto = teamService.teamInfo(team_id);
		String member_userid = memberService.getInfo(member_id).getMember_userid();
		model.addAttribute("dto", dto);
		model.addAttribute("member_userid", member_userid);
		model.addAttribute("member_id", member_id);
		return "/team/member/tminsert";
	}
	
	@PostMapping("/insert")
	public String tmInsert(@RequestParam(name = "team_id", defaultValue = "-1") Long team_id,
							@RequestParam("member_id") Long member_id, @RequestParam("nickname") String nickname) {
		tmService.tmInsert(team_id, member_id, nickname);
		return "redirect:/team/member/info?team_id="+team_id+"&member_id="+member_id;
	}
	
	@GetMapping("/tmlist")
	public String tmInfoList(Model model, @RequestParam(name = "team_id", defaultValue = "-1") Long team_id) {
		List<TeamMemberDTO> tmlist = tmService.tmInfoList(team_id);
		model.addAttribute("tmlist", tmlist);
		return "/team/member/tmlist";
	}
	
	@GetMapping("/info")
	public String tmInfo(Model model, @RequestParam("member_id") Long member_id, 
						@RequestParam(name = "team_id", defaultValue = "-1") Long team_id) {
		TeamDTO tdto = teamService.teamInfo(team_id);
		TeamMemberDTO tmdto = tmService.tminfo(team_id, member_id);
		model.addAttribute("tdto", tdto);
		model.addAttribute("tmdto", tmdto);
		return "/team/member/tminfo";
	}

	@GetMapping("/update")
	public String tmUpdate(Model model, @RequestParam("member_id") Long member_id,
						@RequestParam("team_id") Long team_id) {
		TeamDTO tdto = teamService.teamInfo(team_id);
		TeamMemberDTO tmdto = tmService.tminfo(team_id, member_id);
		model.addAttribute("tdto", tdto);
		model.addAttribute("tmdto", tmdto);
		return "/team/member/tmupdate";
	}
	
	@PostMapping("/update")
	public String tmUpdate(Model model, @RequestParam("member_id") Long member_id,
						@RequestParam("team_id") Long team_id,
						@RequestParam("tm_nickname") String tm_nickname){
		tmService.tmUpdate(team_id, member_id, tm_nickname);
		return "redirect:/team/member/info?team_id="+team_id+"&member_id="+member_id;
	}
	
	@GetMapping("/delete")
	public String tmDelete(@RequestParam(name = "team_id", defaultValue = "-1") Long team_id,
							@RequestParam("member_id") Long member_id) {
		tmService.tmDelete(team_id, member_id);
		return "redirect:/";
	}
}
