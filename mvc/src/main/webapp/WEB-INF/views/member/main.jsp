<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>/member/main</h1>

<c:if test="${sessionScope.sid == null}"> <%-- 로그인 안한 상태 --%>
	<input type="button" value="회원가입" 
		onclick="window.location='insertForm.me'" />
	<input type="button" value="로그인"
		onclick="window.location='loginForm.me'" />
</c:if>

<c:if test="${!empty(sessionScope.sid)}"> <%-- 로그인 한 상태 --%>
	<h2>[${sessionScope.sid}] 님 환영합니다 ^^ </h2>
	<input type="button" value="전체회원"
		onclick="window.location='allMember.me'" />
	<input type="button" value="회원탈퇴"
		onclick="window.location='deleteForm.me'" />
	<input type="button" value="내 정보"
		onclick="window.location='updateForm.me'" />
	<input type="button" value="로그아웃"
		onclick="window.location='logout.me'" />
	<input type="button" value="글목록"
		onclick="window.location='../board/list.bo'" />
</c:if>
