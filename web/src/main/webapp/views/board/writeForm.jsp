<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>/board/writeForm</h1>

<form action="writePro.jsp" method="post">
	writer: <input type="text" name="writer"> <br>
	title: <input type="text" name="title"> <br>
	content <br>
	<textarea rows="10" cols="50" name="content"></textarea> <br>
	<button type="submit">글쓰기</button>
</form>