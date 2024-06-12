package com.planner.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.planner.service.TeamService;

import lombok.RequiredArgsConstructor;

@PreAuthorize("isAuthenticated()")
@RequiredArgsConstructor
@Controller
public class TeamController {

	private final TeamService teamService;
	
	@GetMapping("/team/create")
	public String teamCreate() {
		return "teamCreate";
	}
	
	@PostMapping("/team/create")
	public String teamCreate(Principal principal, Model model,
							@ModelAttribute("team_name") String team_name, @ModelAttribute("team_explain") String team_explain,
							@RequestParam("team_image") MultipartFile team_image) {
		boolean result = teamService.teamNameOverlap(team_name); // 중복 검사
		if(result == true) { // 중복이면
			model.addAttribute("result", "중복된 그룹 이름입니다.");
			return "teamCreate";
		}
		
		teamService.teamCreate(team_name, team_explain, team_image);
		
		return "";
	}
}
