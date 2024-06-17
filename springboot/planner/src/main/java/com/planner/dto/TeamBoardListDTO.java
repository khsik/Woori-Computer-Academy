package com.planner.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TeamBoardListDTO {
	private Long team_board_id;
	private Long team_member_id;
	private String tb_category;
	private String tb_title;
	private LocalDateTime tb_reg;
	private String tm_nickname;
}
