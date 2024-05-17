<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../inc/adminSession.jsp" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="announce.UserDTO"%>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="dao" class="announce.UserDAO" />
<html>
<head>
<meta charset="UTF-8">
<title>탈퇴 회원 관리</title>
<style>
* {
	margin: 0px;
	padding: 0px;
}

table {
	/*border: 1px solid black;*/
	/*height : 400px;*/
	margin:0 auto;
	padding: 0px;
	width: 800px;
	border-collapse: collapse;
}
#con {
	padding-top:50px;
	padding-left:175px;
}
.btntd {border:0; padding-left:2px;}
tr {
	height: 20px;
}

td {
	border: 3px solid black;
	height: 20px;
}
</style>
</head>

<jsp:include page="../inc/header.jsp" />

<body>
<div id="con">
	<table style= "padding-top: 40px;">
		<tr>
			<td>유저번호</td>
			<td>탈퇴일자</td>
		</tr>
		<% ArrayList<UserDTO> list = new ArrayList<UserDTO>();
			 list = dao.retireSerch();
				for (UserDTO dto : list) {		%>
				<tr>
					<td><%= dto.getMem_num() %></td>
					<td><%= dto.getResign_day() %></td>
					<td class="btntd"><button type = "button" onClick = "retireForm(<%=dto.getMem_num()%>)">탈퇴</button></td>
				</tr>
		<% } %>
		</table>
</div>
</body>

<script>
function retireForm(mem_num){	// 삭제 팝업창
	let xsize = 1;
	let ysize = 1;
	let x = 0;
	let y = 0;
	// 2, 66 -> 브라우저 창 크기 고려
	window.open("retirePro.jsp?mem_num="+mem_num,
	"_blank", "menubar=no, toolbar=no, width="+xsize+", height="+ysize+", left="+x+", top="+y);
}
</script>
</html>