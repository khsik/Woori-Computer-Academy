package com.example.sbp;

//import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.sbp.answer.Answer;
//import com.example.sbp.answer.AnswerRepository;
import com.example.sbp.question.Question;
import com.example.sbp.question.QuestionRepository;

/*
	@Test
		해당 메서드 실행됨.
	테스트할 클래스 눌러두고(활성화 시켜두고)
	서버 종료한 상태에서
	위에서 Run as - JUnit Test
*/

@SpringBootTest
class SbpApplicationTests {

	@Autowired	// 의존성 주입(DI - Dependency Injection)
				// 스프링이 객체를 대신 생성하여 주입하는 방식
	private QuestionRepository questionRepository;
	
	@Autowired
//	private AnswerRepository answerRepository;

	@Transactional
	@Test
	void testJpa() { // question -> answer 꺼내기
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		
		// 지연(Lazy) 방식 <--> 즉시(Eager) 방식
		// oq를 받아오고 DB세션이 끊겨서 받아오지 못함
		// test에서만 생기는 문제.
		// -> @Transactional 사용하면 세션 유지
		// 이때 import org.springframework.transaction.annotation.Transactional;
		List<Answer> al = q.getAnswerList();
		assertEquals(1, al.size());
		assertEquals("네, 자동으로 생성됩니다.", al.get(0).getContent());
	}
	
	
/*
	@Test
	void testJpa() { // answer -> question 꺼내기
		Optional<Answer> oa = this.answerRepository.findById(1);
		assertTrue(oa.isPresent());
		Answer a = oa.get();
		assertEquals(2, a.getQuestion().getId());
	}
*/
	
/*
	@Test
	void testJpa() { // answer 저장
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		
		Answer a = new Answer();
		a.setContent("네, 자동으로 생성됩니다.");
		a.setQuestion(q);
		a.setCreateDate(LocalDateTime.now());
		this.answerRepository.save(a);
	}
*/	
	
/*	
	@Test
	void testJpa() { // 삭제
		assertEquals(2, this.questionRepository.count());
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		this.questionRepository.delete(q);
		assertEquals(1, this.questionRepository.count());
	}
*/	
	
/*
	@Test
	void testJpa() { // 수정
		Optional<Question> op= this.questionRepository.findById(1);
		assertTrue(op.isPresent());
		Question q = op.get();
		q.setSubject("수정된 제목");
		this.questionRepository.save(q);
	}
*/
	
/*	
	@Test
	void testJpa() { // like
		List<Question> list = this.questionRepository.findBySubjectLike("sbp%");
		Question q = list.get(0);
		assertEquals("sbp가 무엇인가요?", q.getSubject());
	}
*/	
	
/*	
	@Test
	void testJpa() { // and
		Question q = this.questionRepository.findBySubjectAndContent("sbp가 무엇인가요?", "sbp에 대해서 알고싶습니다.");
		assertEquals(1, q.getId());
	}
*/	
	
/*	
	@Test
	void testJpa() { // subject=
		Question q = this.questionRepository.findBySubject("sbp가 무엇인가요?");
		assertEquals(1, q.getId());
	}
*/
	
/*	
	@Test
	void testJpa() { // id=
		Optional<Question> oq = this.questionRepository.findById(1);
		if(oq.isPresent()) {
			Question q = oq.get();
			assertEquals("sbp가 무엇인가요?",q.getSubject());
		}
	}
*/
	
/*	
	@Test
	void testJpa() { // select *
		List<Question> all = this.questionRepository.findAll();
		assertEquals(2, all.size());
		
		Question q = all.get(0);
		assertEquals("sbp가 무엇인가요?",q.getSubject());
		// assertEquals(기댓값, 실제값);
		// 테스트에서 예상한 결과와 실제 데이터가 동일한지 확인하는 목적
		// JPA 또는 DB에서 데이터를 올바르게 가져오는지 확인
	}
*/
	
/*	
	@Test
	void testJpa() { // 추가
		Question q1 = new Question();
		q1.setSubject("sbp가 무엇인가요?");
		q1.setContent("sbp에 대해서 알고싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);
		
		Question q2 = new Question();
		q2.setSubject("스프링부트 모델 질문입니당.");
		q2.setContent("id는 자동으로 생성되나요?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);
	}
*/
	
}
