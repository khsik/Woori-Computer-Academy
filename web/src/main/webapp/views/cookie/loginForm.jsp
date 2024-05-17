<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>cookie/loginForm</h1>

<form action="loginPro.jsp" method="get">
	id: <input type="text" name="id"> <br>
	pw: <input type="password" name="pw"> <br>
	<label for="auto">자동로그인</label> <input type="checkbox" name="auto" id="auto" value="1"> <br>
	<input type="submit" value="로그인">
</form>