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
<%	}
	int result = 0;
	result = dao.delete(bnum, sid); %>
<div>
	<br><br>
<%
	if(result == 1){
%>		<b>삭제되었습니다.</b>
<%	} else{ %>
		삭제 실패
<%	} %>
<br><br><br>
<button type="button" onclick="cal();">창닫기</button>
</div>
<script>
	function cal(){
		opener.location.href="userBoard.jsp";
		self.close();
	}
</script>
</body>
</html>