<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>cookie1.jsp</h1>
<%
/*
	세션과 달리 클라이언트의 상태 정보를 클라이언트 측에 보관, 저장
	쿠키 항상 가지고 다님 - 자동로그인
	
	쿠키 - 브라우저에 저장 = 브라우저에서 확인
	
	해당 폴더 내에서만 사용 가능 내부객체 아니기 때문에 생성해야함.
*/ 
	Cookie coo = new Cookie("coo","test");

	// 쿠키 유효기간 : 초 단위
	coo.setMaxAge(30); // 유효시간 30초 설정 - 생성 후 30초 지나면 자동삭제
	// .setMaxAge(0) : 로그아웃
	
	// 클라이언트(브라우저)에 전달
	response.addCookie(coo);
%>
<h1>쿠키 생성 완료</h1>
