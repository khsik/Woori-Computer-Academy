<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/adminSession.jsp" %>
<%@ page import="announce.AnnounceDTO" %>
<%@ page import="announce.AnnounceDAO" %>
<% request.setCharacterEncoding("UTF-8"); %>

<%-- 수정 페이지 --%>

<% 
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
	AnnounceDAO dao = new AnnounceDAO();
	AnnounceDTO dto = dao.contentList(num);
%>
<style>
* {
	margin: 0px;
	padding: 0px;
}

textarea {
	height: 6.25em;
	border: none;
	resize: none;
	width: 98%;
	height: 98%;
}

table {
	margin: auto;
	width: 800px;
	height: 600px;
	border-collapse: collapse;
}

td {
	border: 3px solid black;
}

.left {
	width: 160px;
}

img {
	width: 300px;
	height: 300px;
}
</style>


<% if((dto.getCategory()).equals("event")) %>
<jsp:include page="../inc/header.jsp" />
<%-- <h1> 글수정 페이지 (수정중,)  </h1>--%>
<form action = "updatePro.jsp" method = "post" enctype="multipart/form-data">
		<input type = "hidden" name = "num" value = "<%=num %>" />
		<input type = "hidden" name = "pageNum" value = "<%=pageNum %>" />
		<input type = "hidden" name = "mem_num" value = "1">
		<input type = "hidden" name = "ann_Pw" placeholder= "비밀번호" value = "1234" />

	<table>
		<% if((dto.getCategory()).equals("event")){ %>
		<tr style = "height : 40px;" >
			<td class = "left"> 글제목 </td>
			<td> 
				<select name = "category">
					<option value = "event">이벤트</option>
				</select>
				<input type = "text" name = "title" value = "<%=dto.getTitle() %>" placeholder= "글제목을 입력해주세요" />
			</td>
		</tr>

		<tr>
			<td>
				이미지 <br />	
				<input type = "file" name = "ann_Img" style = "width :150px;"/> 
			</td>
			<td>
					<input type = "hidden" name = "orgImg" value="<%=dto.getAnn_Img() %>" />
			
					<img src="/toBonHouse/views/upload/<%=dto.getAnn_Img() %>" />
			</td>

		</tr>
			<% }else if ((dto.getCategory()).equals("announce")) { %>
			<tr style = "height : 40px;">
				<td class = "left"> 글제목 </td>
				<td> 
					<select name = "category">
							<option value = "announce">안내</option>
						</select>
					<input type = "text" name = "title" value = "<%=dto.getTitle() %>" placeholder= "글제목을 입력해주세요" />
				</td>
			<tr>
				<td style = "heigth : 360px;">
					글 내용 (수정)
				</td>
				<td>
					<textarea name = "ann_Content" > <%=dto.getAnn_Content() %></textarea>
				</td>
			</tr>
			<%}else if ((dto.getCategory()).equals("QNA")){ %>
			<tr style = "height : 40px;" >
				<td class = "left"> 글제목 </td>
				<td> 
					<input type = "hidden" name = "category" value ="QNA">
					<input type = "text" name = "title" value = "<%=dto.getTitle() %>" placeholder= "글제목을 입력해주세요" />
				</td>
			</tr>

		<tr>
				<td style = "height : 360px;">
					글 내용 (수정)
				</td>
				<td>
					<textarea name = "ann_Content" > <%=dto.getAnn_Content() %></textarea>
					<br />
					
				</td>
			</tr>

		<tr>
				<td>
					이미지 <br />	
					<input type = "file" name = "ann_Img" style = "width :150px;"/> 
				</td>
				<td style ="vertical-align : top;">
						<input type = "hidden" name = "orgImg" value="<%=dto.getAnn_Img() %>" />
						<img src="/toBonHouse/views/upload/<%=dto.getAnn_Img() %>" />			
						<%-- <img src="/toBonHouse/views/upload/<%=dto.getAnn_Img() %>" />--%>
				</td>

		</tr>
			<% } %>
			<tr>
				<td colspan = "2" style = "border : 0px; text-align: right; height : 30px;	" >
					<input type ="submit" value = "수정하기" /> 
				</td>
		</tr>
	</table>
	<input type="hidden" id="burl" name="burl" value="">
</form>
<script>
	let burl = document.referrer;
	document.getElementById("burl").value = burl;
</script>