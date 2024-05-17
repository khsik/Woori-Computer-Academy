<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>/member/updateForm</h1>
<jsp:useBean id="dao" class="web.test.bean.MemberDAO"/>
<jsp:useBean id="dto" class="web.test.bean.MemberDTO"/>
<%
	// 로그인 후 개인정보를 보여줘야됨
	// 아이디 정보 꺼내와야함 -> session은 tomcat 서버에서 보관
	String sid = (String)session.getAttribute("sid");
	dto = dao.idInfo(sid);
%>
<form action="updatePro.jsp" method="get">
	id : <%=sid %>
		<input type="hidden" name="id" value="<%=sid %>"> <br>
	pw : <input type="password" name="pw" value="<%=dto.getPw()%>"> <br>
	이름 : <input type="text" name="name" value="<%=dto.getName() %>"> <br>
	생일 : <%=dto.getBirth() %> <br>
	통신사 : 
		<select name="phone1">
			<option value="<%=dto.getPhone1() %>"><%=dto.getPhone1() %></option>
			<option value="LG">LG</option>
			<option value="KT">KT</option>
			<option value="SKT">SKT</option>
			<option value="알뜰폰">알뜰폰</option>
		</select> <br>
	전화번호 : <input type="text" name="phone2" value="<%=dto.getPhone2() %>"> <br>
	성별 : <%=dto.getGender() %> <br>
	<input type="submit" value="정보수정">
	<input type="button" value="돌아가기" onclick="history.go(-1)">
</form>