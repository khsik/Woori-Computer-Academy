<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>ex11</h1>
<% request.setCharacterEncoding("utf-8"); %>

<%
	String id = request.getParameter("id");
	String hobby= request.getParameter("hobby");
%>
포워드 하는 페이지 ex11.jsp 입니다. <br>
<b><%=id %></b> 님의 <br>
취미는 <b><%=hobby %></b> 입니다.