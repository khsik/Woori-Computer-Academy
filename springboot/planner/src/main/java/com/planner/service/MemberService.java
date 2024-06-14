package com.planner.service;

import org.springframework.stereotype.Service;

import com.planner.dto.MemberDTO;
import com.planner.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberMapper memberMapper;

	public MemberDTO getInfo(Long member_id) {
		return memberMapper.getInfo(member_id);
	}
	
}
