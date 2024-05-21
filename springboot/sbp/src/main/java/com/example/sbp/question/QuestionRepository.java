package com.example.sbp.question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

	// Junit 테스트
	Question findBySubject(String subject);
	
	// subject 와 content 두개의 엔티티의 속성(컬럼) 조회하기 위한 메서드
	Question findBySubjectAndContent(String subject, String content);
	
	List<Question> findBySubjectLike(String subject);
	
}

/*
	https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
	findBy + 엔티티의 속성명 : 메서드 선언
	JPA에서 자동으로 메서드 이름에 맞게 설정
	
	And
		findBySubjectAndContent
		subject, content 열과 일치하는 데이터 조회
	
	Or
		findBySubjectOrContent
		subject 또는 content 열과 일치하는 데이터 조회
		
	Between
		findByCreateDateBetween(LocalDateTime fromDate, LocalDateTime toDate)
		createDate 의 데이터 중 정해진 범위 내에 있는 데이터를 조회
	
	LessThan
		findByIdLessThan(Integer id)
		id 컬럼에서 조건보다 작은 데이터를 조회
	
	GreaterThanEqual
		findByIdGreaterThanEqual(Integer id)
		id 컬럼에서 조건보다 크거나 같은 데이터를 조회
	
	Like
		findBySubjectLike(String subject)
		subject 컬럼에서 문자열 "subject" 와 같은 문자열을 포함한 데이터를 조회
	
	In
		findBySubjectIn(String[] subject)
		subject 열의 데이터가 주어진 배열에 포함되는 데이터만 조회
	
	OrderBy
		findBySubjectOrderByCreateDateAsc(String subject)
		subject 열 조건에 일치하는 데이터를 조회,
		리턴할 때 createDate 열을 오름차순으로 정렬하여 리턴
*/