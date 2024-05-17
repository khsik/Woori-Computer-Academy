<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="business.BusinessDAO" %>
<%@ page import="business.BusinessDTO" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
</head>
<body>
<%@ include file="../inc/sellerSession.jsp" %><%-- 세션처리 --%>
<%
	String filePath = request.getRealPath("views/upload"); // 업로드 할 폴더 경로
	int max = 1024*1024*10; // 최대 파일 크기 10메가
	String enc = "UTF-8"; // 인코딩
	DefaultFileRenamePolicy dp = new DefaultFileRenamePolicy(); // 같은 이름 덮어쓰기 방지
	MultipartRequest mr = new MultipartRequest(request, filePath, max, enc, dp);
	
	BusinessDTO dto = new BusinessDTO();
	dto.setMem_num(Integer.parseInt(mr.getParameter("mem_num")));
	dto.setpName(mr.getParameter("pName"));
	dto.setCook(mr.getParameter("cook"));
	dto.setThum1(mr.getFilesystemName("thum1"));
	dto.setThum2(mr.getFilesystemName("thum2"));
	dto.setDetail(mr.getFilesystemName("detail"));
	dto.setPrice(Integer.parseInt(mr.getParameter("price")));
	dto.setStock(Integer.parseInt(mr.getParameter("stock")));
	dto.setCompany(mr.getParameter("company"));
	dto.setCountry(mr.getParameter("country"));
	
	BusinessDAO dao = BusinessDAO.getInstance();
	int result = dao.insert(dto);
	if(result == 1){
%>
	<script>
		alert("등록되었습니다.");
		location.replace("myList.jsp");
	</script>
<%	}else{ %>
	<script>
		alert("등록 실패");
	</script>
<%	} %>
</body>
</html>