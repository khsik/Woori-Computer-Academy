package com.example.thp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/thyme/*")
public class ThymeleafController {

	@GetMapping("page1")
	public String page1(Model model) {
		model.addAttribute("p2", "page2");
		model.addAttribute("keys", "87");
		model.addAttribute("type", "linear");
		model.addAttribute("press", "45g");
		
		List<String> list = new ArrayList<>();
		list.add("빨강");
		list.add("파랑");
		list.add("보라");
		model.addAttribute("colors", list);
		
		return "page1";
	}
	
	@GetMapping("page2")
	public String page2(Model model, HttpSession session) {
		TempData lotto = new TempData();
		TempData lotto2 = new TempData();
		model.addAttribute("lotto", lotto);
		
		session.setAttribute("sid", "sidsidsidsid");
		session.setAttribute("grade", 1);
		session.setAttribute("lotto2", lotto2);
		
		return "page2";
	}
}
