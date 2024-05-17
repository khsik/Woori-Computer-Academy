<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../inc/session.jsp" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page import = "announce.AnnounceDTO" %>
<jsp:useBean id="dao" class = "announce.AnnounceDAO" />
	<%-- 헤더 받아야함. --%>
<html>
<head>
<meta charset="UTF-8">
<title>컨텐츠</title>
	<style>
		* {padding:0px; margin:0px;}
		table {
		  	margin: 0 auto;
		  	width : 800px;
		  	height : 600px;
		  	border-collapse:collapse;
		}
		td{
			border: 3px solid black;
		}
		/*
		.cendiv{
			margin-left:250px;
			width : 1600px;
			height : 1000px;
			text-align : left; 
		}
		*/
		.content {
			vertical-align : top;
			text-align :left;
		}
		td img {
			width: 600px;
		}
		#con {
			padding-top:50px;
			padding-left:175px;
			min-height:100vh;
		}
	</style>
</head>

<jsp:include page="../inc/header.jsp" />

<body>
	<%
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		AnnounceDTO dto = new AnnounceDTO();
		dto = dao.contentList(num);
	%>
	<%--
	<h1 style = "text-align :center "> 컨텐츠 페이지 	<%= num %> </h1>
	 --%>
	<%--
		 if 글쓴이라면 삭제, 수정할수 있도록 세션의 값을 넘겨받아서 확인 하도록 해야함.
		 이미지 크기 수정 !!!!
	 --%>
	 <div id = "con">
	 	<table>
	 		<tr style = "height : 40px;" >	
	 			<td>
	 				[<%= dto.getCategory() %>] &nbsp; <%=dto.getTitle() %>
	 			</td>
	 			<td>작성자</td>
	 			<td><%=dto.getId() %> </td>
	 			<td>작성일</td>
	 			<td><%=dto.getAnn_Reg() %> </td>
	 		</tr>
	 		<tr>
	 			<td colspan ="5" style = "vertical-align:top;">
	 			
	 				<%=dto.getAnn_Content() %><br /> <br />
	 				<% if(dto.getAnn_Img() != null){ %> 
	 					<img src="/toBonHouse/views/upload/<%=dto.getAnn_Img() %>" />
	 				<% } %>
	 			</td>
	 		</tr>
	 		
	 		<tr style = "height : 30px;  ">
	 			<td colspan ="5" style = "text-align : right; border: 0px;">
	 				<% if (mem_num == dto.getMem_num() || grade == 3){ %>
	 				<input type = "button" value="리스트로" onClick="window.location= 'qna.jsp'">
				 	<input type = "button" value="수정하기" onClick="window.location= 'updateForm.jsp?num=<%=num %>&pageNum=<%=pageNum %>'" >
				 	<input type = "button" value="글 삭제" onClick="window.location= 'delete.jsp?num=<%=num %>&pageNum=<%=pageNum %>'">
				 	<% } %>
	 			</td>
	 		<tr>
	 	</table>
	 </div>
</body>
</html>

<jsp:include page="../inc/footer.jsp"/>