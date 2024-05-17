<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="member.MemberDTO" %> <%-- MemberDTO 클래스 import --%>
<%@ page import="member.MemberDAO" %> <%-- MemberDAO 클래스 import --%>
<%@ page import="javax.servlet.http.*" %> <%-- HttpSession 클래스 import --%>
<%@include file="../inc/session.jsp"%>
<%
    if (sid == null) {
        // 로그인 상태 아님 -> 로그인 페이지로
        response.sendRedirect("../member/loginForm.jsp");
    }
%>
<jsp:include page="../inc/header.jsp"/>
<%-- 지갑 페이지 --%>
<!DOCTYPE html>
<html>
<head>
    <title>Wallet</title>
    <style>
    	*{margin:0; padding:0;}
    	#con {
	    	padding-left: 170px;
			padding-top: 50px;
			margin:0 auto;
			width: max-content;
			height: 100vh;
			text-align: center;
    	}
    	#con input[type=submit]{padding:0 2px;}
    </style>
</head>
<body>

<%
    // DAO 및 DTO 생성
    MemberDAO dao = MemberDAO.getInstance(); // MemberDAO 싱글톤 객체 생성
    // String userId = (String) session.getAttribute("sid"); // 현재 세션에서 사용자 아이디 가져오기
    int currentBalance = dao.getBalance(sid); // 사용자의 현재 잔액 조회
    int currentPoint = dao.getPoint(sid); // 사용자의 현재 포인트 조회
%>
<div id="con">
    <h1>충전하기</h1>
    잔액 : <%= currentBalance %> <!-- 사용자의 현재 잔액을 표시 -->
    포인트 : <%= currentPoint %> <!-- 사용자의 현재 포인트를 표시 -->

    <form action="walletPro.jsp" method="post">
        <label for="amount">충전할 금액:</label>
        <input type="number" id="amount" name="amount" required> <!-- 충전할 금액 입력 필드 -->
        <input type="submit" value="충전"> <!-- 충전 버튼 -->
    </form>
</div>

</body>
<jsp:include page="../inc/footer.jsp"/>
</html>
