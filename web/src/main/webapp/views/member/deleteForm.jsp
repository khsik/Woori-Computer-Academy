<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>/member/deleteForm</h1>

<form action="deletePro.jsp" method="post">
	pw : <input type="password" name="pw"> <br>
	<input type="submit" value="회원탈퇴">
	<input type="button" value="돌아가기" onclick="history.back()">
</form>