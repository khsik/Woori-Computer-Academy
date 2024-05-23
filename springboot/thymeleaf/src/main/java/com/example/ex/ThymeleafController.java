package com.example.ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/th/*")	// http://localhost:8080/th/* - 루트주소
public class ThymeleafController {

	@GetMapping("main")
	public String main() {
		return "main";
	}
	
	@GetMapping("ex01")		// http://localhost:8080/th/ex01
	public String ex01(Model model) {
		model.addAttribute("message", "Hello, Thymeleaf");
		return "ex01";
	}
	
	@GetMapping("ex02")		// http://localhost:8080/th/ex02
	public String ex02(Model model) {
		model.addAttribute("message", "<h1>Hello Thymeleaf</h1>");
		model.addAttribute("htmlContent", "<h1>Hello Thymeleaf</h1>");
		return "ex02";
	}
	
	@GetMapping("ex03")
	public String ex03(/* Model model */) {
		
		return "ex03";
	}
	
	@GetMapping("ex04")
	public String ex04(Model model) {
		model.addAttribute("date", new Date());
		model.addAttribute("num", 100000);
		model.addAttribute("num2", 0.12345);
		model.addAttribute("message", "Hello Thymeleaf");
		
		List<String> list = new ArrayList<>();
		list.add("sql");
		list.add("jsp");
		list.add("java");
		list.add("spring");
		model.addAttribute("list", list);
		
		return "ex04";
	}
	
	@GetMapping("ex05")
	public String ex05(Model model) {
		model.addAttribute("data", "main");
		return new String("ex05");
	}
	
	@GetMapping("ex06")
	public String ex06(Model model, HttpSession session) {
		User user = new User();
		user.setAge(10);
		user.setName("춘식이");
		session.setAttribute("user", user);

		return "ex06";
	}
	
	@GetMapping("ex07")
	public String ex07() {
		
		return "ex07";
	}

	@GetMapping("ex08")
	public String ex08() {
		
		return "ex08";
	}
	
	@GetMapping("ex09")
	public String ex09(HttpSession session) {
		session.setAttribute("sid", "springboot");
		return "ex09";
	}
	
	// if
	@GetMapping("ex10")
	public String ex10(Model model) {
		model.addAttribute("age", "20");
		return "ex10";
	}
	
	// switch
	@GetMapping("ex11")
	public String ex11(Model model) {
		model.addAttribute("age", "20");
		return "ex11";
	}
	
	// 반복문
	@GetMapping("ex12")
	public String ex12(Model model) {
		List<String> list = Arrays.asList("java", "jsp", "spring", "sql");
		model.addAttribute("list", list);
		
		List<User> userList = new ArrayList<>();
		userList.add(new User("java", 20));
		userList.add(new User("jsp", 30));
		userList.add(new User("spring", 35));
		userList.add(new User("sql", 41));
		model.addAttribute("userList", userList);
		
		return "ex12";
	}
	
	// th:value 속성 활용
	@GetMapping("ex13")
	public String ex13(Model model) {
		model.addAttribute("age", "20");
		return "ex13";
	}
	
	// th:src 속성 활용
	@GetMapping("ex14")
	public String ex14(Model model) {
		model.addAttribute("image", "default.jpg");
		return "ex14";
	}
	
	// th:attr 속성 활용
	@GetMapping("ex15")
	public String ex15(Model model) {
		
		return "ex15";
	}
	
	@GetMapping("memberForm")
	public String memberForm() {
		return "memberForm";
	}
	
	@PostMapping("memberPro")
	public String memberPro(Member member,Model model) {
		model.addAttribute("message", "회원가입이 완료되었습니다.");
		model.addAttribute("member", member);
		return "memberPro";
	}
	
}

/*	
	스프링에서 session 사용 시
	메서드의 매개변수로 HttpSession 선언해두면
	스프링MVC 컨테이너가 세션을 자동으로 주입해 줌. 
	
	스프링MVC에서 자동으로 주입해주는 객체
		- HttpServletRequest : jsp에서 사용했던 request
		- HttpServletResponse : jsp에서 사용했던 response
		- HttpSession : 세션
		- Principal : 시큐리티(security)에서 사용되는 인증된 사용자 정보
		- Model : 컨트롤러에서 뷰로 데이터 전달할 때 사용
		- ModelMap : Model과 비슷한 역할. Map 인터페이스를 구현한 객체.
		- MultipartFile : 파일 업로드 처리
 */	
