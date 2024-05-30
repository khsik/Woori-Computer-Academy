package com.example.sbp.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.example.sbp.answer.Answer;
import com.example.sbp.user.SiteUser;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {

	@ManyToMany
	Set<SiteUser> voter; // 추천
	
	@ManyToOne
	private SiteUser author; // 글쓴이
	
	private LocalDateTime modifyDate; // 수정 날짜
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // primary key
	
	@Column(length = 200)
	private String subject; // 제목
	
	@Column(columnDefinition = "TEXT")
	private String content; // 내용
	
	private LocalDateTime createDate; // 작성 날짜
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	private List<Answer> answerList; // 답변
}
/*
	@Id
		PK 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		키 값 자동 생성
		생성 전략 여러가지 있음
			AUTO, IDENTITY, SEQUENCE, TABLE, UUID
			IDENTITY전략은 기본 키 생성을 데이터베이스에 위임하는 전략
	@Column
		세부사항 지정하기 위해 사용
	@Column(columnDefinition = "TEXT")
		글자수 제한 X
	
	cascade = CascadeType.REMOVE
		삭제시에 종속된 데이터도 같이 삭제
		질문 삭제시 -> 답변들도 같이 삭제
	
	Entity 에서는 Setter 지양
		사용 의도 파악하기 어려워진다.
		일관성을 유지하기 어렵다.
	Setter 대신
		의도, 의미를 알 수 있는 메서드 작성
		생성자를 통해 값을 넣어 일관성 유지(@Builder 사용 추천)
	
	변수명 camel case
		createDate
	DB에서는
		create_date
	
	하나의 질문에 여러 답변이 달릴 수 있음
	답변(Many)	:	질문(One)
			n	:	1
	@ManyToOne
	
	질문	:	답변
	1	:	n
	@OneToMany
	
*/