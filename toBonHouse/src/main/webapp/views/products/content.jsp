<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "business.BusinessDTO" %>
<%@ page import="products.ProductsDAO"%>
							<%-- 상품 상세 페이지 --%>
<jsp:include page="../inc/header.jsp" />
	<%request.setCharacterEncoding("UTF-8"); %>
	<%@ include file="../inc/session.jsp" %>
<%
   ProductsDAO dao = ProductsDAO.getInstance();
   String pageNum = request.getParameter("pageNum");
   String spnum = request.getParameter("pnum");
   int pnum = 0;
   if(spnum != null){
      pnum = Integer.parseInt(spnum);
   }
   BusinessDTO dto = dao.Content(pnum);
   if(pnum == 0 || dto.getPnum() == 0){ %>
      <script>
         alert("잘못된 접근입니다.");
         window.location="list.jsp";
      </script>
<%   } %>
<title>상품 정보</title>
<style>
	* {
		margin : 0px;
	}
	table{
		margin :0 auto;
		width :900px;
		height : 500px;
	}
	td {
		border: none;
   	    outline: none;
	}
	.img{
		width  :55px;
		height :55px;
	}
	.hhh {
		height : 100px;
		border: none;
    	outline: none;
	}
	#con{
		width:900px;
		padding-top: 50px;
		padding-left:170px;
		margin :0 auto;
	}
	#detail {margin-top:50px;}
</style>
<div id="con">
<table>
	<tr>
		<td class = "hhh" align ="center"><h1><%=dto.getpName() %></h1></td>
	</tr>
	<tr>
		<td class = "img" rowspan="7"><img src="../upload/<%=dto.getThum2() %>" style="width:600px; height:600px;"></td>	
		<td class = "hhh"><br/><b><%=dto.getCompany()%></b></td>
	</tr>
	<tr>
		<td class = "hhh">상품 가격:<h2><%=dto.getPrice()%>&#8361;</h2><br/></td>
		<td>원산지:<%=dto.getCountry()%></td>
	</tr>
	<tr>
		<td class = "hhh"><button onclick ="window.location='jangBuy.jsp?pnum=<%=pnum%>&title=<%=dto.getpName()%>&mem_num=<%=dto.getMem_num()%>'">장바구니 추가</button></td>
		<td class = "hhh"><button onclick = "window.location='buyPageForm.jsp?pnum=<%=pnum%>'">바로 구매 </button></td>
	</tr>
	<tr>
		<td class = "hhh"><button onclick ="history.go(-1)">뒤로가기</button></td>
	</tr>
</table>
<img src="../upload/<%=dto.getDetail() %>" id="detail">
</div>
<jsp:include page="../inc/footer.jsp"/>

