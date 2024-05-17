<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dao" class="webP.userpage.bean.UserBoardDAO"/>
<jsp:useBean id="dto" class="webP.userpage.bean.UserBoardDTO"/>
<jsp:setProperty name="dto" property="*"/>
<%
	int result = dao.postUpload(dto);
	if(result == 1){
%>
	<h3>게시글이 등록되었습니다.</h3>
	<button type="button" onclick="window.location='userBoard.jsp'">목록으로</button>
<%	}else{ %>
		<script>
			window.location="main.jsp";
		</script>
<%	} %>
</body>
</html>