package com.example.ex.board;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.example.ex.member.Member;
import com.example.ex.reply.Reply;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boardId;
	
	@Nonnull
	private String title;
	
	@ManyToOne
	private Member writer;
	
	@Column(length = 4000)
	private String content;
	
	private LocalDateTime createDate;
	
	private LocalDateTime updateDate;
	
	@OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
	private List<Reply> reply;
	
	@OneToMany
	private Set<Member> recommend;
}
