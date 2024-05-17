<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>/member/InsertForm</h1>

<script>
	function memCheck(){
		var userInput = eval("document.userInput");
		if( !userInput.id.value ){
			alert("아이디를 입력해주세요.");
			userInput.id.focus();
			return false;
		}
		if(userInput.pw.value == ''){
			alert("비밀번호를 입력해주세요.");
			userInput.pw.focus();
			return false;
		}
		if(userInput.pw.value != userInput.pw2.value ){
			alert("비밀번호가 일치하지 않습니다.");
			userInput.pw.focus();
			return false;
		}
	}

	function idCheck(){
		var id = document.getElementById("id").value;
		open("confirmId.jsp?id="+id,'confirm', 'width=400,heigth=400');
	}
</script>

<form action="InsertPro.jsp" method="get" name="userInput" onsubmit="return memCheck()">
	&nbsp;&nbsp;*<i>필수입력사항</i> <br>
	id*:		<input type="text" name="id" id="id" required/>		<br />
			<input type="button" value="중복확인" 
				onclick="idCheck();"/>
				
			<div id="idResult"></div>	
				
	pw*: 	<input type="password" name="pw" required />	<br />
	pw확인: 	<input type="password" name="pw2" />	<br />
	이름*:	<input type="text" name="name" required />	<br />
	생년월일:	<input type="date" name="birth" />	<br />
	통신사:	<select name="phone1">
				<option value="U+">U+</option>
				<option value="KT">KT</option>
				<option value="SKT">SKT</option>
				<option value="알뜰폰">알뜰폰</option>
			</select>
			<br>
	핸드폰번호*:	<input type="text" name="phone2" required />	<br />
	성별:	<input type="radio" name="gender" value="m" /> 남
			<input type="radio" name="gender" value="w" /> 여 <br />
			<input type="submit" value="회원가입" />
</form>