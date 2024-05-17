<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../inc/session.jsp"%>
<%
    if (sid == null) {
        // 로그인 상태 아님 -> 로그인 페이지로
        response.sendRedirect("../member/loginForm.jsp");
    }
%>
<jsp:include page="../inc/header.jsp"/>
<%-- 마이페이지 --%>
<!DOCTYPE html>
<html>
<head>
<title>마이페이지</title>
<style>
* {
	margin: 0px;
	padding: 0px;
}

a {
	/*text-decoration: none;*/
}

.cendiv {
	padding-left: 170px;
	padding-top: 50px;
	margin:0 auto;
	width: 350px;
	height: 100vh;
	/*text-align : left; */
}
a {	color: black}
/*a:link {	color: black}
a:visited {	color: black;}
a:active {	color: black;}*/
a:hover {	color: gray;}
</style>
</head>
<body>
	<div class = "cendiv">
		<h1>my Page</h1>

		
		<h3><%=sid%> 님 어서오세요.</h3>
		<br />
		<a href="walletForm.jsp">금액 충전</a> <br />
		<a href="userInfo.jsp">회원 정보</a><br />
		<%-- 회원 탈퇴 --%>
		<a href="deleteForm.jsp">회원 탈퇴</a><br />
		<p>============</p>
		<%-- 여기는 판매자 --%>
		<% if (grade == 2 ){ %>
		<a href="../business/myList.jsp">상품 정보</a><br />
		<a href="../business/orderList.jsp">주문목록</a><br />
		<% } %>
		<% if (grade == 3){ %>
		<a href="/toBonHouse/views/announce/annMain.jsp">관리자 메인</a>
		<% } %>
		
	</div>
</body>
<jsp:include page="../inc/footer.jsp"/>
</html>

<%--
	회원 정보 -> 내 정보 보이도록 수정하기 
			-> 내부에서  회원 정보 수정 + 탈퇴 버튼 만들면 좋을것 같음.
	넣는다면
	
	1.  누적 주문 건수
	2. 금액 ( 이 페이지에서 미리 보기
	3. 장바구니
	4. 작성 리뷰
 --%>