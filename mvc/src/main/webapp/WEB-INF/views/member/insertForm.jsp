<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>/member/InsertForm</h1>


<form action="insertPro.me" method="get">
	id:		<input type="text" name="id" id="id" />		<br />
	pw: 	<input type="password" name="pw" />	<br />
	name:	<input type="text" name="name" />	<br />
	birth:	<input type="date" name="birth" />	<br />
	phone1:	<select name="phone1">
				<option value="U+">U+</option>
				<option value="KT">KT</option>
				<option value="SKT">SKT</option>
				<option value="알뜰폰">알뜰폰</option>
			</select>
	phone2:	<input type="text" name="phone2" />	<br />
	gender:	<input type="radio" name="gender" value="m" /> 남
			<input type="radio" name="gender" value="w" /> 여 <br />
			<input type="submit" value="회원가입" />
</form>