package com.example.sbp.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.sbp.DataNotFoundException;
import com.example.sbp.answer.Answer;
import com.example.sbp.user.SiteUser;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {

	private final QuestionRepository questionRepository;
	
	private Specification<Question> search(String kw){
		return new Specification<Question>() {
			private static final long serialVersionUID = 1L;
			
/*
	select
		distinct q.id,
		q.author_id,
		q.content,
		q.create_date,
		q.modify_date,
		q.subject
	from question q
		left outer join site_user u1 on q.author_id=u1.id
		left outer join answer a on q.id=a.question_id
		left outer join site_user u2 on a.author_id=u2.id
	where
		q.subject like '%검색어%'
		or q.content like '%검색어%'
		or u1.username like '%검색어%'
		or a.content like '%검색어%'
		or u2.username like '%검색어%'
*/
			@Override
			public Predicate toPredicate(Root<Question> q, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.distinct(true);
				Join<Question, SiteUser> u1 = q.join("author", JoinType.LEFT); // 질문 작성자
				Join<Question, Answer> a = q.join("answerList", JoinType.LEFT); // 답변
				Join<Answer, SiteUser> u2 = a.join("author", JoinType.LEFT); // 답변 작성자
				return cb.or(
						cb.like(q.get("subject"), "%"+kw+"%"),
						cb.like(q.get("content"), "%"+kw+"%"),
						cb.like(u1.get("username"), "%"+kw+"%"),
						cb.like(a.get("content"), "%"+kw+"%"),
						cb.like(u2.get("username"), "%"+kw+"%")
						);
			}
		};
	}

	public Page<Question> getList(int page, String kw){
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("createDate"));
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		Specification<Question> spec = search(kw);
		return this.questionRepository.findAll(spec, pageable);
	}

	public List<Question> getList(){
		return this.questionRepository.findAll();
	}

	public Question getQuestion(Integer id) {
		Optional<Question> question = this.questionRepository.findById(id);
		if(question.isPresent()) {
			return question.get();
		}else {
			throw new DataNotFoundException("question not found");
		}
	}

	public void create(String subject, String content, SiteUser siteUser) {
		Question q = new Question();
		q.setSubject(subject);
		q.setContent(content);
		q.setCreateDate(LocalDateTime.now());
		q.setAuthor(siteUser);
		this.questionRepository.save(q);
	}

	public void modify(Question question, String subject, String content) {
		question.setSubject(subject);
		question.setContent(content);
		question.setModifyDate(LocalDateTime.now());
		this.questionRepository.save(question);
	}
	
	public void delete(Question question) {
		this.questionRepository.delete(question);
	}
	
	public void vote(Question question, SiteUser siteUser) {
		question.getVoter().add(siteUser);
		this.questionRepository.save(question);
	}
}
