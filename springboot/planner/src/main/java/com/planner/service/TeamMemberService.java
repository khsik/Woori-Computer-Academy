package com.planner.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.planner.dto.TeamMemberDTO;
import com.planner.enums.TM_Grade;
import com.planner.mapper.TeamMemberMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamMemberService {

	private final TeamMemberMapper tmMapper;

	public void tmInsert(Long team_id, Long member_id, String nickname) {
		TeamMemberDTO dto = new TeamMemberDTO();
		dto.setTeam_id(team_id);
		dto.setMember_id(member_id);
		dto.setTm_nickname(nickname);
		dto.setTm_grade(TM_Grade.ROLE_TEAM_USER.getValue());
		tmMapper.insertTeamMember(dto);
	}

	public List<TeamMemberDTO> tmInfoList(Long team_id) {
		return tmMapper.tmInfoList(team_id);
	}

	public void tmDelete(Long team_id, Long member_id) {
		tmMapper.tmDelete(team_id, member_id);
	}

	public TeamMemberDTO tminfo(Long team_id, Long member_id) {
		return tmMapper.tmInfo(team_id, member_id);
	}

	public void tmUpdate(Long team_id, Long member_id, String tm_nickname) {
		tmMapper.tmUpdate(team_id, member_id, tm_nickname);
	}
	
}
