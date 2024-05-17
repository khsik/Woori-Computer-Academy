<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- post 방식으로 전달하면 인코딩 필요 --%>
<% request.setCharacterEncoding("UTF-8");%>
<h1>pro1</h1>
<%
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	
	if(age>20){
		out.println("<h1><i>"+name+"</i> 님의 나이는 20세 이상입니다.</h1>");
	}else{
		out.println("<h1><i>"+name+"</i> 님은 미성년자 입니다.</h1>");
	}
%>