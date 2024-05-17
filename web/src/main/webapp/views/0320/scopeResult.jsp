<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>0320/scopeResult.jsp</h1>
<h1>0325/scope.jsp 실행 후</h1>

<%
	Object obj1 = application.getAttribute("data");
	Object obj2 = session.getAttribute("sdata");
	Object obj3 = request.getAttribute("rdata");
%>
<h2>application : <%=obj1 %></h2>
<h2>session : <%=obj2 %></h2>
<h2>request : <%=obj3 %></h2>
