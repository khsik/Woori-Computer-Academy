<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "business.BusinessDTO" %>
<%@ page import="products.ProductsDAO"%>
<%request.setCharacterEncoding("UTF-8"); %>
							<%-- 장바구니 추가 페이지  --%>
	<%@ include file="../inc/session.jsp" %>
<%
    if (sid == null) {
        // 로그인 상태 아님 -> 로그인 페이지로
        response.sendRedirect("../member/loginForm.jsp");
    }
%>
<jsp:include page="../inc/header.jsp"/>
<title>장바구니 추가</title>

<style>
	* {margin:0; padding:0;}
	#con {
		padding-left:170px;
		padding-top:20vh;
		min-height:80vh;
		width:max-content;
		margin:0 auto;
	}
	#con button{padding:0 1px; margin-top:2px;}
	#msg {font-size:1.1em;}
</style>

<div id="con">
<%
	ProductsDAO dao = ProductsDAO.getInstance();
	String pName = request.getParameter("title");
	int pnum = Integer.parseInt(request.getParameter("pnum"));
	int result = dao.jangAdd(mem_num, pnum);
	if(result == 1){
%>
		<p id="msg"><b><%=pName %></b> 상품을 장바구니에 담았습니다.</p>
<%	}else{ %>
		장바구니에 담지 못했습니다.
<%	} %>
		<button onclick = "window.location='jangList.jsp'">장바구니 보기</button>
		<button onclick = "window.location='list.jsp'">상품 목록</button>
		<button onclick = "history.go(-1)">뒤로가기</button>
</div>

<jsp:include page="../inc/footer.jsp"/>