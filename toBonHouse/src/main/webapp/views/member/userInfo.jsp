<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="member.MemberDAO" %>
<%@ page import="member.MemberDTO" %>
<style>
	* {margin:0; padding:0;}
	table {border-collapse:collapse;}
	h1 {text-align:center; margin:5px;}
	td {border:1px black solid; padding:7px;}
	#cen {
		width:max-content;
		margin:0 auto;
		padding-left:170px;
		padding-top:5px;
		min-height:100vh;
	}
	#cen button{ margin-top:4px; }
</style>
<%-- 회원 정보 --%>

<%@ include file="../inc/session.jsp" %><%-- 세션 --%>
<%
    if (sid == null) {
        // 로그인 상태 아님 -> 로그인 페이지로
        response.sendRedirect("../member/loginForm.jsp");
    }
%>
<jsp:include page="../inc/header.jsp"/>

<%
    // 싱글톤 객체 생성
    MemberDAO dao = MemberDAO.getInstance();
    MemberDTO dto = new MemberDTO();

    // 현재 로그인한 사용자의 아이디를 세션에서 가져와서 해당 아이디의 정보를 조회하여 DTO에 저장
	dto = dao.idInfo(sid);
%>
<div id="cen">
<h1>회원 정보</h1> <%-- 제목 --%>
	<table>
	    <tr>
	    	<td>회원 번호</td>
	    	<td><%=dto.getMem_num() %></td>
	    </tr>
	    <tr>
	    	<td>아이디</td>
	    	<td>
	    		<%=dto.getId() %>
	    	</td>
	    </tr>
	    <tr>
	    	<td>비밀번호</td>
	    	<td><input type="password" name="pw" value="비밀번호" disabled/></td>
	    </tr>
	    <tr>
			<td>이름</td>
	        <td><%=dto.getName() %></td>
	    </tr>
	    <tr>
		    <td>통신사</td>
		    <td><%=dto.getTel_com() %></td>
		</tr>
	    <tr>
	    	<td>전화번호</td>
	    	<td><%=dto.getTel() %></td>
	    </tr>
	    <tr>
			<td>이메일</td>
			<td><%=dto.getEmail() %></td>
	    </tr>
	    <tr>
			<td>주소</td>
			<td><%=dto.getAddress() %></td>
		</tr>
		<tr>
			<td>회원 등급</td>
			<td><%=dto.getGrade() %></td>
	    </tr>
	</table>
	<button type="button" onclick="window.location='updateForm.jsp'">정보수정</button>
</div>

<jsp:include page="../inc/footer.jsp"/>
