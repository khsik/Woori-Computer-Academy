<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="web.test.bean.MemberDTO" %>
<h1>/member/allMember</h1>
<jsp:useBean id="dao" class="web.test.bean.MemberDAO"/>
<%
	List<MemberDTO> list = dao.allMember();

	for(MemberDTO dto : list){
%>
	<h2>id : <%=dto.getId() %> / pw : <%=dto.getPw() %> / 이름 : <%=dto.getName() %> / birth : <%=dto.getBirth() %> /
	 통신사 : <%=dto.getPhone1() %> / 전화번호 : <%=dto.getPhone2() %> / 성별 : <%=dto.getGender() %> / 가입날짜 : <%=dto.getReg() %></h2>		
<%	}%>
<input type="button" value="돌아가기" onclick="history.back()">