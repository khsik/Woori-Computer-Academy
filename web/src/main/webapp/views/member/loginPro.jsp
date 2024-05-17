<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>/member/loginPro</h1>
<jsp:useBean id="dao" class="web.test.bean.MemberDAO"/>
<jsp:useBean id="dto" class="web.test.bean.MemberDTO"/>
<jsp:setProperty name="dto" property="*" />

<%
	boolean result = dao.loginCheck(dto);
	if(result == true){
		session.setAttribute("sid", dto.getId());
		response.sendRedirect("main.jsp");
	}else{%>
		<script>
			alert("id, pw를 확인해주세요.");
			history.go(-1);
		</script>
<%	}%>