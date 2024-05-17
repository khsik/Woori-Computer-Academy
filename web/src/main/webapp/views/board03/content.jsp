<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="web.bean.board03.Board03DTO" %>
<%@ page import="web.bean.board03.Board03DAO" %>
<style>
	#box {margin:0 auto; max-width:max-content;}
	#btn {text-align:right;}
	table {max-width:800px;}
	h1 {text-align:center; line-height:1.2;}
	img {max-width:780px; margin:5px 0;}
	#centerimg {text-align:center;}
	th, td {border-bottom:1px darkgray dashed;}
	th {width:110px;}
</style>

<div id="box">
<h1>/board03/content</h1>

<%
	String pageNum = request.getParameter("pageNum");
	int num = Integer.parseInt(request.getParameter("num"));
	Board03DAO dao = Board03DAO.getInstance();
	Board03DTO dto = dao.readContent(num);
%>
<table>
	<tr><th>글번호</th><td><%=dto.getNum() %></td></tr>
	<tr><th>작성시간</th><td><%=dto.getReg() %></td></tr>
	<tr><th>제목</th><td><%=dto.getTitle() %></td></tr>
	<tr><td colspan="2" id="centerimg">
<%	if(dto.getImg() != null){ // 이미지 있는 경우 %>
		<img src="/web/views/upload/<%=dto.getImg() %>"> <%-- ../upload/<%=dto.getImg() %> --%>
<%	} else{ // 이미지 없는 경우 %>
		<img src="../images/No_Image.jpg">
<%	}%>
	</td></tr>
	<tr>
		<td colspan="2" id="btn">
		<input type="button" value="글수정" onclick="window.location='updateForm.jsp?pageNum=<%=pageNum %>&num=<%=dto.getNum() %>'"> &nbsp;&nbsp;
		<input type="button" value="글삭제" onclick="window.location='deleteForm.jsp?pageNum=<%=pageNum %>&num=<%=dto.getNum() %>'"> &nbsp;&nbsp;
		<button type="button" onclick="window.location='list.jsp?pageNum=<%=pageNum %>'">글목록</button>
		</td>
	</tr>
</table>
</div>
