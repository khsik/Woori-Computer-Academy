<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- request.setCharacterEncoding("UTF-8"); --%>
<h1>/board/delete</h1>
<jsp:useBean id="dao" class="web.test.bean.BoardDAO" />
<%
	int result = 0;
	int num;
	try{
		num = Integer.parseInt(request.getParameter("num"));
		result = dao.delete(num);
	}catch(NumberFormatException e){
		num=-1;
	}
	if(result==1 && num!=-1){
		out.println(num+"번 글이 삭제되었습니다. <br>");
	}else{
		out.println("잘못된 접근입니다.<br>");
	}
%>
<button onclick="window.location='list.jsp'">글목록</button>