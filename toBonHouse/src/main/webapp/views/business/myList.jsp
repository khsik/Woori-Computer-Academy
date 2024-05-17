<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="business.BusinessDAO" %>
<%@ page import="business.BusinessDTO" %>
<!DOCTYPE html>
<html>
<head>
<style>
	body {width:800px; margin:0 auto;}
	img {width:200px; height:200px;}
	table, tr, th, td {border-collapse:collapse; border:1px solid black; text-align:center; padding:2px;}
	table {margin:10px 0px 2px; width:100%;}
	.tbox button {float:right; margin-left:4px; margin-bottom:8px;}
	hr {margin-top:35px; border-top:2px dashed darkgray;}
	#pageBlock {margin:1px auto 10px; width:max-content; padding:0 1px; line-height:1.3; text-align:center;}
	form {width:max-content; margin:0 auto 5px;}
	.linktd{cursor:pointer;}
</style>
<meta charset="UTF-8">
<title>등록 상품 목록</title>
</head>
<body>
<%@ include file="../inc/sellerSession.jsp" %><%-- 세션처리 --%>
<%
	int pageNum; // 현제 페이지
	try{
		pageNum = Integer.parseInt(request.getParameter("pageNum"));
	}catch(Exception e){
		pageNum = 1; // 현제 페이지 기본값 1
	}
	
	String search = request.getParameter("search"); // 없으면 null
	if(search == null){search = "";}	// null 대신 공백으로
	%>
	
<h2><a href="myList.jsp"><%=sid %> 님의 상품목록</a></h2>
<form action="myList.jsp?pageNum=<%=pageNum %>&search=<%=search %>" method="get">
	<input type="text" name="search" value="<%=search %>" placeholder="상품 이름">
	<input type="submit" value="검색">
</form>

<div>
<button type="button" onclick="window.location='insertForm.jsp'">상품등록</button>
<button type="button" onclick="window.location='orderList.jsp'">주문목록</button>
<button type="button" onclick="location.href='sellerMain.jsp'">판매자 메인</button>
</div>

<%-- 총 주문건수 출력 + 주문확인 페이지 링크 --%>
<%	
	BusinessDAO dao = BusinessDAO.getInstance();
	int countList = dao.countList(mem_num, search); // 총 등록 상품 개수
	int pageSize = 3; // 한 페이지에 표시할 상품 개수
	int start = (pageNum-1)*pageSize + 1; // db에서 가져올 상품 rownum 시작
	int end = pageNum*pageSize; // db에서 가져올 상품 rownum 끝
	if(end > countList){end = countList;} // 실제 개수 넘어가지 않도록
	if(countList == 0){ %>
		<h2>등록된 상품이 없습니다.</h2>
<%	}else{ // 목록 출력. 나중에 주문 정보도 받아와서 판매량도 나오면 좋을거같음. %>
		등록된 상품의 개수 : <b><%=countList %></b> <br>	
<%		ArrayList<BusinessDTO> list = dao.productList(mem_num, start, end, search);
		for(BusinessDTO dto : list){ %>
	<%--
		눌렀을 때 상세정보 링크 걸어야됨.
		href="주소.jsp?pageNum=<%=pageNum%>&search=<%=search %>&pnum=<%=dto.getPnum()%>"
	--%>
			<div class="tbox">
			<table>
				<tr>
					<td class="linktd" rowspan="4" onclick="window.location='../products/content.jsp?pnum=<%=dto.getPnum()%>'">
						<img src="../upload/<%=dto.getThum1() %>">
						<img src="../upload/<%=dto.getThum2() %>">
					</td>
					<th>글번호</th><td><%=dto.getPnum() %></td>
					<th>상품이름</th><td><%=dto.getpName() %></td>
				</tr>
				<tr>
					<th>가격</th><td><%=dto.getPrice() %> 원</td>
					<th>재고</th><td><%=dto.getStock() %> 개</td>
				</tr>
				<tr>
					<th>조리법</th><td><%=dto.getCook() %></td>
					<th>제조사</th><td><%=dto.getCompany() %></td>
				</tr>
				<tr>
					<th>원산지</th><td><%=dto.getCountry() %></td>
					<th>등록일자</th><td><%=dto.getReg() %></td>
				</tr>
			</table>
			<button type="button" onclick="window.location='updateForm.jsp?pnum=<%=dto.getPnum() %>'">수정</button>
			<button type="button" onclick="deleteForm(<%=dto.getPnum() %>)">삭제</button>
			</div>
<%		} %>

	<%
		int blockSize = 5; // 한번에 표시할 페이지 수. ex) 1~5, 6~10 페이지
		int totalPage = ((countList-1) / pageSize) + 1; // 전체 페이지 수
		int currentBlock = (pageNum-1)/blockSize + 1; // 계산용. 현제 페이지 블럭. 1~5 => 1번블럭, 6~10 => 2번블럭, ...
		int startPage = (currentBlock-1)*blockSize + 1; // 표시할 페이지 목록의 시작
		int endPage = currentBlock * blockSize; // 표시할 페이지 목록의 끝
		if(endPage > totalPage){endPage = totalPage;} // 실제 페이지 개수 넘어가지 않도록 처리
	%>
	<hr>
	 <div id="pageBlock">
<%		if(pageNum > blockSize){ %>
			<a href="myList.jsp?pageNum=<%=startPage-blockSize %>&search=<%=search %>">이전</a> &nbsp;
	<%	} %>
		
	<%	for(int i=startPage; i<=endPage; i++){ 
			if(i == pageNum){%>			
				<b><%=i %></b>&nbsp;
		<%	}else { %>
				<a href="myList.jsp?pageNum=<%=i %>&search=<%=search %>"><%=i %></a>&nbsp;
		<%	} %>
	<%	} %>
		
	<%	if(endPage < totalPage){%>
			<a href="myList.jsp?pageNum=<%=startPage+blockSize %>&search=<%=search %>">다음</a>
	<%	} %>
	 </div>
<%	} %>
<script>
	function deleteForm(pnum){	// 삭제 팝업창
		let xsize = 300;
		let ysize = 200;
		let x = (window.innerWidth - xsize - 2) / 2;
		let y = (window.innerHeight - ysize - 66) / 2;
		// 2, 66 -> 브라우저 창 크기 고려
		console.log(x);
		console.log(y);
		window.open("deleteForm.jsp?pnum="+pnum,
		"_blank", "menubar=no, toolbar=no, width="+xsize+", height="+ysize+", left="+x+", top="+y);
	}
</script>
</body>
</html>