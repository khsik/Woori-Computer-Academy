<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>/board/writePro</h1>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dao" class="web.test.bean.BoardDAO"/>
<jsp:useBean id="dto" class="web.test.bean.BoardDTO"/>
<jsp:setProperty name="dto" property="*"/>

<%
	int result = dao.insert(dto);
%>
<h2><%=result %>개의 글이 등록되었습니다.</h2>
<button onclick="window.location='list.jsp'">글목록</button>