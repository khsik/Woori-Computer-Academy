package com.planner.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.planner.dto.MemberDTO;

@Mapper
@Repository
public interface MemberMapper {

	public MemberDTO getInfo(Long member_id);

}
