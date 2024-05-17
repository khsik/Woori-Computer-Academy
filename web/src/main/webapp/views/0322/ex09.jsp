<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>ex09</h1>
<h2>forward 액션태그</h2>
<form action="ex11.jsp" method="post">
	ID : 
	<input type="text" name="id"> <br>
	취미 : 
	<select name="hobby">
		<option value="영화">영화보기</option>
		<option value="운동">운동</option>
		<option value="수면">수면</option>
	</select> <br>
	<input type="submit" value="전송">
</form>