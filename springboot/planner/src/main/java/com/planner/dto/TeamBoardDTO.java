package com.planner.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TeamBoardDTO {
	private Long team_board_id;
	private Long team_id;
	private Long team_member_id;
	private Long vote_id;
	private Long schedule_id;
	private String tb_category;
	private String tb_title;
	private String tb_content;
	private LocalDateTime tb_reg;
	private String tm_nickname;
}