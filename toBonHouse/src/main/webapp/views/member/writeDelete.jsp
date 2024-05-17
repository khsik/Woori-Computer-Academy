<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.ReviewDAO" %>
<%@ page import="java.io.File"%>

<%
	request.setCharacterEncoding("UTF-8");	// 인코딩
	int num = Integer.parseInt(request.getParameter("num"));	// 글번호
	String pageNum = request.getParameter("pageNum");			// 페이지번호

	ReviewDAO dao = ReviewDAO.getInstance();		// 인스턴스객체 dao 생성
	String[] img = dao.delete(num);					// 
	if (!(img[0] == null)){
		String filePath = request.getRealPath("views/upload");
		File f = new File(filePath+"/"+img[0]);	// 이미지를 받았다 
		f.delete();
	}

%>  <% if(img[1].equals("1")){%>
	<script>
		alert("글이 삭제됨");
		window.location = "list.jsp?pageNum=<%=pageNum%>";
	</script>	
<% }else{%>
	<script>
		alert("글이 삭제안됌");
		window.location = "list.jsp?pageNum=<%=pageNum%>";
	</script>
<% }%>
	