<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../inc/session.jsp" %>
<%
	if (sid == null) {
	    // 로그인 상태 아님 -> 로그인 페이지로
	    response.sendRedirect("../member/loginForm.jsp");
	}
%>

<jsp:include page="../inc/header.jsp"/>
<style>
 	* { margin:0; padding:0; }
    #con{
		padding-left:170px;
		padding-bottom:10px;
		padding-top:10vh;
		min-height:90vh;
		width:max-content;
		margin:0 auto;
		text-align:center;
	}
	input[type=submit]{
		margin-top:4px;
		padding:1px 2px;
	}
	#con h1 {margin-bottom:20px;}
	#con p{margin-top:15px; font-color:#eee; font-size:0.9em;}
</style>

<title>회원 탈퇴</title>
<%-- 회원 탈퇴 --%>
<div id="con">
<h1>회원 탈퇴 신청</h1>
<form action="deletePro.jsp" method="get">
	비밀번호 : <input type="password" name="pw" /><br />
		 <input type="submit" value="회원탈퇴" />
</form>
<p>탈퇴 신청시 1달의 유예기간 이후 탈퇴처리됩니다. <br> 유예기간 내에 탈퇴 신청 취소를 할 수 있습니다.</p>
</div>

<jsp:include page="../inc/footer.jsp"/>