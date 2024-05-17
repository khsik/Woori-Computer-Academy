<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>ex05</h1>
<h2>* out 내장 객체</h2>
	JSP 페잊이가 생성한 결과를 웹 브라우저에 전송해주는 출력 스트림<br>
	println() 메서드와 표현식 <%=ex %> 모두 브라우저에서 출력시키는 역할을 한다.<br>
	단지 편의성을 위해서 표현식 형태로 제공.
	
<h2>out 내장 객체 - out.println() 사용</h2>
<%
	String name = "HTML";
	out.println("출력되는 내용 <b>"+name+"</b> 입니다.");
%>

<h2>out 내장객체 - 표현식 사용</h2>
<%
	String name2 = "JSP";
%>
	출력되는 내용 <b><%=name2 %></b> 입니다.

<%! String ex = "&lt;%= %&gt;";%>