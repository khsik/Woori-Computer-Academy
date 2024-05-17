<%@page import="business.BusinessDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.File"%>
<!DOCTYPE html>
<html>
<head>
<style>
	body {width:270px; height:150px; margin:49px auto 0; text-align:center;}
</style>
<meta charset="UTF-8">
<title>등록된 상품 제거</title>
</head>
<body>
<%@ include file="../inc/sellerSession.jsp" %><%-- 세션처리 --%>
<%
	int pnum = Integer.parseInt(request.getParameter("pnum"));
	BusinessDAO dao = BusinessDAO.getInstance();
	String[] result = dao.delete(mem_num, pnum);
	if(result[0].equals("1")){ // DB에서 삭제 성공
		String filePath = request.getRealPath("views/upload");
		for(int i=1; i<=3; i++){
			if(result[i] != null){ // 이미지가 있다면 삭제
				File f = new File(filePath+"/"+result[i]);
				f.delete();
			}
		}
%>
		<h2>삭제되었습니다.</h2>
<%	} %>
		<button type="button" onclick="closebtn()">닫기</button>
	<script>
		function closebtn(){
			opener.location.reload()	// 부모 창 새로고침
			self.close()	// 창닫기
		};
	</script>
</body>
</html>