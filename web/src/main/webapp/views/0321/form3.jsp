<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>form3</h1>
<hr>
<form action="pro3.jsp" method="post">
	<input type="radio" name="localNum" value="1">1권역 <br>
	<input type="radio" name="localNum" value="2">2권역 <br>
	<input type="radio" name="localNum" value="3">3권역 <br>
	<input type="radio" name="localNum" value="4">4권역 <br>
	<input type="radio" name="localNum" value="5" checked>5권역 <br>
	<input type="radio" name="localNum" value="6">6권역 <br>
	<input type="radio" name="localNum" value="7">7권역 <br>
	<input type="submit" value="제출">
</form>
<hr>
<form action="pro3.jsp" method="post">
	권역 :
	<select name="localNum">
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
		<option value="6">6</option>
		<option value="7">7</option>
	</select>
	<input type="submit" value="제출">
</form>