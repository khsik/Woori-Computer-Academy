<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>scopeResult.jsp</h1>

<%
	// 서버쪽에 생성되서 브라우저에서 출력하여 확인
	Object obj = application.getAttribute("data");
	Object obj2 = session.getAttribute("sdata");
	Object obj3 = request.getAttribute("rdata");

	Object objId1 = application.getAttribute("id");
	Object objId2 = session.getAttribute("sid");
	Object objId3 = request.getAttribute("rid");
%>
<h2>data : <%=obj %></h2>
<h2>sdata : <%=obj2 %></h2>
<h2>rdata : <%=obj3 %></h2>

<h2>id : <%=objId1 %></h2>
<h2>sid : <%=objId2 %></h2>
<h2>rid : <%=objId3 %></h2>