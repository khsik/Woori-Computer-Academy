<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>/board/updateForm</h1>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dao" class="web.test.bean.BoardDAO"/>
<jsp:useBean id="dto" class="web.test.bean.BoardDTO"/>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	dto = dao.updateForm(num);
%>

<form action="updatePro.jsp" method="post">
	<input type="hidden" name="num" value="<%=num %>">
	writer: <input type="text" name="writer" value="<%=dto.getWriter() %>"> <br>
	title: <input type="text" name="title" value="<%=dto.getTitle() %>"> <br>
	content <br>
	<textarea rows="10" cols="50" name="content"><%=dto.getContent() %></textarea> <br>
	<button type="submit">글수정</button>
	<button type="button" onclick="history.back();">뒤로가기</button>
</form>