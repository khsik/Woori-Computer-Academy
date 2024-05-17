<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="products.ProductsDAO"%>
<%@ page import="java.sql.SQLException" %>
<%@ page import = "java.util.*" %>
<%@ page import = "java.sql.*" %>
<%request.setCharacterEncoding("UTF-8"); %>
							<%-- 장바구니 판매 페이지  --%>
	<%@ include file="../inc/session.jsp" %>
<%
	ProductsDAO dao = ProductsDAO.getInstance();
    try {
        // 요청 파라미터에서 상품 번호 배열 가져오기
        String[] numStr = request.getParameterValues("pnum");
        // 문자열 배열을 정수 배열로 변환
        int[] numArr = Arrays.stream(numStr).mapToInt(Integer::parseInt).toArray(); 
        // DAO를 사용하여 쇼핑 목록 삭제 메서드 호출
        dao.jangDelete(mem_num, numArr);
    }  catch (Exception e) {
        e.printStackTrace(); // 디버그를 위해 스택 트레이스 출력
    }
%>
	<script>
			window.location='jangList.jsp';
	</script>