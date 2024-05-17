<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dao" class="web.test.bean.BoardDAO"/>
<jsp:useBean id="dto" class="web.test.bean.BoardDTO"/>
<jsp:setProperty name="dto" property="*" />
<%
	// int num = Integer.parseInt(request.getParameter("num"));
	int result = dao.updatePro(dto);
	if(result == 1){
%>
	<h2><%=dto.getNum() %>번 글이 수정되었습니다.</h2>
	<button onclick="window.location='content.jsp?num=<%=dto.getNum() %>'">돌아가기</button>
	<button onclick="window.location='list.jsp'">글목록</button>
<%	}else{ %>
	<script>
		alert("잘못된 접근입니다.");
		window.location="list.jsp";
	</script>
<%	}%>