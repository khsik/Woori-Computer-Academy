<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>form2</h1>
<form action="pro2.jsp" method="post">
	이름: <input type="text" name="name"><br>
	전화번호: 
	<select name="local">
		<option value="인천">인천</option>
		<option value="서울">서울</option>
		<option value="경기">경기</option>
	</select>
	- <input type="text" name="tel" placeholder="1234-5678"> <br>
	<input type="submit" value="전송">
</form>