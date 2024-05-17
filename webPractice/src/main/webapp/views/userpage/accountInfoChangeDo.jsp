<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>
<body>
<jsp:useBean id="dao" class="webP.userpage.bean.UserInfoDAO"/>
<jsp:useBean id="dto" class="webP.userpage.bean.UserInfoDTO"/>
<jsp:setProperty name="dto" property="*"/>
<%
	int result = dao.changeInfo(dto);
	if(result == 1){
%>
	<h3>회원정보가 수정되었습니다.</h3>
	<button type="button" onclick="window.location='accountInfo.jsp'">회원정보</button>
	<button type="button" onclick="window.location='main.jsp'">메인</button>
<%	}else{ %>
	<script>
		window.location="main.jsp";
	</script>
<%	} %>
</body>
</html>