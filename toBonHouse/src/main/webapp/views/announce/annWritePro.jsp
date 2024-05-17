<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../inc/adminSession.jsp"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="java.io.File"%>
<%@ page import="announce.AnnounceDAO"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="dto" class="announce.AnnounceDTO" />
<jsp:setProperty property="*" name="dto" />



<%
String filePath = request.getRealPath("views/upload"); // 업로드할 실재 파일 경로
int max = 1024 * 1024 * 10; // 5mb(파일크기)
String enc = "UTF-8"; // 덮어씌우기 방지역할
DefaultFileRenamePolicy dp = new DefaultFileRenamePolicy();
MultipartRequest mr = new MultipartRequest(request, filePath, max, enc, dp); // 파일 업로드 시에 필요한 것.

String category = mr.getParameter("category");
String title = mr.getParameter("title");
String ann_Pw = mr.getParameter("ann_Pw");
String ann_Content = mr.getParameter("ann_Content");
String ann_Img = mr.getFilesystemName("ann_Img");

AnnounceDAO dao = new AnnounceDAO();

dto.setTitle(title);
dto.setAnn_Content(ann_Content);
dto.setAnn_Pw(ann_Pw);
dto.setCategory(category);
dto.setMem_num(mem_num);

int result = 0;

if (ann_Img != null) {

	dto.setAnn_Img(ann_Img);

	result = dao.annWrite(dto);
} else {

	result = dao.annWrite(dto);
}

if (result == 1) {
%>
<script>
	alert("글이 등록되었습니다.");
	window.location = "annList.jsp";
</script>

<%
}
%>