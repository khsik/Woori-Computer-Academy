<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<%	String sid = null;
	sid = (String)session.getAttribute("sid");
	if(sid == null){ %>
	<script>
		window.location="main.jsp";
	</script>
<%	} %>
<title>게시글 작성</title>
</head>
<body>
 <form action="postUploadTry.jsp" method="post">
 	<input type="hidden" name="writer" value="<%=sid %>">
 	제목 : <input type="text" name="title" required> <br>
 	내용 : <br>
 	<textarea name="content" rows="15" cols="55" required></textarea>
 	<button type="submit">게시글 등록</button>
 </form>
</body>
</html>