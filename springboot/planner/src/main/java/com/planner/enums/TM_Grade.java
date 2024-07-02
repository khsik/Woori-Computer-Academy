package com.planner.enums;

import java.util.Arrays;
import java.util.Set;

import lombok.Getter;

// team_member의 tm_grade 등급(권한) 설정을 위한 enum

@Getter
public enum TM_Grade {
	ROLE_TEAM_MASTER("TEAM_MASTER"),
	ROLE_TEAM_SUB_MASTER("TEAM_SUB_MASTER"),
	ROLE_TEAM_USER("TEAM_USER"),
	ROLE_TEAM_WAIT("WAIT");
/*
	TODO 좀 자세히 적어두기
	TEAM_MASTER
		다할수있음
	TEAM_SUB_MASTER
		일부 못함
	TEAM_USER
		많이 못함
	WAIT
		가입대기중
*/
	public static final Set<String> grade_set = 
			Set.of(Arrays.stream(TM_Grade.values())
					.map(TM_Grade::getValue)
					.toArray(String[]::new)
					);
	
	private TM_Grade(String value){
		this.value = value;
	}

	private String value;
}
