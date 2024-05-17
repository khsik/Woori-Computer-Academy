<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>ex08</h1>

<% request.setCharacterEncoding("UTF-8"); %>
<%
	//String name = request.getParameter("name");
	String pageName = request.getParameter("pageName");
	pageName += ".jsp"; 
%>
<h2>포함하는 페이지 ex08.jsp 입니다.</h2>
<hr color="orange">
<jsp:include page="<%=pageName %>" />
<hr color="orange">
<h3>ex08.jsp의 나머지 부분입니다.</h3>