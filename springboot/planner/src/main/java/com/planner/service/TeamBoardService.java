package com.planner.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.planner.dto.TeamBoardDTO;
import com.planner.dto.TeamBoardListDTO;
import com.planner.mapper.TeamBoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamBoardService {

	private final TeamBoardMapper teamBoardMapper;
	
	public int tbCountAll(Long team_id) {
		return teamBoardMapper.teamBoardCountAll(team_id);
	}
	
	public int tbCount(Long team_id, String category, String searchOption, String search) {
		return teamBoardMapper.teamBoardCount(team_id, category, searchOption, search);
	}
	
	public List<TeamBoardListDTO> tblist(Long team_id, String category, String searchOption, String search, int pageNum, int pageSize){
		int start = (pageNum-1)*pageSize + 1;
		int end = pageSize * pageNum;
		return teamBoardMapper.teamBoardList(team_id, category, searchOption, search, start, end);
	}

	public void tbInsert(TeamBoardDTO dto) {
		teamBoardMapper.teamBoardInsert(dto);
	}

	public TeamBoardDTO view(Long team_board_id) {
		return teamBoardMapper.view(team_board_id);
	}



}
