<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>/member/loginForm</h1>

<form action="loginPro.jsp" method="get">
	id: <input type="text" name="id"> <br>
	pw: <input type="password" name="pw"><br>
	<input type="submit" value="로그인">
	<input type="button" value="돌아가기" onclick="history.back()">
</form>