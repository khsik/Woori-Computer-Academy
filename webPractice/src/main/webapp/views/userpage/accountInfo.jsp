<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	table, tr, td {
		border-collapse:collapse;
		border:1px solid black;
	}
	td {
		padding:5px;
	}
	td:first-child {
		font-weight:bold;
	}
	.btn {
		margin-top:3px;
	}
</style>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
<jsp:useBean id="dao" class="webP.userpage.bean.UserInfoDAO"/>
<jsp:useBean id="dto" class="webP.userpage.bean.UserInfoDTO"/>
<%
	dto = dao.viewInfo((String)session.getAttribute("sid"));
	if(dto == null){
%>
	<script>
		window.location="main.jsp";
	</script>
<%	}else{ %>
	<table>
		<tr>
			<td>아이디</td><td><%=dto.getId() %></td>
		</tr>
		<tr>
			<td>이름</td><td><%=dto.getName() %></td>
		</tr>
		<tr>
			<td>이메일</td><td><%=dto.getEmail() %></td>
		</tr>
		<tr>
			<td>통신사</td><td><%=dto.getPhoneC() %></td>
		</tr>
		<tr>
			<td>전화번호</td><td><%=dto.getPhoneNum() %></td>
		</tr>
	</table>
	<button type="button" class="btn" onclick="window.location='accountInfoChange.jsp'">정보수정</button>
	<button type="button" class="btn" onclick="history.back()">뒤로가기</button>
<%	} %>
</body>
</html>