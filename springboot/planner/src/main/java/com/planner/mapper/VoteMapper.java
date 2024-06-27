package com.planner.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.planner.dto.VoteDTO;

@Mapper
@Repository
public interface VoteMapper {
	public void voteInsert(VoteDTO dto);
	public void voteItemInsert(@Param("vote_id")Long vote_id, 
							@Param("vote_item_names")List<String> vote_item_names);
	public void voteDelete(Long vote_id);
}
