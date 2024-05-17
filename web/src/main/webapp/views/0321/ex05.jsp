<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>ex05.jsp</h1>
<%
	String[] strArr = {"java","jsp","MVC","Spring"};

	for(int i=0; i<strArr.length; i++){
		out.println("<h3>"+(i+1)+". "+strArr[i]+"</h3>");
	}
%>
<hr color="darkgray" size="3px">
<%	for(int i=0; i<strArr.length; i++){%>
		<b style="line-height:1.5;">strArr[<%=i %>] : <%=strArr[i] %></b><br>
<%	}%>
