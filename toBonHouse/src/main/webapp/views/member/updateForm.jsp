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
	input[type=submit]{ margin-top:4px; }
</style>
<%-- 회원 정보 업데이트 --%>

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
<h1>회원 정보 수정</h1> <%-- 제목 --%>
<form action="updatePro.jsp" method="post"> <%-- 정보 수정을 위한 폼 --%>
	<table>
	    <tr>
	    	<td>회원 번호</td>
	    	<td><%=dto.getMem_num() %></td>	<%-- 회원 번호 표시 --%>
	    </tr>
	    <tr>
	    	<td>아이디</td>
	    	<td>
	    		<%=dto.getId() %> <%-- 아이디 표시 --%>
	    		<input type="hidden" name="id" value="<%=dto.getId() %>" /> <%-- 수정할 아이디를 숨은 필드로 설정 --%>
	    	</td>
	    </tr>
	    <tr>
	    	<td>비밀번호</td>
	    	<td><input type="password" name="pw" value="<%=dto.getPw() %>" /></td> <%-- 비밀번호 입력 필드 및 이전 비밀번호 표시 --%>
	    </tr>
	    <tr>
			<td>이름</td>
	        <td><input type="text" name="name" value="<%=dto.getName() %>" /></td> <%-- 이름 입력 필드 및 이전 이름 표시 --%>
	    </tr>
	    <tr>
		    <td>통신사</td>
		    <td>
		    	<select name="tel_com"> <%-- 전화 통신사 선택 드롭다운 --%>
					<option value="<%=dto.getTel_com() %>"><%=dto.getTel_com() %></option> <%-- 이전 선택된 통신사 표시 --%>
					<option value="U+">U+</option>
					<option value="KT">KT</option>
					<option value="SKT">SKT</option>
					<option value="알뜰폰">알뜰폰</option>    
				</select>
			</td>
		</tr>
	    <tr>
	    	<td>전화번호</td>
	    	<td><input type="text" name="tel" value="<%=dto.getTel() %>" /></td> <%-- 전화번호 입력 필드 및 이전 전화번호 표시 --%>
	    </tr>
	    <tr>
			<td>이메일</td>
			<td><input type="email" name="email" value="<%=dto.getEmail() %>" /></td> <%-- 이메일 입력 필드 및 이전 이메일 표시 --%>
	    </tr>
	    <tr>
			<td>주소</td>
			<td><input type="text" name="address" value="<%=dto.getAddress() %>" /></td> <%-- 주소 입력 필드 및 이전 주소 표시 --%>
		</tr>
		<tr>
			<td>회원 등급</td>
			<td><%=dto.getGrade() %></td> <%-- 회원 등급 표시 --%>
	    </tr>
	</table>
	<input type="submit" value="정보수정" /> <%-- 정보 수정 버튼 --%>
</form>
</div>

<jsp:include page="../inc/footer.jsp"/>