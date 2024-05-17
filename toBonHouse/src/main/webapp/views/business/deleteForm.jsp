<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	body {width:270px; height:150px; margin:49px auto 0; text-align:center;}
</style>
<meta charset="UTF-8">
<title>등록된 상품 제거</title>
</head>
<body>
<%@ include file="../inc/sellerSession.jsp" %><%-- 세션처리 --%>
<%
	String pnum = request.getParameter("pnum");
%>
<h3><%=pnum %>번 상품을 <br> 삭제하시겠습니까?</h3>
<button type="button" onclick="window.location='deletePro.jsp?pnum=<%=pnum %>'">예</button>
<button type="button" onclick="self.close()">아니오</button>
</body>
</html>