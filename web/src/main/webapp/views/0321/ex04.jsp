<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>ex04.jsp</h1>
<%
	int score = 95;
	if(score>=90){
		System.out.println("A");
		out.println("A");
	}
%>
<hr color="purple">
<%
	int[] scores = {95, 80, 75, 40};
	for(int i=0; i<scores.length; i++){
		if(scores[i] >= 80){
			System.out.println((i+1)+" : pass");%>
			<%=i+1%> : <b>pass</b>
		<%}else{
			System.out.println((i+1)+" : no pass(score = "+scores[i]+")");%>
			<%=i+1%> : no pass(score = <%=scores[i] %>)
		<%}%>
		<br>
	<%}%>
<hr color="cyan">
<%	String hello = "hello";
	for(int i=1; i<=5; i++){ %>
		<span style="font-size:24px;"><%=i %>. <b><%=hello.repeat(i) %></b></span><br>
<%	}%>
