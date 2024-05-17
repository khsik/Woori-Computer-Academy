<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>/form</h1>
<form action="result.jsp" method="get">
	메세지:<input type="text" name="msg" value="hello"><br>
	id :<input type="text" name="id"><br>
	pw :<input type="password" name="pw"><br>
	
	<h4>성별</h4>
	M<input type="radio" name="gender" value="m">
	W<input type="radio" name="gender" value="w">
	
	<h4>통신사</h4>
	<select name="ph1">
		<option>KT</option>
		<option>U+</option>
		<option>SKT</option>
		<option>mvno</option>
	</select>
	<input type="text" name="ph2">-
	<input type="text" name="ph3"><br>
	
	<h4>소개</h4>
	<textarea rows="5" cols="40" name="info">안녕하세요.</textarea>
	<br>
	
	<h4>관심</h4>
	1) java<input type="checkbox" name="ch" value="java"><br>
	2) jsp<input type="checkbox" name="ch" value="jsp"><br>
	3) sql<input type="checkbox" name="ch" value="sql"><br><br>
	
	파일 : <input type="file" name="file"><br><br>
	<input type="submit" value="전송">
</form>