<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ page import="member.MemberDAO" %>
<%@ page import="member.MemberDTO" %>

<%
    // 싱글톤 객체 생성
    MemberDAO dao = MemberDAO.getInstance();   // MemberDAO 싱글톤 객체 생성
%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	int result = dao.restore(id, pw);    
    if (result == 1) {
%>
    	<script>
    		alert("복구가 완료되었습니다.\n 다시 로그인 해주세요.");
    		window.location = "../main.jsp"    		
    	</script>
 <%} %>



</body>
</html>