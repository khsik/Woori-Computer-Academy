<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage = "true" %>
<% response.setStatus(200); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>잘못된 페이지 입니다.</title>
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
		background-image:url(/toBonHouse/views/error/404.png);
		background-repeat: no-repeat;
		background-position: center;
	}
</style>
</head>
<body>
	<div class = "cendiv" >
		<h3>잘못된 요청입니다.</h3>
		<h4>현재 요청하신 페이지를 찾지 못하였습니다.</h4>
		<h4>다시 돌아가서 확인해주시길 바랍니다.</h4>
		<input type = "button" onClick = "window.location='/toBonHouse/views/main.jsp'" value = " 메인으로 " />
	</div>

</body>
</html>