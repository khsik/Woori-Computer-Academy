package com.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ex.data.MyTestDTO;
import com.ex.data.MyTestUpdateDTO;
import com.ex.service.TestService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TestController {

	private final TestService testService;
	
	@GetMapping("/")
	public String main2() {
		return "redirect:/mytest/main";
	}
	
	@GetMapping("/mytest/main")
	public String main() {
		return "main";
	}
	
	@GetMapping("/mytest/form")
	public String form() {
		return "form";
	}
	
	@PostMapping("/mytest/form")
	public String form2(MyTestDTO dto, Model model) {
		model.addAttribute("result",testService.mytestInsert(dto));
		return "create";
	}
	
	@GetMapping("/mytest/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/mytest/login")
	public String login2(@RequestParam("username") String username,
						@RequestParam("password") String password,
						HttpSession session) {
		int result = testService.loginCheck(username, password);
		if(result != 1) {
			return "login";
		}
		session.setAttribute("sid", username);
		return "redirect:/mytest/main";
	}

	@GetMapping("/mytest/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/mytest/main";
	}

	@GetMapping("/mytest/userInfo")
	public String userInfo(Model model) {
		model.addAttribute("list",testService.userInfo());
		return "userInfo";
	}

	@GetMapping("/mytest/myInfo")
	public String myInfo(Model model, HttpSession session) {
		String username = (String) session.getAttribute("sid");
		if(username == null) {
			return "redirect:/mytest/login";
		}
		model.addAttribute("myTestDTO", testService.myInfo(username));
		return "myInfo";
	}

	@GetMapping("/mytest/delete")
	public String mytestDelete(HttpSession session) {
		String username = (String) session.getAttribute("sid");
		if(username == null) {
			return "redirect:/mytest/login";
		}
		session.invalidate();
		testService.mytestDelete(username);
		return "redirect:/mytest/main";
	}
	
	@GetMapping("/mytest/update")
	public String myInfoUpdate(HttpSession session, Model model) {
		String username = (String) session.getAttribute("sid");
		MyTestDTO myTestDTO = testService.myInfo(username);
		model.addAttribute("myTestDTO", myTestDTO);
		return "myInfoUpdate";
	}
	
	@PostMapping("/mytest/update")
	public String myInfoUpdate(MyTestUpdateDTO dto) {
		// 기존 비밀번호 확인 || 새로운 비밀번호 일치 확인
		if(!testService.myInfo(dto.getUsername()).getPassword().equals(dto.getOrgPassword())
				|| !dto.getNewPassword1().equals(dto.getNewPassword2())) {
			return "redirect:/mytest/update";
		}
		testService.updateInfo(dto);
		
		return "redirect:/mytest/myInfo";
	}
}
