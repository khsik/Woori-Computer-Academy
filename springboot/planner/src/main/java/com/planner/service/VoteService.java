package com.planner.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.planner.dto.VoteDTO;
import com.planner.mapper.VoteMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VoteService {
	
	private final VoteMapper voteMapper;
	
	public void voteInsert(VoteDTO dto) {
		if(dto.getVote_title() != null && dto.getVote_end() != null) {
			voteMapper.voteInsert(dto);
		}
	}

	public void voteItemInsert(VoteDTO vdto, List<String> vote_item_names) {
		if(vdto.getVote_id() != null && vote_item_names.size() >= 2) {
			voteMapper.voteItemInsert(vdto.getVote_id(), vote_item_names);
		}
	}

	public void voteDelete(Long vote_id) {
		voteMapper.voteDelete(vote_id);
	}

}
