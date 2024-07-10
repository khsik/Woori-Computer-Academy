package com.planner.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.planner.dto.request.team.TeamMemberDTO;
import com.planner.dto.request.team.TeamMyInfoDTO;
// TODO team_id + tm_nickname unique로 변경해서
// 무결성 제약에 의한 오류 발생 가능성이 생김. exception 처리가 필요함.
@Mapper
@Repository
public interface TeamMemberMapper {
	public String teamMemberGrade(@Param("team_id")long team_id, @Param("member_id")long member_id);
	
	public int nickCheck(@Param("team_id")Long team_id, @Param("tm_nickname")String tm_nickname);
	
	public int insertTeamMember(TeamMemberDTO dto) throws Exception;

	public TeamMyInfoDTO myinfo(@Param("team_id")Long team_id, @Param("member_id")Long member_id);
	
	public TeamMyInfoDTO myinfo2(@Param("team_id")Long team_id, @Param("team_member_id")Long team_member_id);
	
	public List<TeamMemberDTO> tmInfoList(long team_id);

	public int tmUpdate(@Param("team_id")long team_id, @Param("member_id")long member_id,
			@Param("tm_nickname") String tm_nickname) throws Exception;
	
	public int tmDelete(@Param("team_id")long team_id, @Param("member_id")long member_id);

	public int accept(@Param("team_id")Long team_id, @Param("member_id")Long member_id, 
			@Param("tm_grade")String tm_grade);
	
	public int gradeModify(@Param("team_id")Long team_id, @Param("member_id")Long member_id, 
							@Param("tm_grade")String tm_grade);

	public long myTeamMemberId(@Param("team_id")long team_id, @Param("member_id")long member_id);

}
