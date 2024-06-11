package com.example.param;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JqueryController {
	
	@GetMapping("ex01")
	public String ex01() {
		return "aj/ex01";
	}
	@GetMapping("call")
	@ResponseBody
	public String call() {
		return "hello";
	}
	
	@GetMapping("ex02")
	public String ex02() {
		return "/aj/ex02";
	}
	@GetMapping("form")
	public String form(){
		return "aj/form";
	}
	
	@GetMapping("ex03")
	public String ex03() {
		return "/aj/ex03";
	}
	@GetMapping("date")
	@ResponseBody
	public String date() {
		return new Date().toString();
	}
	
	@GetMapping("kakao")
	public String kakao() {
		return "/aj/kakao";
	}
	
	@GetMapping("ex04")
	public String ex04(Model model) {
		model.addAttribute("lat", "37.49158");
		model.addAttribute("lon", "126.7210");
		return "/aj/ex04";
	}
	
	@GetMapping("ex05")
	public String ex05() {
		return "/aj/ex05";
	}
	@GetMapping("userCheck")
	@ResponseBody
	public String userCheck(@RequestParam("username") String username,
							@RequestParam("kor") String kor) {
		System.out.println(username);
		System.out.println(kor);
		String result = "ok";
		return result;
	}
	
}
