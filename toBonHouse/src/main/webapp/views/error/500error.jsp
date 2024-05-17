<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage = "true" %>
<% response.setStatus(200); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>500 error 페이지</title>
<style>
	* {margin:0px; padding : 0px;}
	.cendiv {
		margin : auto;
		border : 1px;
		width : 1000px;
		height : 400px;
		padding-top : 300px;
		text-align : center
	}
	body {
		background-image:url(/toBonHouse/views/error/500.png);
		background-repeat: no-repeat;
		background-position: center;
	}
	input[type=button] {
		margin : 15px;
	}
	
</style>
</head>
<body>
	<div class = "cendiv">
		<h2>페이지 로딩에 오류가 생겼습니다. </h2>
		<h2>문제가 반복된다면 관리자에게 연락 바랍니다. </h2>
		<input type = "button" onClick = "window.location='../main.jsp'" value = " 메인으로 " />
		<input type = "button" onClick = "history.go(-1)" value = " 뒤로가기 " />
	</div>
</body>
</html>