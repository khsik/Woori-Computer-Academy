package com.example.sbp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	// 실행주소 http://localhost:8080/hello
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello SpringBoot!!";
	}
}
