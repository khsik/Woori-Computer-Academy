package com.planner.dto.request.team;

import lombok.Data;

@Data
public class TeamListDTO {
	private Long team_id;
	private String team_name;
	private String team_explain;
	private String team_image;
	private String member_email;
}
