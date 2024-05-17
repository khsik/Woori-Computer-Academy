<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>/member/confirmId</h1>
<h2>아이디 중복확인</h2>

<jsp:useBean id="dao" class="web.test.bean.MemberDAO"/>
<jsp:useBean id="dto" class="web.test.bean.MemberDTO"/>
<jsp:setProperty name="dto" property="id" />
<%
	boolean result = dao.confirmId(dto.getId()); // 중복이면 true
	if(result == true){ %>
		<script>
			opener.document.getElementById("idResult")
				.innerHTML="<font color='red'>사용 불가능한 아이디 입니다.</font>";
			self.close();
		</script>
<%	}else{ %>
		<script>
			opener.document.getElementById("idResult")
				.innerHTML="<font color='blue'>사용 가능한 아이디 입니다.</font>";
			self.close();
		</script>
<%	} %>