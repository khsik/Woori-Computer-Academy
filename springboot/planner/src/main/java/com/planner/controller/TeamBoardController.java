package com.planner.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.planner.dto.TeamBoardDTO;
import com.planner.dto.TeamBoardListDTO;
import com.planner.dto.TeamDTO;
import com.planner.service.TeamBoardService;
import com.planner.service.TeamService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/team/board")
public class TeamBoardController {

	private final TeamService teamService;
	private final TeamBoardService teamBoardService;

	@GetMapping("/list")
	public String tblist(Model model, @RequestParam(name = "team_id", defaultValue = "-1")Long team_id, 
							@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
							@RequestParam(name = "ca", defaultValue = "전체") String category,
							@RequestParam(name = "ps", defaultValue = "15")int pageSize,
							@RequestParam(name = "so", defaultValue = "NO")String searchOption,
							@RequestParam(name = "search", defaultValue = "")String search) {
		TeamDTO teamDTO = teamService.teamInfo(team_id);
		if(teamDTO == null) {
			return "redirect:/";
		}
		int tbCountAll = teamBoardService.tbCountAll(team_id);
		int tbCount = teamBoardService.tbCount(team_id, category, searchOption, search);
		List<TeamBoardListDTO> list = null;
		if(tbCount != 0) {
			list = teamBoardService.tblist(team_id, category, searchOption, search, pageNum, pageSize);
		}
		
		int pageBlock = 10;
		int startPage = ((pageNum-1)/pageBlock)*pageBlock + 1;
		int endPage = startPage + pageBlock - 1;
		int totalPage = tbCount/pageSize + (tbCount%pageSize==0 ? 0 : 1);
		if(endPage > totalPage) {endPage = totalPage;}
		
		model.addAttribute("team_id", team_id);
		model.addAttribute("teamDTO", teamDTO);
		model.addAttribute("list", list);
		model.addAttribute("tbCountAll", tbCountAll);
		model.addAttribute("tbCount", tbCount);
		model.addAttribute("ca", category);
		model.addAttribute("pageBlock", pageBlock);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("ps", pageSize);
		model.addAttribute("so", searchOption);
		model.addAttribute("search", search);
		return "/team/board/tblist";
	}
	
	@GetMapping("/write")
	public String tbwrite(@ModelAttribute("team_id")Long team_id, @ModelAttribute("team_member_id")Long team_member_id) {
		
		return "/team/board/tbwrite";
	}
	
	@PostMapping("/write")
	public String tbwrite(TeamBoardDTO dto) {
		teamBoardService.tbInsert(dto);
		return "redirect:/team/board/view?team_id="+dto.getTeam_id()+"&tb_id="+dto.getTeam_board_id();
	}
	
	@GetMapping("/view")
	public String tbview(Model model, @RequestParam("tb_id")Long team_board_id) {
		TeamBoardDTO dto = teamBoardService.view(team_board_id);
		model.addAttribute("dto", dto);
		return "/team/board/tbview";
	}
	
	
}
