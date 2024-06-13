package com.planner.controller;

import java.security.Principal;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.planner.dto.TeamDTO;
import com.planner.service.TeamService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
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
	public String teamCreate(Principal principal, Model model,
							@ModelAttribute("team_name") String team_name, @ModelAttribute("team_explain") String team_explain,
							@RequestParam("team_image") MultipartFile team_image) {
		boolean result = teamService.teamNameOverlap(team_name); // 중복 검사. 중복이면 false
		if(!result) { // 중복이면
			model.addAttribute("result", "중복된 그룹 이름입니다.");
			return "/team/teamCreate";
		}
//		TODO 합치고 나서 수정해야되는거.
//		String userid = principal.getName();
		String userid = "";
		boolean result2 = teamService.teamCreate(userid, team_name, team_explain, team_image); // 등록 실패시 false
		if(!result2) {
			model.addAttribute("result", "지원하지 않는 형식의 이미지입니다.");
			return "/team/teamCreate";
		}
		
		return "redirect:/team/main";
	}
	
	@GetMapping("/team/info")
	public String teamInfo(Model model, @RequestParam("team_id") long team_id) {
		TeamDTO dto = teamService.teamInfo(team_id);
		model.addAttribute("dto", dto);
		if(dto == null) {
			model.addAttribute("nodto", "없는 그룹입니다.");
		}
		return "/team/teamInfo";
	}
	
	@GetMapping("/team/update")
	public String teamUpdate(Model model, Principal principal, @RequestParam("team_id") long team_id) {
		// 로그인 회원 정보, 권한 확인해야함.
		TeamDTO dto = teamService.teamInfo(team_id);
		model.addAttribute("dto", dto);
		return "/team/teamUpdate";
	}
	
	@PostMapping("/team/update")
	public String teamUpdate(Principal principal, Model model, @RequestParam("team_id") long team_id,
							@ModelAttribute("team_name") String team_name, @ModelAttribute("team_explain") String team_explain,
							@RequestParam("team_image") MultipartFile team_image, @RequestParam("delimg") String delimg) {
		// TODO 수정할 때 이미지쪽으로 아직 오류나오는 부분들 있음. 수정해야됨.
		teamService.teamInfoUpdate(principal, team_id, team_name, team_explain, team_image, delimg);
		return "redirect:/team/info?team_id="+team_id;
	}
	
	@GetMapping("/team/delete")
	public String teamDelete() {
		return "";
	}
	
	@GetMapping("/team/img")
	public ResponseEntity<Resource> displayImg(@RequestParam("img") String imgName){
		return teamService.teamImg(imgName);
	}
}
