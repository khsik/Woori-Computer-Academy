package com.planner.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.planner.dto.TeamMemberDTO;

@Mapper
@Repository
public interface TeamMemberMapper {
	public void insertTeamMember(TeamMemberDTO dto);

	public List<TeamMemberDTO> tmInfoList(Long team_id);

	public void tmDelete(@Param("team_id")Long team_id, @Param("member_id")Long member_id);

	public TeamMemberDTO tmInfo(@Param("team_id")Long team_id, @Param("member_id")Long member_id);

	public void tmUpdate(@Param("team_id")Long team_id, @Param("member_id")Long member_id,@Param("tm_nickname") String tm_nickname);
}
