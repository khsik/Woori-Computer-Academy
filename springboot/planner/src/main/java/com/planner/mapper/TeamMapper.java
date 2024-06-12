package com.planner.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.planner.dto.TeamDTO;

@Mapper
@Repository
public interface TeamMapper {
	public int teamNameOverlap(String team_name);
	public void teamInsert(TeamDTO dto);
	public void teamUpdate(TeamDTO dto);
	public void teamDelete(Long member_id);
}
