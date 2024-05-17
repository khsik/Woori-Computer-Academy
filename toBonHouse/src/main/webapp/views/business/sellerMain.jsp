<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="business.BusinessDAO" %>
<!DOCTYPE html>
<html>
<head>
<style>
	body {
		width:900px;
		margin:30px auto 10px;
		text-align:center;
	}
</style>
<meta charset="UTF-8">
<title>판매자 메인 페이지</title>
</head>
<body>
<%@ include file="../inc/sellerSession.jsp" %><%-- 세션처리 --%>

<%	BusinessDAO dao = BusinessDAO.getInstance(); %>
<div>

	<h2>판매자 메인 페이지</h2>

  <div>
  	<b><%=sid %></b> 님의 <br>
	등록된 상품 : <b><%=dao.countList(mem_num, null) %></b> 개<br>
	누적 주문 : <b><%=dao.countOrder(mem_num) %></b> 건
  </div>
  
  <br>
  
  <div>
	<button type="button" onclick="window.location='myList.jsp'">상품목록</button>
	<button type="button" onclick="window.location='orderList.jsp'">주문목록</button>
	<button type="button" onclick="window.location='../main.jsp'">메인페이지</button>
  </div>
  
</div>

</body>
</html>