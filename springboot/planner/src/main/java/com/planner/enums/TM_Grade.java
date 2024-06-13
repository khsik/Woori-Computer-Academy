package com.planner.enums;

import lombok.Getter;

// team_member의 tm_grade 등급(권한) 설정을 위한 enum

@Getter
public enum TM_Grade {
	ROLE_TEAM_MASTER("TEAM_MASTER"),
	ROLE_TEAM_SUB_MASTER("TEAM_SUB_MASTER"),
	ROLE_TEAM_USER("TEAM_USER");

	private TM_Grade(String value){
		this.value = value;
	}

	private String value;
}
