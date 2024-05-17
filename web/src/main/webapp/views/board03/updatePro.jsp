<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import = "web.bean.board03.Board03DAO" %>
<% request.setCharacterEncoding("UTF-8"); %>


<%
	String filePath = request.getRealPath("views/upload"); // 업로드 할 폴더 경로
	int max = 1024*1024*5; // 파일 크기
	String enc = "UTF-8"; // 인코딩
	DefaultFileRenamePolicy dp = new DefaultFileRenamePolicy(); // 같은 이름 덮어쓰기 방지
	MultipartRequest mr = new MultipartRequest(request, filePath, max, enc, dp);
	
	String title = mr.getParameter("title");
	String num = mr.getParameter("num");
	String img = mr.getFilesystemName("img");
	String pageNum = mr.getParameter("pageNum");
	
	Board03DAO dao = Board03DAO.getInstance();
	int result = dao.updateContent(num, title, img);
	if(result == 1){
%>
	<script>
		alert("글이 수정되었습니다.");
		window.location="content.jsp?pageNum=1&num=<%=num %>";
	</script>
<%	}else{%>
	<script>
		window.locatoin="list.jsp?pageNum=1";
	</script>
<%	}%>