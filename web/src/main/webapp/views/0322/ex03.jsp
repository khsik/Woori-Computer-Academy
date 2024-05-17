<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>ex03</h1>
<hr>
<h2>Response 내장객체 - 리다이렉트</h2>

<h3>현재 페이지는 ex03(responseRedirect).jsp 입니다.</h3>

<%
	response.sendRedirect("ex04.jsp");
%>