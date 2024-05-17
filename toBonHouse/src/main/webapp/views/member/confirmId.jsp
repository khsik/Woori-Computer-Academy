<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>member/confirmId.jsp</h1>

<%-- 
    아이디 중복확인 페이지입니다.
--%>

<%@ page import="member.MemberDAO" %>
<jsp:useBean id="dto" class="member.MemberDTO" />
<jsp:setProperty name="dto" property="id" />

<%
	// 유효성 검사
	if(!dto.getId().matches("[a-zA-Z0-9]+")){ %>
		<script>
			opener.document.getElementById("idResult")
				.innerHTML="<font color='red'>사용 불가능한 아이디 입니다.</font>";
			self.close();
		</script>
<%	}
	
    // MemberDAO 객체 생성
	MemberDAO dao = MemberDAO.getInstance();
    // 사용자가 입력한 아이디가 데이터베이스에 이미 존재하는지 확인
	boolean result = dao.confirmId(dto.getId());
	
	if(result == true){
%>
	<script>
        // 중복된 아이디 메시지를 부모 창에 출력하고 현재 창을 닫음
		opener.document.getElementById("idResult")
			.innerHTML="<font color='red'>사용 불가능한 아이디 입니다.</font>";
		self.close();
	</script>
<%}else{%>
	<script>
        // 중복되지 않은 아이디 메시지를 부모 창에 출력하고 현재 창을 닫음
		opener.document.getElementById("idResult")
			.innerHTML="<font color='blue'>사용 가능한 아이디 입니다.</font>";
		self.close();
	</script>
<%}%>

    