package com.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("chat")
@RequiredArgsConstructor
public class ChatController {

    @GetMapping("rooms")
    public String rooms() {
        return "rooms";
    }

    @GetMapping("enter")     
    public String enter(@ModelAttribute("username") String username) {
    //  @ModelAttribute : 전달받은 파라미터를 View 페이지로 바로 전달할 때 사용
        return "chat";
    }
}