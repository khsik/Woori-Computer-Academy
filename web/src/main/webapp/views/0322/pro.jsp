<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>0322/pro</h1>

<%
	// System.out.println("1");
	// response.sendRedirect("result.jsp");
	// System.out.println("2");
%>

<%
	String hobby = "movie";
%>

<jsp:forward page="result.jsp">
	<jsp:param name="hobby" value="<%=hobby %>"/>
</jsp:forward>

<%
	System.out.println("3");
	// forward 썼을땐 3 안나옴
	// response.sendRedirect 로 했을때는 이클립스 콘솔에 1, 2, 3 다 출력됨
%>