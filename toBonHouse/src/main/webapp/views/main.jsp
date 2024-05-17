<%@page import="products.ProductsDAO"%>
<%@page import="business.BusinessDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%-- products/list.jsp 가져온거 --%>
<style>
	* {margin:0; padding:0;}
	#flexbox{display:flex; flex-direction:row; margin-left: 170px; flex-wrap: wrap;}
	#flexbox table{margin:2px;}
	.imgtd {position:relative; width:350px; height:350px; overflow:hidden;}
	.imgtd img{position:absolute; top:0; left:0; width:350px; height:350px;}
	.imgtd img:nth-child(2){opacity:0;	transition:opacity 0.4s;}
	.imgtd:hover img:nth-child(2){opacity:1;}
</style>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
<jsp:include page="inc/header.jsp"/>

<%
	ProductsDAO dao = ProductsDAO.getInstance();
	int startRow = 1;
	int endRow = 30;	// 메인에 보여질 상품 개수
	String cook = null;
	ArrayList<BusinessDTO>list = null;
	list = dao.goodslist(startRow, endRow, cook);
	int count = dao.countList(cook);
%>
 <div id="flexbox">
<%	for(BusinessDTO dto : list){ %>
	<table class= "list" onclick="window.location='products/content.jsp?pageNum=0&pnum=<%=dto.getPnum()%>'">
			<tr>
				<td colspan="3" class="imgtd">
					<img src="./upload/<%=dto.getThum1() %>"/>
					<img src="./upload/<%=dto.getThum2() %>"/>
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><b><%= dto.getpName() %></b></td>
			</tr>
			<tr>
				<td>
					가격 &#92;<%= dto.getPrice() %>
				</td>
			</tr>
	</table>
<%	} %>
 </div>
 
<jsp:include page="inc/footer.jsp"/>
</body>
</html>