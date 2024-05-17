<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>댓글 입력</title>
</head>
<body>
<%
	String sid = null;
	try{sid = (String)session.getAttribute("sid");} catch(Exception e){}
	if(sid == null){}
	else{
%>
<br>
<form action="replyInsert.jsp" method="post" onsubmit="popup(this);">
	<input type="hidden" name="writer" value="<%=sid %>">
	<input type="hidden" name="bnum" value="<%=request.getParameter("bnum")%>">
	<textarea name="content" rows="3" cols="100" required></textarea>
	<button type="submit">작성</button>
</form>
<%	} %>
<script>
	function popup(form){
		window.open('', 'rpopup','width=1, height=1, left=-400, top=-150' );
		form.target='rpopup';
	}
</script>
</body>
</html>