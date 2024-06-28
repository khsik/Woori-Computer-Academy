package com.planner.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.planner.dto.request.team.TeamDTO;

@Mapper
@Repository
public interface TeamMapper {
	public int teamNameOverlap(String team_name);
	public void teamInsert(TeamDTO dto);
	public void teamUpdate(TeamDTO dto);
	public int teamDelete(@Param("member_id") long member_id, @Param("team_id")long team_id);
	public TeamDTO teamInfo(long team_id);
}
