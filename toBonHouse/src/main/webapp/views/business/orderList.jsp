<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="business.OrderDAO" %>
<%@ page import="business.OrderDTO" %>
<!DOCTYPE html>
<html>
<head>
<style>
	body{max-width:1320px; margin:0 auto;}
	img {width:190px; height:190px; float:left; margin-right:5px;}
	div:after{content=''; display:block; clear:both;}
	span {color:blue; cursor:pointer;}
	h2 {text-align:center;}
	#orders {
		display:flex;
		flex-direction:row;
		flex-wrap:wrap;
		margin:0 auto;
		min-width:800px;
	}
	.order {
		border:1px solid black;
		margin:3px;
		padding:3px;
		width:320px;
		height:190px;
	}
</style>
<meta charset="UTF-8">
<title>주문 목록</title>
</head>
<body>
<%@ include file="../inc/sellerSession.jsp" %><%-- 세션처리 --%>
<%
	OrderDAO dao = OrderDAO.getInstance();
	ArrayList<OrderDTO> list = dao.orderList(mem_num);
	if(list.size() == 0){
%>	<h2>현재 처리중인 주문이 없습니다.</h2>
<%	}else{ %>
	<h2>주문 목록</h2>
	<p>
		<button type="button" onclick="window.location='orderListDetail.jsp'"><b>모든주문 상세보기</b></button>
		<button type="button" onclick="window.location='myList.jsp'">상품목록</button>
		<button type="button" onclick="location.href='sellerMain.jsp'">판매자 메인</button>
	</p>
	<%-- pnum(상품번호) 기준 내림차순 --%>
	<div id="orders">
		<%for(OrderDTO dto : list){ %>
		<div class="order">
			<img src="../upload/<%=dto.getThum2()%>"/>
			상품번호:<%=dto.getPnum() %> <br>
			주문수:<%=dto.getBnum() %> <br>
			총 수량:<%=dto.getAmount() %> <br>
			총 금액:<%=dto.getTotalPrice() %> <br>
			<span onclick="window.location='orderListDetail.jsp?pnum=<%=dto.getPnum()%>'">주문 상세보기</span>
		</div>
<%		} %>
	</div>
<%	} %>
</body>
</html>