<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 일반 회원가입할지 판매자 회원가입할지 --%>
<%@ include file="../inc/session.jsp" %>
<%
    if (sid != null) {
        // 이미 로그인된 상태이므로 메인 페이지로 리다이렉트
        response.sendRedirect("../main.jsp");
    }
%>

<jsp:include page="../inc/header.jsp"/>

<style>
    * { margin:0; padding:0; }
    .button {
        /* 버튼의 내부 여백을 설정합니다. (위아래: 10px, 좌우: 20px) */
        padding: 10px 20px;
        /* 버튼 텍스트의 글꼴 크기를 설정합니다. */
        font-size: 16px;
    }
	#con{
		padding-left:170px;
		padding-bottom:10px;
		padding-top:30vh;
		min-height:70vh;
		width:max-content;
		margin:0 auto;
	}
</style>

<title>회원가입</title>

<div id="con">
<input type="button" value="일반 회원가입" onclick="window.location='insertForm.jsp'" class="button" 
style="background-color: #5AC6D0 ; color: white; padding: 10px 20px; font-size: 16px;" />
<input type="button" value="판매자 회원가입" onclick="window.location='sellerInsertForm.jsp'" class="button" 
style="background-color: #448CCB; color: white;" />
</div>

<jsp:include page="../inc/footer.jsp"/>