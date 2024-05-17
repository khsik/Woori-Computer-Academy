<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "webP.userpage.bean.ReplyDTO" %>
<jsp:useBean id="dao" class="webP.userpage.bean.ReplyDAO"/>
<!DOCTYPE html>
<html>
<head>
<style>
	.tar {
		float:right;
	}
	.rc {
		border-bottom:1px dotted white;
		padding:3px;
	}
</style>
<meta charset="UTF-8">
<title>댓글</title>
</head>
<body>
<%
	String sid = (String)session.getAttribute("sid");
	int bnum = Integer.parseInt(request.getParameter("bnum"));
	ArrayList<ReplyDTO> list = dao.getReplys(bnum);
	if(list != null){
		for(ReplyDTO dto : list){ %>
			<div class="rc">
				작성자:<%=dto.getWriter() %>
				<span class="tar">
					<%=dto.getReg() %>
					<%if(sid.equals(dto.getWriter())){ %>
					<button type="button" onclick="">수정</button>
					<button type="button" onclick="">삭제</button>
					<%} %>
				</span><br>
				<%=dto.getContent() %>
			</div>
<%		}
	} %>
</body>
</html>