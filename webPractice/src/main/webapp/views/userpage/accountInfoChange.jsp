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
	#btn {
		margin-top:3px;
	}
	#pwCheckR {
		color:red;
		display:none;
	}
	#pwCheckB {
		color:blue;
		display:none;
	}
</style>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
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
<form action="accountInfoChangeDo.jsp" method="post" onsubmit="return pwcheck2()">
	<table>
		<tr>
			<td>아이디</td>
			<td><%=dto.getId() %><input type="hidden" name="id" value="<%=dto.getId() %>"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pw" id="pw" value="<%=dto.getPw() %>" required onchange="pwcheck()"></td>
		</tr>
		<tr>
			<td>비밀번호확인</td>
			<td>
				<input type="password" id="pw2" required onchange="pwcheck()">
				<span id="pwCheckR"><br>비밀번호가 일치하지 않습니다.</span>
				<span id="pwCheckB"><br>비밀번호가 일치합니다.</span>
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%=dto.getName() %></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="email" name="email" value="<%=dto.getEmail() %>" required></td>
		</tr>
		<tr>
			<td>통신사</td>
			<td>
				<select name="phoneC" required>
					<option value="SKT">SKT</option>
					<option value="KT">KT</option>
					<option value="U+">U+</option>
					<option value="MVNO">알뜰폰</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="tel" name="phoneNum" value="<%=dto.getPhoneNum() %>" required placeholder="01012345678" pattern="^[0-9]{6,20}"></td>
		</tr>
	</table>
	<button type="submit">정보수정</button>
	<button type="button" onclick="history.back()">뒤로가기</button>
	<button type="button" onclick="window.location='main.jsp'">메인</button>
</form>
<%	} %>
 <script>
 	function pwcheck(){
	 	var pw1 = document.getElementById("pw").value;
	 	var pw2 = document.getElementById("pw2").value;
 		if(pw1 == pw2){
 			document.getElementById("pwCheckR").style.display = "none";
 			document.getElementById("pwCheckB").style.display = "inline";
 		}else{
 			document.getElementById("pwCheckR").style.display = "inline";
 			document.getElementById("pwCheckB").style.display = "none";
 		}
 	}
 	function pwcheck2(){
 		var pw1 = document.getElementById("pw").value;
	 	var pw2 = document.getElementById("pw2").value;
 		if(pw1 == pw2){return true;}
 		else{
 			alert("비밀번호를 확인해주세요.");
 			return false;
 		}
 	}
 </script>
</body>
</html>