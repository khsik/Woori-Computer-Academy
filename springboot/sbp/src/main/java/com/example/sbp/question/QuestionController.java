package com.example.sbp.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequestMapping("/question/*")
@RequiredArgsConstructor
@Controller
public class QuestionController {

	private final QuestionService questionService;
	
	@GetMapping("/")	// http://localhost:8080/question/
	public String root(){	// Question의 메인 페이지인 list로 보냄
		return "redirect:/question/list";
	}

	@GetMapping("list")
	public String list(Model model) {
		List<Question> questionList = this.questionService.getList();
		model.addAttribute("questionList", questionList);
		
		return "question_list";
	}
	
	@GetMapping("detail/{id}")	// 주소 뒤에 변하는 값이 올 때 {}하고 @PathVariable 사용
	public String detail(Model model, @PathVariable("id") Integer id) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		
		return "question_detail";
	}
	
	@GetMapping("list2")
	public String list2(Model model) {
		List<Question> questionList = this.questionService.getList();
		model.addAttribute("questionList", questionList);
		
		return "question_list2";
	}
	
	@GetMapping("detail2/{id}")	// 주소 뒤에 변하는 값이 올 때 {}하고 @PathVariable 사용
	public String detail2(Model model, @PathVariable("id") Integer id) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		
		return "question_detail2";
	}
}
