package com.example.sbp.answer;

import java.time.LocalDateTime;
import java.util.Set;

import com.example.sbp.question.Question;
import com.example.sbp.user.SiteUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {

	@ManyToMany
	Set<SiteUser> voter; // 추천
	
	@ManyToOne
	private SiteUser author; // 글쓴이
	
	private LocalDateTime modifyDate; // 수정 날짜
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // primary key
	
	@Column(columnDefinition = "TEXT")
	private String content; // 내용
	
	private LocalDateTime createDate; // 작성 날짜
	
	// 질문 엔티티를 참조하기 위해 question 속성을 추가
	@ManyToOne
	private Question question; // 질문
}
