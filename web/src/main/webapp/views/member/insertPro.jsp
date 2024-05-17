<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>/member/insertPro</h1>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dao" class="web.test.bean.MemberDAO"/>
<jsp:useBean id="dto" class="web.test.bean.MemberDTO"/>
<jsp:setProperty name="dto" property="*"/>

<%
	dao.insertMember(dto); // 메서드 호출(매개변수=파라미터 dto)
%>
<script>
	alert("가입되었습니다.");
	window.location="main.jsp";
</script>