<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "business.BusinessDTO" %>
<%@ page import = "products.ProductsDAO" %>
								<%-- 상품 목록 페이지 --%>
<% request.setCharacterEncoding("UTF-8");%>
<% ProductsDAO dao = ProductsDAO.getInstance(); %>
<%@ include file="../inc/session.jsp" %>

<title>상품 목록</title>
<jsp:include page="../inc/header.jsp"/>
<style>
	* {margin:0; padding:0;}
	#con {min-height:100vh;}
	.flexbox{display:flex; flex-direction:row; flex-wrap: wrap; margin-left: 170px;}
	.flexbox table{margin:2px; }
	.bottom {margin:10px auto;}
	.texttr, .texttr td {height:21px;}
	<%-- display:flex = 수평또는 수직 정렬 flex-direction:row = 수평 정렬로  margin-left = 왼쪽 빈공간 224px flex-wrap = 자동 줄바꿈 --%>
	.imgtd {position:relative; width:350px; height:350px; overflow:hidden;}
	.imgtd img{position:absolute; top:0; left:0; width:350px; height:350px;}
	.imgtd img:nth-child(2){opacity:0;	transition:opacity 0.4s;}
	.imgtd:hover img:nth-child(2){opacity:1; /* transition:opacity 3s; */}
	/*	hover에도 transition 하면 hover시 변하는 속도 따로 지정 가능
		hover 아닌쪽에만 적으면 양방향 똑같이 지정됨	*/
</style>
<% 
	String cook = request.getParameter("cook");
	String cookss = "null 비조리 굽기 끓이기 에어프라이"; // 카테고리 종류들
	String[] cooks = cookss.split(" ");
	if(cook != null){
		boolean allow = false;	// 없는 카테고리면 false
		for(String c : cooks){
			if(c.equals(cook)){
				allow = true;	// 있는 카테고리면 true
				break;
			}
		}
		if(!allow){ // true가 아니면(없는 카테고리일 때) %>
			<script>
				alert("잘못된 접근입니다.");
				window.location="list.jsp";
			</script>
<%		}
	}

	int pageSize = 12;		// 현재 페이지에서 보여지는 글 갯수 
	String pageNum = request.getParameter("pageNum");
	if (pageNum == null) {
		pageNum = "1";
	}
	
	int currentPage = Integer.parseInt(pageNum);
	int startRow = (currentPage - 1) * pageSize +1; // 시작 페이지 
	int endRow = currentPage * pageSize; 
	int count = 0;

	ArrayList<BusinessDTO>list = null;
	list = dao.goodslist(startRow, endRow, cook);
	count = dao.countList(cook);
%>
<center>
<%--
<b>글목록(전체 글 :<%=count%>)</b>
 --%>
<div id="con">
<div class="flexbox">
<%	for(BusinessDTO dto : list){ %>

	<table class= "list" onclick="window.location='content.jsp?pageNum=<%=pageNum%>&pnum=<%=dto.getPnum()%>'">
			<tr>
				<td colspan="3" class="imgtd">
					<img src="../upload/<%=dto.getThum1() %>"/>
					<img src="../upload/<%=dto.getThum2() %>"/>
				</td>
			</tr>
			<tr class="texttr">
				<td>이름</td>
				<td><b><%= dto.getpName() %></b></td>
			</tr>
			<tr class="texttr">
				<td>
					가격 &#92;<%= dto.getPrice() %>
				</td>
			</tr>
	</table>
<%	} %>
</div>
<div class="bottom">
<%
	if (count > 0) {
		int pageCount  = count / pageSize + ( count % pageSize == 0 ? 0 : 1);
		
		int startPage = (int)((currentPage-1)/9)*9+1;
		int pageBlock = 10;
		int endPage = startPage + pageBlock-1;
		
		if(endPage > pageCount){
			endPage = pageCount; 
		}
		
		if(startPage > 10) {	%>
		<a href="list.jsp?pageNum=<%=startPage - 10 %>&cook=<%=cook%>">[이전]</a>
		<%		} %>
<%		for(int i  = startPage ; i <= endPage ; i++){ %>
		<a href ="list.jsp?pageNum=<%= i %>&cook=<%=cook%>">[<%=i %>]</a>
<% 		} %>
<%		if (endPage < pageCount) { %>
		<a href = "list.jsp?pageNum=<%= startPage + 10 %>&cook=<%=cook%>">[다음]</a>
<% 
		}
	}
%>
</div>
</div>
</center>
<jsp:include page="../inc/footer.jsp"/>
									