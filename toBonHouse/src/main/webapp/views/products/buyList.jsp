<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="business.OrderDTO"%>
<%@ page import="products.ProductsDAO"%>
<%@ page import = "java.util.*" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../inc/session.jsp" %>
<%
    if (sid == null) {
        // 로그인 상태 아님 -> 로그인 페이지로
        response.sendRedirect("../member/loginForm.jsp");
    }
%>
<jsp:include page="../inc/header.jsp"/>
<title>주문목록</title>
<style>
	* {margin:0; padding:0;}
	#con {
		padding-left:170px;
		padding-top:5px;
		min-height:100vh;
	}
	img{
		width :100px;
		height :100px;
	}
	.buylist{
		border:1px black solid;
		margin:5px;
	}
	.imgponiter{
		cursor:pointer;
	}
	#noOrder{
		width:max-content;
		margin:0 auto;
		padding-top:200px;
		text-align:center;
	}
</style>
<div id="con">
<%
	ProductsDAO dao = ProductsDAO.getInstance();
	Map<Integer, List<OrderDTO>> mapData =  dao.getBuyList(mem_num);	
	Integer[] bnum = mapData.keySet().toArray(new Integer[mapData.size()]);
	// 주문 기록이 없다면(bnum.length == 0 이라면)
	if(bnum.length == 0){%>
		<h1 id="noOrder">주문 기록이 없습니다.</h1>
<%	}else{
		Arrays.sort(bnum, Collections.reverseOrder());
		for (int i=0; i<bnum.length; i++) { %>
			<div id="<%=bnum[i] %>" class="buylist">
		    <h3>주문번호 : <%=bnum[i] %></h3>
		    <% for (OrderDTO dto : mapData.get(bnum[i])) { %>
				<table>
						<tr>
							<td><img src="../upload/<%=dto.getThum2() %>" onclick="window.location='content.jsp?pnum=<%=dto.getPnum()%>&pageNum=0'" class="imgponiter">상품총 가격:<%=dto.getTotalPrice() %>상품번호:<%=dto.getPnum() %>  </td>
						</tr>
				</table>
			<%	} %>
			</div>	  
<%		}
	}%>
</div>
<jsp:include page="../inc/footer.jsp"/>