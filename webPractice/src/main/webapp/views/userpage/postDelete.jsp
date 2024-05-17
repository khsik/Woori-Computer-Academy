<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="webP.userpage.bean.UserBoardDAO"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<style>
	div {
		text-align:center;
	}
	button {
		margin:0 auto;
	}
</style>
<meta charset="UTF-8">
<title>게시글 삭제</title>
</head>
<body>
<%
	String sid = null;
	int bnum = 0;
	try{
		sid = (String)session.getAttribute("sid");
		bnum = Integer.parseInt(request.getParameter("bnum"));
	}catch(Exception e){%>
		<script>
			alert("잘못된 접근입니다.");
			self.close();
		</script>
<%	} %>
<div>
	<br><br>게시글을 삭제하시겠습니까? <br><br><br>
	<button type="button" onclick="window.location='postDelete2.jsp?bnum=<%=bnum %>'">예</button>
	<button type="button" onclick="self.close();">아니오</button>
</div>

</body>
</html>