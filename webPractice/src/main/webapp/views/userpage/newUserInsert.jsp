<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dao" class="webP.userpage.bean.UserInfoDAO"/>
<jsp:useBean id="dto" class="webP.userpage.bean.UserInfoDTO"/>
<jsp:setProperty name="dto" property="*"/>
<title>회원가입 처리</title>
</head>
<body>
<%
	boolean result = dao.newUserInsert(dto);
	if(result){%>
		<script>
			alert("회원가입 되었습니다.");
			window.location="main.jsp";
		</script>
<%	}else{%>
		<script>
			alert("회원가입에 실패했습니다.");
			history.back();
		</script>
<%	} %>		
</body>
</html>