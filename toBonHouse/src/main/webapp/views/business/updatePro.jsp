<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="business.BusinessDAO" %>
<%@ page import="business.BusinessDTO" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록 상품 수정</title>
</head>
<body>
<%@ include file="../inc/sellerSession.jsp" %><%-- 세션처리 --%>
<%
	String filePath = request.getRealPath("/views/upload");
	int max = 1024*1024*10;
	String enc = "UTF-8";
	DefaultFileRenamePolicy dp = new DefaultFileRenamePolicy();
	MultipartRequest mr = new MultipartRequest(request, filePath, max, enc, dp);
	
	BusinessDTO dto = new BusinessDTO();
	dto.setPnum(Integer.parseInt(mr.getParameter("pnum")));
	dto.setMem_num(Integer.parseInt(mr.getParameter("mem_num")));
	dto.setpName(mr.getParameter("pName"));
	dto.setCook(mr.getParameter("cook"));
	dto.setPrice(Integer.parseInt(mr.getParameter("price")));
	dto.setStock(Integer.parseInt(mr.getParameter("stock")));
	dto.setCompany(mr.getParameter("company"));
	dto.setCountry(mr.getParameter("country"));
	
	// 변경할 이미지 있으면 기존 이미지 삭제
	String thum1 = mr.getFilesystemName("thum1");
	String thum1Org = mr.getParameter("thum1Org");
	if(thum1 == null){
		dto.setThum1(thum1Org);
	}else{
		dto.setThum1(thum1);
		File f = new File(filePath+"/"+thum1Org);
		f.delete();
	}
	
	String thum2 = mr.getFilesystemName("thum2");
	String thum2Org = mr.getParameter("thum2Org");
	if(thum2 == null){
		dto.setThum2(thum2Org);
	}else{
		dto.setThum2(thum2);
		File f = new File(filePath+"/"+thum2Org);
		f.delete();
	}
	
	String detail = mr.getFilesystemName("detail");
	String detailOrg = mr.getParameter("detailOrg");
	if(detail == null){
		dto.setDetail(detailOrg);
	}else{
		dto.setDetail(detail);
		File f = new File(filePath+"/"+detailOrg);
		f.delete();
	}
	
	BusinessDAO dao = BusinessDAO.getInstance();
	int result = dao.update(dto);
	if(result != 1){
%>
	<script>
		alert("상품정보 수정을 실패했습니다.");
	</script>
<%	} else{ %>
	<script>
		alert("상품정보가 수정되었습니다.");
	</script>
<%	} %>
	<script>
		window.location="myList.jsp";
	</script>
</body>
</html>