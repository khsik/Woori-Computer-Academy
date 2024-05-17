<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/ranNum2.css">
<title>random numbers 2</title>
</head>
<body>
	<%
		try{
			int min = Integer.parseInt(request.getParameter("min"));
			int max = Integer.parseInt(request.getParameter("max"));
			int amount = Integer.parseInt(request.getParameter("amount"));
			boolean overlap = Boolean.parseBoolean(request.getParameter("overlap"));
			boolean sort = Boolean.parseBoolean(request.getParameter("sort"));
			%>
			<jsp:forward page="ranNum2_cal.jsp">
				<jsp:param value="<%=min %>" name="min"/>
				<jsp:param value="<%=max %>" name="max"/>
				<jsp:param value="<%=amount %>" name="amount"/>
				<jsp:param value="<%=overlap %>" name="overlap"/>
				<jsp:param value="<%=sort %>" name="sort"/>
			</jsp:forward>
		<%}catch(Exception e){%>
			<jsp:forward page="ranNum2_fw.jsp"/>
		<%}%>
</body>
</html>