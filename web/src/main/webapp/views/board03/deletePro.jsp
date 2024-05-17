<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="web.bean.board03.Board03DAO"%>
<%@page import="java.io.File"%>
<%
	Board03DAO dao = Board03DAO.getInstance();
	int num = 0;
	try{num = Integer.parseInt(request.getParameter("num"));}catch(Exception e){}
	String[] result = dao.deleteContent(num); // [0] "0"삭제실패, "1"삭제성공  [1] null img없음  null아님 img있음
	if(result[0].equals("1")){
		if(result[1] != null){
			String filePath = request.getRealPath("views/upload");
			File f = new File(filePath + "/" + result[1]);
			f.delete();
		}
%>
	<script>
		alert("글이 삭제되었습니다.");
	</script>	
<%	}else {%>
	<script>
		alert("게시글 삭제 실패");
	</script>	
<%	} %>
	<script>
		window.location="list.jsp"
	</script>