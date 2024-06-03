package com.example.ex.reply;

import java.time.LocalDateTime;

import com.example.ex.board.Board;
import com.example.ex.member.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Reply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long replyId;
	
	@ManyToOne
	private Member writer;
	
	@Column(length = 4000)
	private String content;
	
	private LocalDateTime createDate;
	
	private LocalDateTime updateDate;
	
	@ManyToOne
	private Board board;
}
