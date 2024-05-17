<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/adminSession.jsp" %>
<%@ page import = "announce.UserDTO" %>
<% request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="dao" class = "announce.UserDAO" />

<style>
* {
	margin: 0px;
	padding: 0px;
}

table {
	border: 0px solid black;
	margin: 0px auto;
	border-collapse: collapse;
}
#con {
	padding-top:50px;
	padding-left:175px;
}
td {
	border: 3px solid black;
	padding: 4px;
}
</style>
<jsp:include page="../inc/header.jsp" />

<%	
	int member_number = Integer.parseInt(request.getParameter("mem_num"));
	UserDTO dto = dao.moreInfo(member_number);
	String grade22 = request.getParameter("grade22");
	if ( grade22 != null){
		int grade2 = Integer.parseInt(grade22);
		int result = dao.updateGrade(member_number, grade2);
		if(result == 1){%>
			<script>
				window.location="moreInfo.jsp?mem_num=<%=dto.getMem_num() %>";
				alert("등급 수정 성공");
			</script>
<%	}		
	}
%>
<div id="con">
<form action = "moreInfo.jsp?mem_num=<%=dto.getMem_num() %>"  method = "post" >
	<table >
		<tr>
				<%-- 이 tr을 누르면 상세보기로 할까 했지만 버튼으로 따로 둘생각. --%>
				<td>회원번호</td>			
				<td> <%=dto.getMem_num() %> </td>
				<td>아이디</td>
				<td> <%=dto.getId() 	%></td>
				<td>이름</td>
				<td> <%=dto.getName()	%></td>
				<td>등급</td>
				<% if (dto.getGrade() == -1){ %>
					<td>탈퇴회원</td>
				<% }else if(dto.getGrade() == 1){ %>
					<td>일반회원</td>
				<% }else if(dto.getGrade() == 2){%>
					<td>판매자</td>
				<% }else if(dto.getGrade() == 3) { %>
					<td>관리자</td>
				<% }else{ %>
					<td>오류</td>
				<% } %>
				
			</tr>
			<tr>
				<td>통신사</td>
				<td><%=dto.getTel_com() %></td>
				<td>전화번호</td>
				<td><%=dto.getTel() %></td>
				<td>이메일</td>
				<td><%=dto.getEmail() %></td>
				<td>주소</td>
				<td><%=dto.getAddress() %></td>
			</tr>
			
			<tr>
				<td>가입일자</td>
				<td><%=dto.getReg() %></td>
				<td>잔고</td>
				<td><%=dto.getBalance() %></td>
				<td>적립금</td>
				<td><%=dto.getPoint() %></td>
				<td>돌아가기</td>
				<td style ="text-align:right" ><input type = "button" value="돌아가기" onClick="window.location ='UserInfo.jsp'" /></td>
				
			</tr>
					
			<tr>
				<td colspan =8 style ="text-align:right; border : 0px;">
					<%-- 수정 자체는 최초 관리자만 가능하게  ?  --%>
					<% if (mem_num == 1){ %>
						<select name = "grade22"  >
							<option value = "1"   >일반회원	</option>
							<option value = "2"  >판매자		</option>
							<option value = "3"  >관리자		</option>
						</select>
					<input type = "submit" value = "등급수정"  />
					<% } %>
				 </td>
				
			</tr>
	</table>
</form>
</div>
<%-- 
	회원 등급 수정을 이 페이지에서 할것 같음.
	이 페이지에서 등급 수정 버튼을 누르면 ?
 --%>

