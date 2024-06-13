package com.planner.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.planner.dto.TeamMemberDTO;

@Mapper
@Repository
public interface TeamMemberMapper {
	public void insertTeamMember(TeamMemberDTO dto);
}
