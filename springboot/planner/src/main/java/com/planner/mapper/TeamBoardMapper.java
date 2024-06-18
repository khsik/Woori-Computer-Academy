package com.planner.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.planner.dto.TeamBoardDTO;
import com.planner.dto.TeamBoardListDTO;

@Mapper
@Repository
public interface TeamBoardMapper {

	public int teamBoardCountAll(Long team_id);
	
	public int teamBoardCount(@Param("team_id")Long team_id, @Param("category")String category, 
							@Param("searchOption")String searchOption, @Param("search")String search);

	public List<TeamBoardListDTO> teamBoardList(@Param("team_id")Long team_id,@Param("category")String category, 
												@Param("searchOption")String searchOption, @Param("search")String search,
												@Param("start") int start,@Param("end") int end);

	public Long teamBoardInsert(TeamBoardDTO dto);

	public TeamBoardDTO view(Long team_board_id);
}
