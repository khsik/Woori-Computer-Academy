<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../inc/session.jsp" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page import = "announce.AnnounceDTO" %>
<jsp:useBean id="dao" class = "announce.AnnounceDAO" />
	<%-- 헤더 받아야함. --%>
<html>
<head>
<meta charset="UTF-8">
<title>컨텐츠</title>
	<style>
		* {padding:0px; margin:0px;}
		table {
		  	margin: 0 auto;
		  	width : 800px;
		  	height : 600px;
		  	border-collapse:collapse;
		}
		td{
			border: 3px solid black;
		}
		/*
		.cendiv{
			margin-left:250px;
			width : 1600px;
			height : 1000px;
			text-align : left; 
		}
		*/
		.content {
			vertical-align : top;
			text-align :left;
		}
		td img {
			width: 600px;
		}
		#con {
			padding-top:50px;
			padding-left:175px;
			min-height:100vh;
		}
	</style>
</head>
<jsp:include page="../inc/header.jsp" />
<body>

	<%--
		 if 글쓴이라면 삭제, 수정할수 있도록 세션의 값을 넘겨받아서 확인 하도록 해야함.
		 이미지 크기 수정 !!!!
	 --%>
	 <div id = "con">
	 	<table>
	 		<tr style = "height : 40px;" >	
	 			<td>
	 				[공지사항] 탈퇴 회원 관련
	 			</td>
	 			<td>작성자</td>
	 			<td>관리자</td>
	 			<td>작성일</td>
	 			<td>2024-05-07</td>
	 		</tr>
	 		<tr>
	 			<td colspan ="5" style = "vertical-align:top;">
				<div>
					1. 회원 탈퇴후 복구 가능한가요 <br />
					&nbsp;&nbsp;네 30일 이내라면 가능합니다. <br />
					2. 30일 이후에는 어떻게 되나요? <br />
					&nbsp;&nbsp; 복구 불가능하고, 재가입 해주시기 바랍니다.<br />
					고객님들의 개인정보는 완전히 탈퇴 처리 까지만 저장됩니다.  <br />
					
				</div>
	 			</td>
	 		</tr>
	 		
	 		<tr style = "height : 30px;  ">
	 		<tr>
	 	</table>
	 </div>
</body>
</html>
<jsp:include page="../inc/footer.jsp"/>
