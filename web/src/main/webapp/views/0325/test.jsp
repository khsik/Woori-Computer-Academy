<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>0325/test.jsp</h1>
<%!
	// 클래스 영역
	static String a = "aa";
	String b = "bb";
%>

<%
	String c = "cc";
	out.println(a);
	out.println(b);
	out.println(c);
%>
<br>
표현식 a : <%=a %>
표현식 b : <%=b %>
표현식 c : <%=c %>