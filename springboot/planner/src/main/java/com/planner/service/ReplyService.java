package com.planner.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.planner.dto.ReplyDTO;
import com.planner.dto.ReplyViewDTO;
import com.planner.mapper.ReplyMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyService {
	
	private final ReplyMapper replyMapper;
	
	public int replyInsert(ReplyDTO dto){
		return replyMapper.replyInsert(dto);
	}
	
	public List<ReplyViewDTO> replyList(long team_board_id){
		return replyMapper.replyList(team_board_id);
	}
}
