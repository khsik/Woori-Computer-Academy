<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="java.io.File" %>
<%@ page import = "web.bean.board03.Board03DAO" %>
<% request.setCharacterEncoding("UTF-8"); %>

<h1>/board03/updatePro2</h1>

<jsp:useBean id="dto" class="web.bean.board03.Board03DTO"/>

<%
	String filePath = request.getRealPath("views/upload"); // 업로드 할 폴더 경로
	int max = 1024*1024*5; // 파일 크기
	String enc = "UTF-8"; // 인코딩
	DefaultFileRenamePolicy dp = new DefaultFileRenamePolicy(); // 같은 이름 덮어쓰기 방지
	MultipartRequest mr = new MultipartRequest(request, filePath, max, enc, dp);

	String title = mr.getParameter("title");
	String orgImg = mr.getParameter("orgImg");
	String img = mr.getFilesystemName("img");
	int num = Integer.parseInt(mr.getParameter("num"));
	String pageNum = mr.getParameter("pageNum");

	Board03DAO dao = Board03DAO.getInstance();
	dto.setNum(num);
	dto.setTitle(title);
	dto.setImg(img);

	if(img == null){ // 이미지 수정 안하는 경우 원본 이름 유지 
		dto.setImg(orgImg);
	}else{ // 이미지 수정 -> 기존 이미지 삭제
		File f = new File(filePath+"/"+orgImg);
		f.delete();
	}

	int result = dao.update2(dto);
	if(result == 1){ %>
		<script>
			alert("글이 수정되었습니다.");
			window.location="list.jsp?pageNum=<%=pageNum %>"
		</script>
<%	}%>