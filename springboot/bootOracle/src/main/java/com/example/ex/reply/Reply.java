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
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@SequenceGenerator(
		name = "reply_seq_generator",
		sequenceName = "reply_seq", // DB에서 시퀀스 명
		initialValue = 5, // 초기값
		allocationSize = 30 // cache. 한번에 할당받는 시퀀스 수
		)
public class Reply {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reply_seq_generator")
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
