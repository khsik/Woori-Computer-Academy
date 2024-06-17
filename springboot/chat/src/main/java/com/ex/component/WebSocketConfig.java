package com.ex.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {
    private final ChatHandler chatHandler;
    
    
    @Override
    // springframework 웹소켓 에 등록
    // 웹서버 내부에 웹서비스와 웹소켓 서비스가 따로 동작하며, 웹소켓 핸들러 객체를 웹소켓 서비스에 등록한다. 
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(chatHandler,"ws/chat").setAllowedOrigins("*");
    }
}