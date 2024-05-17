<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dao" class="webP.userpage.bean.UserBoardDAO"/>
<jsp:useBean id="dto" class="webP.userpage.bean.UserBoardDTO"/>
<jsp:setProperty name="dto" property="*"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
<%
	int result = 0;
	result = dao.postUpdate(dto);
	if(result == 1){
%>
		<h3>게시글이 수정되었습니다.</h3>
<%	}else{ %>
		<h3>게시글 수정 실패</h3>
<%	} %>
		<button type="button" onclick="window.location='postContent.jsp?bnum=<%=dto.getBnum() %>'">돌아가기</button>
		<button type="button" onclick="window.location='userBoard.jsp'">글목록</button>
</body>
</html>