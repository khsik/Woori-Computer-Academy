<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<style>
	#post {
		width:800px;
		margin:10px auto;
	}
	p, td{
		border-bottom:dashed black 1px;
		line-height:1.8;
		margin-bottom:5px;
	}
	table {width:100%;}
	#content {
		margin: 10px 0 10px;
		border-bottom:dashed black 1px;
		padding-bottom:10px;
		line-height:1.5;
	}
	.ar {
		float:right;
	}
	.ar button {
		height:25px;
	}
	#reply {
		background:#ddd;
		padding:5px;
		margin-top:12px;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dao" class="webP.userpage.bean.UserBoardDAO"/>
<jsp:useBean id="dto" class="webP.userpage.bean.UserBoardDTO"/>
<%
	int bnum = -1;
	try{
		bnum = Integer.parseInt(request.getParameter("bnum"));
	}catch(Exception e){}
	dto = dao.getPostContent(bnum);
	if(bnum != dto.getBnum() || dto.getReg() == null){
%>
	<h3>잘못된 접근, 혹은 이미 삭제된 게시글입니다.</h3>
	<button type="button" onclick="window.location='userBoard.jsp'">목록으로</button>
<%	}else{ %>
 <div id="post">
 	<p>제목 : <%=dto.getTitle() %></p>
	<table>
 		<tr>
 			<td>게시글 번호 : <%=dto.getBnum() %></td>
 			<td>작성일자 : <%=dto.getReg() %></td>
	 		<td>작성자 : <%=dto.getWriter() %></td>
 		</tr>
	</table>
 	<div id="content"><%=dto.getContent() %></div>
 	<div class="ar">
 	<%
 		try{
	 		String sid = (String)session.getAttribute("sid");
	 		if(dto.getWriter().equals(sid)){ %>
	 			<button type="button" onclick="window.location='postEdit.jsp?bnum=<%=dto.getBnum() %>'">글수정</button>
	 			<button type="button" onclick="window.open('postDelete.jsp?bnum=<%=dto.getBnum() %>',
	 					'delete', 'width=300, height=200, left=400, top=150')">
	 					글삭제</button>
<%	 		}
 		} catch(Exception e){}
 	%>
 		<button type="button" onclick="window.location='userBoard.jsp?currentlist=<%=request.getParameter("currentlist") %>'">목록으로</button>
		<button type="button" onclick="window.scrollTo(0,0);">Top</button>
 	</div>
 	댓글
 	<div id="reply">
 	<jsp:include page="replyContent.jsp">
 		<jsp:param value="<%=dto.getBnum() %>" name="bnum"/>
 	</jsp:include>
 	
 	<jsp:include page="replyForm.jsp">
 		<jsp:param value="<%=dto.getBnum() %>" name="bnum"/>
 	</jsp:include>
 	</div>

 </div>
<%	} %>
</body>
</html>