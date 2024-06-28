package com.planner.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.planner.dto.request.team.TeamDTO;
import com.planner.dto.response.member.ResMemberDetail;
import com.planner.service.TeamService;
import com.planner.util.UserData;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@PreAuthorize("isAuthenticated()")
public class TeamController {

	private final TeamService teamService;

	@GetMapping("/team/main")
	public String teamMain() {
		return "/team/teamMain";
	}

	@GetMapping("/team/create")
	public String teamCreate() {
		return "/team/teamCreate";
	}

	@PostMapping("/team/create")
	public String teamCreate(Model model, @UserData ResMemberDetail detail,
							@ModelAttribute("team_name") String team_name, @ModelAttribute("team_explain") String team_explain,
							@RequestParam("team_image") MultipartFile team_image) {
		boolean result = teamService.teamNameOverlap(team_name); // 중복 검사. 중복이면 false
		if(!result) { // 중복이면
			model.addAttribute("result", "중복된 그룹 이름입니다.");
			return "/team/teamCreate";
		}
		boolean result2 = teamService.teamCreate(detail, team_name, team_explain, team_image); // 등록 실패시 false
		if(!result2) {
			model.addAttribute("result", "지원하지 않는 형식의 이미지입니다.");
			return "/team/teamCreate";
		}
		
		return "redirect:/team/main";
	}

	@GetMapping("/team/info")
	public String teamInfo(Model model, @UserData ResMemberDetail detail,
						@RequestParam(name="team_id", defaultValue = "-1") long team_id) {
		TeamDTO dto = teamService.teamInfo(team_id);
		model.addAttribute("dto", dto);
		if(dto == null) {
			model.addAttribute("nodto", "잘못된 접근입니다.");
		}
		return "/team/teamInfo";
	}
// TODO team_id하고 member_id로 tm_grade 검색하는 메서드 만들어서 유효성 검사하는곳에서 불러오기
	@GetMapping("/team/update")
	public String teamUpdate(Model model, @UserData ResMemberDetail detail, @RequestParam("team_id") long team_id) {
		TeamDTO dto = teamService.teamInfo(team_id);
		model.addAttribute("dto", dto);
		return "/team/teamUpdate";
	}

	@PostMapping("/team/update")
	public String teamUpdate(@UserData ResMemberDetail detail, Model model, @RequestParam("team_id") long team_id,
							@ModelAttribute("team_name") String team_name, @ModelAttribute("team_explain") String team_explain,
							@RequestParam("team_image") MultipartFile team_image, @RequestParam(name = "delimg", defaultValue = "") String delimg) {
		teamService.teamInfoUpdate(detail, team_id, team_name, team_explain, team_image, delimg);
		return "redirect:/team/info?team_id="+team_id;
	}

	@GetMapping("/team/delete")
	public String teamDelete(@RequestParam("team_id") long team_id, @RequestParam("member_id") long member_id) {
		teamService.teamDelete(member_id, team_id);
		return "redirect:/team/main";
	}

	@GetMapping("/team/img")
	public ResponseEntity<Resource> displayImg(@RequestParam("img") String imgName){
		return teamService.teamImg(imgName);
	}
}
