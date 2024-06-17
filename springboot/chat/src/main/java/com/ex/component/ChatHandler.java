package com.ex.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class ChatHandler extends TextWebSocketHandler {
    private final List<WebSocketSession> sessions = new ArrayList<>();


    @Override
    // 채팅입장 시 한번 실행되며 입장한 사용자를 각각 소켓세션 이라 하며 소켓세션을 리스트에 보관한다. 
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    	System.out.println("접속 세션추가 == "+session);
        sessions.add(session);
    }
    
    @Override
    // 채팅메시지를 받아 리스트의 모든 소켓세션(채팅중인 사용자)에게 채팅메시지를 보내준다. 
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    	System.out.println(message);
        for (WebSocketSession connected: sessions) {
            connected.sendMessage(message);
        }
    }

    @Override
    // 브라우저의 X 버튼 눌러 나갈때 실행 / 세션리스트에서 삭제한다.  chat.html 의  webSocket.onclose 에 의해 호출된다. 
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    	System.out.println("종료");
        sessions.remove(session);
    }
}