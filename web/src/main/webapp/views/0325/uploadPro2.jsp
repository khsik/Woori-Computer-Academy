<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File"%>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>

<h1>/0325/uploadPro2.jsp</h1>

<%
	String path = request.getRealPath("/views/upload"); // 서비스 된 서버 경로
	// 워크스페이스/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/web/views/upload
	int max = 1024*1024*10; // 크기
	String enc = "UTF-8";
	DefaultFileRenamePolicy dp = new DefaultFileRenamePolicy();
		// 같은 파일 있으면 1, 2 ... 붙여줌
	MultipartRequest mr = new MultipartRequest(request, path, max, enc, dp);
	Enumeration enu = mr.getFileNames();
	while(enu.hasMoreElements()){
		String name = (String)enu.nextElement();
		out.println("<h1>"+mr.getFile(name).getName()+"</h1>");
	}
%>

<h1><%=path %></h1>
<h1><%=mr.getFilesystemName("upload1") %></h1>
<h1><%=mr.getFilesystemName("upload2") %></h1>
<h1><%=mr.getFilesystemName("upload3") %></h1>
