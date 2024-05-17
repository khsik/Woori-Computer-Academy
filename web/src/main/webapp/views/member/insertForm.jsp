<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>/member/insertForm</h1>

<script>
	function idCheck(){
		var id = document.getElementById("id").value;
		open("confirmId.jsp?id="+id,'confirm', 'width=400, height=400');
	}
</script>

<form action="insertPro.jsp" method="post">
	아이디 : <input type="text" name="id" id="id">
		<input type="button" value="중복확인" onclick="idCheck();"><br>
		<div id="idResult"></div>
		
	비밀번호 : <input type="password" name="pw"> <br>
	이름 : <input type="text" name="name"> <br>
	생일 : <input type="date" name="birth"> <br>
	통신사 : 	<select name="phone1">
				<option value="SKT">SKT</option>
				<option value="KT">KT</option>
				<option value="LG">LG</option>
				<option value="알뜰폰">알뜰폰</option>
			</select> <br>
	전화번호 : <input type="text" name="phone2"> <br>
	성별 :	<label for="man">남자</label><input type="radio" name="gender" value="m" id="man">
			<label for="woman">여자</label><input type="radio" name="gender" value="w" id="woman"> <br>
	<input type="submit" value="멤버 추가">
	<input type="button" value="돌아가기" onclick="history.back()">
</form>
<br>