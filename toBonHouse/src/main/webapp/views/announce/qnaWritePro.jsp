<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../inc/session.jsp" %>
<%@ page import = "com.oreilly.servlet.MultipartRequest" %>
<%@ page import = "com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import = "java.io.File" %>
<%@ page import = "announce.AnnounceDAO" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dto" class = "announce.AnnounceDTO" />
<jsp:setProperty property="*" name="dto"/>

<%
	String filePath = request.getRealPath("views/upload");	// 업로드할 실재 파일 경로
	int max = 1024*1024*10;									// 5mb(파일크기)
	String enc = "UTF-8";									// 덮어씌우기 방지역할
	DefaultFileRenamePolicy dp = new DefaultFileRenamePolicy();
	MultipartRequest mr = new MultipartRequest(request,filePath,max,enc, dp);			// 파일 업로드 시에 필요한 것.
	
	String title = mr.getParameter("title");
	String ann_Content = mr.getParameter("ann_Content");
	String ann_Pw = mr.getParameter("ann_Pw");
	String category = mr.getParameter("category");
	String id = sid;
	String ann_Img = mr.getFilesystemName("ann_Img");
	int result = 0;
	
	AnnounceDAO dao = new AnnounceDAO();
	
	dto.setTitle(title);
	dto.setAnn_Content(ann_Content);
	dto.setAnn_Pw(ann_Pw);
	dto.setCategory(category);
	dto.setMem_num(mem_num);
	dto.setId(id);
	
	
		dto.setAnn_Img(ann_Img);
	if (sid != null){
		result = dao.annWrite(dto);
	}
%>

<% if (result == 1){%>
		<script>
			alert("글이 작성되었습니다.");
			window.location = "qna.jsp";
		</script>
	<% }else{ %>
		<script>
			alert("글이 작성되지 않았습니다.\n 다시 다시 확인해 주세요.");
			window.location = "qna.jsp";
		</script>
	<% } %>