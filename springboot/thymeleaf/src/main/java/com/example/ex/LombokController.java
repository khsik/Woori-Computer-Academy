package com.example.ex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lombok")
public class LombokController {
	// lombok.java 함께 봐야함.

	@GetMapping("/lom01")
	public String lom01(Model model) {
		Lombok user = new Lombok();
		user.setName("춘식이");
		user.setAge(5);
		user.setTest("ㅎㅎㅎ");
		model.addAttribute("user", user);
		return "lom01";
	}
	
	@GetMapping("/lom02")
	public String lom02(Model model) {
		// NoArgsConstructor 설정에 의해 기본생성자 사용
		Lombok user = new Lombok();
		user.setName("춘식2");
		user.setAge(5);
		
		// null 대입 시 코드에서는 오류가 없지만
		// @NonNull 설정에 의해 실행 시 NullPointerException 예외 발생
		// user.setTest(null);
		user.setTest("lombok");
		model.addAttribute("user", user);
		return "lom02";
	}
	
	@GetMapping("/lom03")
	public String lom03(Model model){
		// @AllArgsConstructor 설정에 의해 모든 변수를 매개변수로 받는 생성자
		Lombok user = new Lombok("춘식3",3,"hello");
		
		model.addAttribute("user", user);
		return "lom03";
	}
	
	@GetMapping("/lom04")
	public String lom04(Model model) {
		// @Builder 생성자를 사용하지 않고 빌더 패턴을 자동으로 생성
		Lombok user = Lombok.builder().name("춘식4").age(4).test("hi").build();
		
		model.addAttribute("user", user);
		return "lom04";
	}
}
