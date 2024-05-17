<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
	<style>
		form {
			line-height:1.8;
		}
		input, select {
			margin-top:10px;
			display:inline-block;
		}
		td{
			text-align:center;
		}
	</style>
</head>
<h1>form4</h1>
<h3>이름 학년(radio) 학번 선택과목(select)</h3>
<form action="pro4.jsp" method="get">
	<b>이름 : </b><input type="text" name="name" required><br>
	<table>
		<tr>
		</tr>
		<tr>
			<th>학년 :</th>
			<td>1</td>
			<td>2</td>
			<td>3</td>
			<td>4</td>
		</tr>
		<tr>
			<td></td>
			<td><input type="radio" name="grade" value="1" checked></td>
			<td><input type="radio" name="grade" value="2"></td>
			<td><input type="radio" name="grade" value="3"></td>
			<td><input type="radio" name="grade" value="4"></td>
		</tr>
	</table>
	<b>학번 : </b><input type="number" name="studentNum" required><br>
	<b>선택과목 : </b>
	<select name="subject">
		<option value="JAVA">JAVA</option>
		<option value="JSP">JSP</option>
		<option value="SPRING">SPRING</option>
	</select>
	<br>
	<input type="submit" value="제출">
</form>