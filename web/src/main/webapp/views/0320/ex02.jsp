<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
	<h1>0320/ex02.jsp</h1>

	<%!
		// 선언문 - 클래스 영역
		static String name = "java";
		int number = 10;
		public String getName(){
			return name;
		}
	%>
	<%
		out.println("<h1>"+getName()+"</h1>");
		out.println(number+"<br>");
		out.println(getName()+"<br>");
	%>
	<h1><%=name %></h1>
	<%=name %> <br>
	<%=number %>
</body>
</html>
<%--
	<%! %> 선언문 (declaration)
		변수, 메서드 선언
		페이지 내 어디서나 접근 가능한 전역 변수 및 메서드
		
	<% %> 스크립틀릿 (scriptlet)
		java 코드 삽입
		기존 자바 언어와 동일하게 사용할 수 있음
	
	<%= %>
		변수, 메서드의 결과값을 출력
		변수, 메서드를 사용할 때 세미콜론(;) 사용하지 않음
	
	<%@ %>
		페이지 속성 지정
		java 패키지 import 할때도 사용
		예) <%@page import="java.util.Date"%>
--%>
