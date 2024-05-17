<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<h1>pro2</h1>
<hr color="black">
<%
	String name = request.getParameter("name");
	String local = request.getParameter("local");
	String tel = request.getParameter("tel");
//	String localNum = local.equals("인천")? "032" : local.equals("서울")? "02" : "031";
	String localNum = "";
	if(local.equals("인천")){
		localNum="032";
	}else if(local.equals("서울")){
		localNum="02";
	}else if(local.equals("경기")){
		localNum="031";		
	}
	out.println("<h3>이름 : "+name+"</h3>");
	out.println("<h3>전화번호 : "+localNum+")"+tel+"</h3>");
%>
<hr color="black">
<h3>이름 : <%=name%></h3>
<h3>전화번호 : <%=localNum %>)<%=tel%></h3>

<hr color="red" size=10px style="margin:0; padding:0;">
<hr color="orange" size=10px style="margin:0; padding:0;">
<hr color="yellow" size=10px style="margin:0; padding:0;">
<hr color="green" size=10px style="margin:0; padding:0;">
<hr color="blue" size=10px style="margin:0; padding:0;">
<hr color="navy" size=10px style="margin:0; padding:0;">
<hr color="purple" size=10px style="margin:0; padding:0;">
