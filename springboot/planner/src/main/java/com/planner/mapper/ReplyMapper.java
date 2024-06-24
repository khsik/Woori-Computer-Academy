package com.planner.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.planner.dto.ReplyDTO;
import com.planner.dto.ReplyViewDTO;

@Mapper
@Repository
public interface ReplyMapper {
	public int replyInsert(ReplyDTO dto);
	public List<ReplyViewDTO> replyList(long team_board_id);
	public void replyDelete(long reply_id);
	public void replyUpdate(@Param("reply_content")String reply_content, @Param("reply_id")long reply_id);
}
