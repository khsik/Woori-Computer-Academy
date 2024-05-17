<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>ex12</h1>
<% request.setCharacterEncoding("UTF-8"); %>

<%
	String id ="bbbb";
	String hobby= "영화";
%>

포워드 하는 페이지 ex12.jsp 입니다. <br>

<jsp:forward page="ex09.jsp">
	<jsp:param name="id" value="<%=id %>"/>
	<jsp:param name="hobby" value="<%=hobby %>"/>
</jsp:forward>