<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>0322/result</h1>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String hobby = request.getParameter("hobby");
%>
<h3>id : <%=id %></h3>
<h3>name : <%=name %></h3>
<h3>hobby : <%=hobby %></h3>

<%--
	response.sendRedirect("result.jsp"); 으로 넘어오면
	값이 넘어오지 않음. 주소도 바뀜.
	
	forward 썻을 때는 값 넘어옴. 주소는 pro에 있음.
--%>