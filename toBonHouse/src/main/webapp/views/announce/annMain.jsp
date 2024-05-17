<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/adminSession.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Community</title>
<style>
* {
	margin: 0px;
	padding: 0px;
}

td {
	border: 1px solid black;
}

.cendiv {
	padding-left: 175px;
	width: max-content;
	min-hegiht:100vh ;
	margin:0 auto;
}
.cendiv div{margin:2px 0;}
a:link {
	color: black
}

a:visited {
	color: black;
}

a:hover {
	color: gray;
}

a:active {
	color: black;
}
</style>
</head>

	<jsp:include page="../inc/header.jsp" />
	
<body>

	<%--
		세션을 받아와야 하는가 ? 필요 없을듯 ?
		// int grade = Integer.parseInt(session.getAttribute("grade"));
		
		join 문을 통해서 id 값을 이용해 member 테이블에 있는 grade 를 꺼내 와야 함.
		String sid = (String)session.getAttribute("sid");
		
		
	--%>
	<div class="cendiv">
		<br /> <br />
		<h1>관리자 메인페이지</h1>
		<div>
			<%-- 공지사항 : 공지글, 이벤트 글 모두 출력 되는곳. --%>
			<a href="annList.jsp">공지사항</a>
		</div>
		<div>
			<%-- 이벤트 : 이벤트 글만 올라오는 곳임. --%>
			<a href="eventList.jsp">이벤트</a>
		</div>
		<div>
			<%-- 고객센터를 따로 둘 필요가 있을까 ? --%>
			<%-- 글을 올릴때 유저의 등급에 따라서 앞에 카테고리를 바꿔주면 될거 같은데. --%>
			<a href="qna.jsp">QNA </a>
		</div>
		<%--
			'관리자' 등급만이 회원 정보를 확인하고, 수정을 할수 있음.
			따라서 판매자와 구매자는 이 버튼을 누를수 없어야 함.
			if(grade == 3){
		 --%>
		<form>
			<%-- 기본적으로 멤버 테이블과 세션이 필요함. --%>
			<input type="button" value="회원정보 확인" onclick="window.location='UserInfo.jsp'"> 
				<input	type="button" value="탈퇴 회원 관리" onClick = "window.location = 'retireForm.jsp'">
		</form>
		<%-- } --%>
	</div>
</body>
</html>