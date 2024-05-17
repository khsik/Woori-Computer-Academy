<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 탈퇴 회원  ~~</title>
</head>
<body>

	<form action = "resignPro.jsp" method = "post" >
		<%-- 비밀번호, 세션으로 멤넘 등급 id  --%>
		<b> 탈퇴 취소 페이지.</b> <br />
		<b> 아이디와 비밀번호를 입력 해주세요.</b> <br>
		아이디: <input type="text" name="id" > <br>
		비밀번호 : <input type= "password" name = "pw" />
		<input type = "submit"  value = "탈퇴 취소" />
	</form>	
	
</body>
</html>