<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<style>
	* {margin:0 auto;}
	h1 {text-align:center; line-height:1.7;}
	#account {
		border: 4px ridge darkgray;
		width: 300px;
		padding:10px;
		line-height:1.7;
	}
	strong {
		font-size:18px;
	}
	button {
		margin-top:10px;
	}
</style>
<meta charset="UTF-8">
<title>Main page</title>
<%
	String sid = null;
	try{sid = (String)session.getAttribute("sid");}catch(Exception e){}
%>
</head>
<body>
<h1>메인페이지</h1>
<div id="account">
<%	if(sid==null){ %>
	<jsp:include page="login.jsp"/>
<%	} else{ %>
	<strong><%=sid %></strong>님 현재 로그인 상태입니다. <br>
	<button type="button" onclick="window.location='logout.jsp'">로그아웃</button>
	<button type="button" onclick="window.location='accountInfo.jsp'">회원정보</button>
	<button type="button" onclick="window.location='userBoard.jsp'">게시판</button>
<%	} %>
</div>
</body>
</html>