<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>/member/updatePro</h1>
<jsp:useBean id="dao" class="web.test.bean.MemberDAO"/>
<jsp:useBean id="dto" class="web.test.bean.MemberDTO"/>
<jsp:setProperty name="dto" property="*"/>
<%
	String sid = (String)session.getAttribute("sid");
	// dto.setId(sid);
	// updateForm 에서 id 값을 input type=hidden 통해서 보냄. 
	dao.updateMember(dto);
%>
	<script>
		alert("수정이 완료되었습니다.");
		window.location="main.jsp";
	</script>