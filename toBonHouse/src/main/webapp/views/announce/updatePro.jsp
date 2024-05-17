<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/adminSession.jsp" %>
<%@ page import = "com.oreilly.servlet.MultipartRequest" %>
<%@ page import = "com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import = "java.io.File" %>
<%@ page import = "announce.AnnounceDAO" %>
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="dto" class = "announce.AnnounceDTO" />
<jsp:setProperty property="*" name="dto"/>

<%
	String filePath = request.getRealPath("views/upload");
	int max = 1024* 1024 * 5;
	String enc = "UTF-8";
	DefaultFileRenamePolicy dp = new DefaultFileRenamePolicy();
	MultipartRequest mr = new MultipartRequest(request, filePath, max, enc, dp);

	int num = Integer.parseInt(mr.getParameter("num"));
	String pageNum = mr.getParameter("pageNum");
		
	String category = mr.getParameter("category");
	String title = mr.getParameter("title");
	String ann_Content = mr.getParameter("ann_Content");
	String orgImg = mr.getParameter("orgImg");
	String ann_Img = mr.getFilesystemName("ann_Img");
	AnnounceDAO dao = new AnnounceDAO();
	dto.setNum(num);
	dto.setTitle(title);
	dto.setAnn_Img(ann_Img);
	
	if (category.equals("event") ){
		if (ann_Img == null ){// 이미지를 수정 안했을 경우	원본 이름 유지.
			dto.setAnn_Img(orgImg);
		}else if(ann_Img == orgImg) { 
			ann_Img = orgImg;
		}else {			// 이미지 수정할경우	= 원본 이미지 삭제
			File f = new File(filePath+"/"+orgImg);

			f.delete();
		}
	} else if (category.equals("announce")){
		dto.setAnn_Content(ann_Content);
	} else if (category.equals("QNA")){
		if (ann_Img == null ){// 이미지를 수정 안했을 경우	원본 이름 유지.
			dto.setAnn_Img(orgImg);
		}else if(ann_Img == orgImg) { 
			ann_Img = orgImg;
		}else {			// 이미지 수정할경우	= 원본 이미지 삭제
			File f = new File(filePath+"/"+orgImg);

			f.delete();
		}
		dto.setAnn_Content(ann_Content);
	}
	
	int result = dao.update(dto);
	if (result == 1){
		String burl = mr.getParameter("burl");
%>

<script>
	 	alert("글이 수정되었습니다.");
	 	window.location="<%=burl%>";
	</script>
<% } %>
	
	