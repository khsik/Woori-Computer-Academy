<%@page import="products.ProductsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "business.BusinessDTO" %>
								<%-- 장바구니 목록 페이지  --%>
	<%@ include file="../inc/session.jsp" %>
<%
    if (sid == null) {
        // 로그인 상태 아님 -> 로그인 페이지로
        response.sendRedirect("../member/loginForm.jsp");
    }
%>
	<jsp:include page="../inc/header.jsp" />
<%
 	ProductsDAO dao = ProductsDAO.getInstance();
	ArrayList<BusinessDTO> list = null;
	list = dao.jangList(mem_num);
%>
<title>장바구니</title>
<style>
	* {margin:0; padding:0;}
	.de {
		width:30px;
		height:30px;
	}
	#con{
		padding-top:15px;
		padding-left:195px;
		padding-bottom:10px;
		min-height:100vh;
		width:max-content;
		margin:0 auto;
	}
	#allbtn{
		padding:1px 2px;
		margin-bottom:5px;
	}
</style>
<script>
	function jb(){
		let nums = document.querySelectorAll(".nums");
		for(let i=0; i<nums.length; i++){
			nums[i].checked = true;
		}
	}
	function jbuy(){
		let jang = document.jang;
		jang.method = "post";
        jang.target = "_self";
		jang.action = "buyPageForm.jsp";
		jang.submit();
	}
	function jdelet(){
		let jang = document.jang;
		jang.method = "post";
        jang.target = "_self";
		jang.action = "jangDelete.jsp";
		jang.submit();
	}
</script>
<div id="con">
<button type ="button" id="allbtn" onclick="jb()">전체선택</button>
<form name="jang">
<% for(BusinessDTO dto : list){ %>
체크박스<input type = "checkbox" value ="<%=dto.getPnum()%>" name ="pnum" class="nums"/>
	<table border="1" >
		<tr>
			<td>상품 	이미지</td><td>상품 이름</td> <td>상품 가격</td>
		</tr>
		<tr>
			<td class="img">
				<img src="../upload/<%=dto.getThum2()%>" width="300" height="300" />
			</td>
			<td>상품이름:<%=dto.getpName()%><br/> 상품번호:<%=dto.getPnum() %></td>
			<td><%=dto.getPrice()%>&#8361;</td>
		</tr>
	</table>
	<%-- 클릭 했을때 상품 번호가 넘어서가서, 삭제가 되는 버튼 --%>
	<%-- <button onclick="window.location='jangDelete.jsp?num=<%=dto.getNum() %>'"> 선택된 상품 삭제하기</button>--%>
	<br />
<% }%>
	 <button type="button" onclick = "jbuy()">장바구니 구매</button>
	<button type="button" onclick = "jdelet()">선택삭제</button>
	<input type="hidden" name="jang" value="jang"/>
</form>
	<button onclick = "window.location='list.jsp'">목록 보기</button>
</div>
<jsp:include page="../inc/footer.jsp"/>
