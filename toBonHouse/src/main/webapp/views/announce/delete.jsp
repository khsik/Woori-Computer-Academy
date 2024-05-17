<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/adminSession.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<%@ page import="java.io.File"%>
<jsp:useBean id="dao" class="announce.AnnounceDAO" />


<body>
	<h1>글삭제 페이지</h1>

	<%
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");

	String img = dao.delete(num);

	String filePath = request.getRealPath("views/upload");
	File f = new File(filePath + "/" + img);
	f.delete();
	%>


	<script>
		alert("삭제되었습니다");
		window.location = "annList.jsp?pageNum<%=pageNum%>	";
	</script>

</body>
