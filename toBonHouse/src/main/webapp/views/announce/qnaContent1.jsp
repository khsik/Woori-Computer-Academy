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
	 				[공지사항] 자주 묻는 질문 
	 			</td>
	 			<td>작성자</td>
	 			<td>관리자</td>
	 			<td>작성일</td>
	 			<td>2024-05-07</td>
	 		</tr>
	 		<tr>
	 			<td colspan ="5" style = "vertical-align:top;">
				<div>
					1. 회원가입은 필수 인가요 ? <br />
					&nbsp;&nbsp;└네 <br />
					2. 환불 가능한가요 <br />
					&nbsp;&nbsp; 가능은 하지만 QNA에 글을 따로 써주기시 바랍니다.
					3. 사업자로 바꾸고 싶어요 <br />
					&nbsp;&nbsp; 또한 글을 작성해주시기 바랍니다.
					4. 비밀번호를 까먹었어요. <br />
					&nbsp;&nbsp; 이메일로 연락 주시길 바랍니다.<br />
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