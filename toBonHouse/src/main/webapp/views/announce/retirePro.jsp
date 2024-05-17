<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="dao" class="announce.UserDAO" />
    <%@ include file="../inc/adminSession.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int re_mem_num =  Integer.parseInt(request.getParameter("mem_num"));
	dao.retire(re_mem_num);
	
	%>
	<script>
		opener.location.reload();
		self.close();
	</script>
</body>
</html>