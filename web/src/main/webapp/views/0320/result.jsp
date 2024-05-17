<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>/result.jsp</h1>
<%
	String m = request.getParameter("msg");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String gen = request.getParameter("gender");
	String ph1 = request.getParameter("ph1");
	String ph2 = request.getParameter("ph2");
	String ph3 = request.getParameter("ph3");
	String file = request.getParameter("file");
	String[] ch = request.getParameterValues("ch");
%>

<%	for(String c : ch){ %>
		<h2>ch : <%=c %></h2>
<%	}%>	

<h1>값 확인</h1>
<h2>msg : <%=m %></h2>
<h2>id : <%=id %></h2>
<h2>pw : <%=pw %></h2>
<h2>gen : <%=gen %></h2>
<h2>통신사 : <%=ph1 %></h2>
<h2>번호 : <%=ph2+"-"+ph3 %></h2>
<h2>파일 : <%=file %></h2>
<h2>ch : <%=ch %></h2>