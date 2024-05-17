<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="web.bean.board03.Board03DAO" %>
<%@ page import="java.io.File" %>
<h1>/board03/deletePro2</h1>
<%
	request.setCharacterEncoding("UTF-8");
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
	
	Board03DAO dao = Board03DAO.getInstance();
	String img = dao.delete(num); // 글삭제, img 리턴(없으면 null 리턴)
	
	// 이미지 삭제
	if(img != null){
		String filePath = request.getRealPath("views/upload");
		File f = new File(filePath + "/" + img);
		f.delete();
	}
%>
<script>
	alert("글이 삭제되었습니다");
	window.location="list.jsp?pageNum=<%=pageNum %>";
</script>