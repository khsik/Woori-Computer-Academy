<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<style>
	#wrong{
		color:red;
		display:none;
	}
	#tm{
		margin-top:5px;
	}
</style>
<%
	int wrong = 0; // 기본 0, id pw 일치안하면 1
	try{
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies){
			if(c.getName().equals("wrong")){wrong = 1; c.setMaxAge(0);}
			// 로그인 쿠키 남아있으면 바로 로그인 되도록
			if(c.getName().equals("cid")){response.sendRedirect("tryLogin.jsp");}
		}
	}catch(Exception e){}
%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="tryLogin.jsp" method="post">
 <div>
	<input type="text" name="id" placeholder="아이디"> 
	<label for="auto">자동로그인</label> <input type="checkbox" name="auto" id="auto" value="auto"> <br>
	<input type="password" name="pw" placeholder="비밀번호">
	<button type="submit">로그인</button> <br>
		<p id="wrong">아이디와 비밀번호를 확인해주세요.</p>
 </div>
</form> 
 <div id="tm">
 	<input type="button" value="아이디 찾기" onclick="alert('장식')">
 	<input type="button" value="비밀번호 찾기" onclick="alert('장식')">
 	<input type="button" value="회원가입" onclick="window.location='newUser.jsp'">
 </div>
<script>
	if(<%=wrong %> == 1){
		document.getElementById("wrong").style.display = "block";
	}
</script>
</body>
</html>