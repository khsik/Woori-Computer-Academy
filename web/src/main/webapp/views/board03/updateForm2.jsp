<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="web.bean.board03.Board03DAO"%>
<%@page import="web.bean.board03.Board03DTO"%>

<style>
	div {margin:0 auto; width:max-content;}
	table {max-width:800px;}
	th {width:110px;}
	h1 {text-align:center; line-height:1.2;}
	#rbtn {text-align:right;}
	th, td {border-bottom:1px darkgray dashed;}
	img {max-width:680px;}
</style>
<%
	String pageNum = request.getParameter("pageNum");
	int num = Integer.parseInt(request.getParameter("num"));
	
	Board03DAO dao = Board03DAO.getInstance();
	Board03DTO dto = dao.readContent(num);
%>
<div>
<h1>/board03/updateForm2</h1>

<form action="updatePro2.jsp" method="post" enctype="multipart/form-data">
<input type="hidden" name="pageNum" value="<%=pageNum %>">
<table>
	<tr><th>글번호</th><td><%=dto.getNum() %><input type="hidden" name="num" value="<%=dto.getNum() %>"></td></tr>
	<tr><th>제목</th><td><input type="text" name="title" value="<%=dto.getTitle() %>"></td></tr>
	<%if(dto.getImg() == null){ // 이미지 없는 경우%>
		<tr><th>이미지</th><td><input type="file" name="img"></td></tr>
	<%}else{ // 이미지 있는 경우 %>
		<tr>
			<th>기존 이미지</th>
			<td>
				<input type="hidden" name="orgImg" value="<%=dto.getImg() %>">
				<img src="/web/views/upload/<%=dto.getImg()%>">
			</td>
		</tr>
		<tr>
			<th>변경 이미지</th>
			<td><input type="file" name="img"></td>
		</tr>
	<%} %>
	<tr><td colspan="2" id="rbtn"><input type="submit" value="수정">
	<button type="button" onclick="history.back()">돌아가기</button></td></tr>
</table>
</form>
</div>
