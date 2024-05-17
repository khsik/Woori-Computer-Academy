<%@page import="web.bean.board03.Board03DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="java.io.File"%>

<h1>/0325/uploadPro.jsp</h1>

<%
	String path = "C:/khs/hs/upload"; // 경로 : 작업폴더 속 upload 폴더 생성
	int max = 1024*1024*10; // 크기
	String enc = "UTF-8"; // 인코딩
	DefaultFileRenamePolicy dp = new DefaultFileRenamePolicy();
	// 같은 파일이 있으면 1, 2,... 붙여서 이름 지어줌.
	
	// new 할 때 이미 업로드가 되고있다.
	MultipartRequest mr = new MultipartRequest(request, path, max, enc, dp);
	
	String name = mr.getParameter("name");
	File f = mr.getFile("save");

%>

<h1>name : <%=name %></h1>
<h1>파일 이름 : <%=f.getName() %></h1>
<h1>파일 크기 : <%=f.length() %></h1>
<h1>파일 업로드 이름 : <%=mr.getFilesystemName("save") %></h1>
<h1>파일 원본 이름 : <%=mr.getOriginalFileName("save") %></h1>
<h1>파일 타입 : <%=mr.getContentType("save") %></h1>
