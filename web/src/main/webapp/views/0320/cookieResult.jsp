<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>0325/cookie2.jsp 실행 후</h1>
<%
	Cookie[] cookies = request.getCookies();
	for(Cookie c : cookies){
		out.println(c.getName() + " : " + c.getValue());
		out.println("<br>");
	}
%>
<%--
	쿠키 같은 폴더 내에서만 사용
	setPath로 경로 지정해서 다른 폴더로 설정 가능
--%>