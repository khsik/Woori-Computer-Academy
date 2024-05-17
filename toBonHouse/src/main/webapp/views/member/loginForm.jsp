<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%-- 로그인 --%>
<%@ include file="../inc/session.jsp" %>
<%
    // 세션에서 현재 로그인한 사용자 정보 받아오기
	// String sid = (String)session.getAttribute("sid");
    if (sid != null) {
        // 이미 로그인된 상태이므로 메인 페이지로 리다이렉트
        response.sendRedirect("../main.jsp");
    }
%>
<jsp:include page="../inc/header.jsp"/>

<style>
	* { margin:0; padding:0; }
	#con{
		padding-left:170px;
		padding-bottom:10px;
		padding-top:30vh;
		min-height:70vh;
		width:max-content;
		margin:0 auto;
	}
	#con * {margin:2px;}
	#con button {padding:0 1px;}
	h1 {text-align:center;}
</style>

<title>로그인</title>

<div id="con">
	<h1>로그인</h1>
	<form action="loginPro.jsp" method="post">
		<table>
	    <tr><td>id</td> <td><input type="text" name="id" /></td></tr>
	    <tr><td>pw</td> <td><input type="password" name="pw" /></td></tr>
		</table>
	    <label for="auto">자동로그인:</label>
	    <input type="checkbox" name="auto" id="auto" value="1" /> <br />
		<button type="button" onclick = "window.location='insertType.jsp'">회원가입</button>
	    <button type="submit">로그인</button>
	</form>
</div>

<jsp:include page="../inc/footer.jsp"/>
