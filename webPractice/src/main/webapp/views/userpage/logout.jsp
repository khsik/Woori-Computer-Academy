<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();
	session.invalidate();
	for(Cookie c : cookies){ // 쿠키 체크 후 삭제
		if(c.getName().equals("cid")){
			c.setMaxAge(0);
			response.addCookie(c);
		}
	}
%>
	<script>
		window.location="main.jsp";
	</script>
</body>
</html>