package com.example.sbst.board;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	private String writer;
	
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private List<String> imgs;
	
	private LocalDateTime reg;
	
	@OneToMany
	private List<Reply> replyList;
}
