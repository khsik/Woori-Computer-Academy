<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dao" class="web.test.bean.BoardDAO"/>
<jsp:useBean id="dto" class="web.test.bean.BoardDTO"/>
<jsp:setProperty name="dto" property="num"/>
<% dto = dao.content(dto.getNum()); %>
<style>
	table, tr, td {
		border-collapse:collapse;
		border:solid black 1px;
		margin:5px 0;
		width:700px;
		text-align:center;
	}
	#content {
		text-align:left;
		padding:5px;
	}
</style>
<h1>/board/content</h1>
<table>
	<tr>
		<td>글번호</td><td><%=dto.getNum() %></td>
		<td>작성날짜</td><td><%=dto.getReg() %></td>
	</tr>
	<tr>
		<td>제목</td><td><%=dto.getTitle() %></td>
		<td>작성자</td><td><%=dto.getWriter() %></td>
	</tr>
	<tr>
		<td>내용</td><td colspan="3" id="content"><%=dto.getContent() %></td>
	</tr>
</table>
<button onclick="window.location='list.jsp'">글목록</button>
<button onclick="window.location='updateForm.jsp?num=<%=dto.getNum() %>'">수정</button>
<button onclick="window.location='delete.jsp?num=<%=dto.getNum() %>'">삭제</button>
