package com.example.sbst;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.sbst.qna.Answer;
import com.example.sbst.qna.AnswerRepository;
import com.example.sbst.qna.Question;
import com.example.sbst.qna.QuestionRepository;

@SpringBootTest
class SbstApplicationTests {
	
	@Autowired
	private QuestionRepository qRepo;
	
	@Autowired
	private AnswerRepository aRepo;
	
	@Test
	@Transactional
	void qnaTest() {
		Optional<Question> oq = qRepo.findById(5);
		assertTrue(oq.isPresent());
		
		Question q = oq.get();
		List<Answer> alist= q.getAnswerList();
		assertEquals(2, alist.size());
		
		for(Answer a : alist) {
			System.out.println(a.getId() + " : " + a.getContent());
		}
	}
	
//	@Test
	void aAdd() {
		Answer a = new Answer();
		a.setContent("답ㅋㅋ변ㅋㅋ");
		a.setReg(LocalDateTime.now());
		a.setQuestion(qRepo.findById(5).get());
		aRepo.save(a);
	}
	
//	@Test
	void qAdd() {
		Question q = new Question();
		q.setTitle("제목ㅋㅋ");
		q.setContent("내용ㅋㅋ");
		q.setReg(LocalDateTime.now());
		qRepo.save(q);
	}
	
/*
	@Test
	void contextLoads() {
	}
*/
}
