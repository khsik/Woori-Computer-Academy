package com.example.sbst.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestPage {

	@GetMapping("/test/test1")
	@ResponseBody
	public String testPage1() {
		return "테스트 페이지1";
	}
}
