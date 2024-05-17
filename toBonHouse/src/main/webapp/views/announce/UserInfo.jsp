<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/adminSession.jsp"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="announce.UserDTO"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="dao" class="announce.UserDAO" />
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
#search {line-height:1.6;}
tr {
	height: 20px;
}

td {
	border: 3px solid black;
	height: 20px;
}
.tdbtn{width: 70px; border: 0px; padding-left:2px;}
</style>

<%-- 회원의 값을 받아야 이를 출력할수 있음. --%>
<%-- 세션을 통해서 로그인 확인을 받고 들어오는 페이지임. --%>
<%-- 리스트로 꺼내야 하나 ?  --%>
<%
String search1 = request.getParameter("search1");
String search2 = request.getParameter("search2");

ArrayList<UserDTO> list = new ArrayList<UserDTO>();
if (search1 == null || search2 == null) {
	list = dao.userInfo();
} else {
	list = dao.search(search1, search2);
}
%>
<jsp:include page="../inc/header.jsp" />

<div id="con">
<form action="UserInfo.jsp" method="get">
	<table>
		<tr>
			<td>유저번호</td>
			<td>아이디</td>
			<td>이름</td>
			<td>회원 등급</td>
		</tr>
		<%		if (list.size() != 0) {		%>
		<%		for (UserDTO dto : list) {		%>

		<tr>
			<%-- 이 tr을 누르면 상세보기로 할까 했지만 버튼으로 따로 둘생각. --%>
			<td><%=dto.getMem_num()%></td>
			<td><%=dto.getId()%></td>
			<td><%=dto.getName()%></td>
			<%			if (dto.getGrade() == -1) {			%>
			<td>탈퇴회원</td>
			<%			} else if (dto.getGrade() == 1) {			%>
						<td>일반회원</td>
			<%			} else if (dto.getGrade() == 2) {			%>
			<td>판매자</td>
			<%			} else if (dto.getGrade() == 3) {			%>
			<td>관리자</td>
			<%			} else {			%>
			<td>오류</td>
			<%			}			%>
			<td class = "tdbtn"><input type="button"
				onclick="window.location='moreInfo.jsp?mem_num=<%=dto.getMem_num()%>'"
				value="상세보기"></td>
		</tr>
		<%		}		%>
		<%		} else {		%>
		<tr>
			<td colspan="4" style="border: 0px; text-align: center;"><br />
				<h3>검색 결과가 없습니다.</h3> <br /></td>
		</tr>
		<%		}		%>
		<%--처리 스크립트로 ? --%>
		<tr id="search">
			<td colspan="4" style="text-align: center; border: 0px;"><select
				name="search1">
					<option value="all" selected>---전체---</option>
					<option value="num">유저번호</option>
					<option value="id">아이디</option>
					<option value="name">이름</option>
					<option value="grade">회원 등급</option>
			</select> <input type="text" name="search2" /> <input type="submit"
				value="검색" /></td>
		</tr>
	</table>
</form>
</div>