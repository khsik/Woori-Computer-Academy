package com.planner.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReplyDTO {
	private Long reply_id;
	private Long team_board_id;
	private Long team_member_id;
	private String reply_content;
	private LocalDateTime reply_reg;
}
