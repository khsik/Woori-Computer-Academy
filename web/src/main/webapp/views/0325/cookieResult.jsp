<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>cookieResult.jsp</h1>
<%
	Cookie[] cookies = request.getCookies();
	for(Cookie c : cookies){ // key : value
		out.println(c.getName() + " : " + c.getValue()+"<br>");
	}
	
	// 60초 후 새로고침으로 다시 확인
	// 0320 폴더에서도 확인
%>