<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%request.setCharacterEncoding("UTF-8");%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="announce.AnnounceDTO"%>
<jsp:useBean id="dao" class="announce.AnnounceDAO" />
<%@include file="../inc/session.jsp"%>

<%
int pageSize = 10;

String pageNum = request.getParameter("pageNum");
if (pageNum == null) {
	pageNum = "1";
}
int currentPage = Integer.parseInt(pageNum);
int startRow = (currentPage - 1) * pageSize + 1;
int endRow = currentPage * pageSize;

int count = dao.count();
int cc = count - (Integer.parseInt(pageNum) - 1) * pageSize;

//전체 게시물 조회 건수 - ((현재 페이지 번호 - 1) * 한 페이지당 보여지는 레코드 수 + 현재 게시물 출력 순서 )
%>

<%-- 
		공지사항 페이지에서는 공지사항을 쓸수 있는 사람은 관리자뿐임 따라서
		세션을받아서 관리자일때만 버튼이 보인다거나, 버튼을 눌러도 권한이 없다고 나오게 만드는거지 ㅇㅇ
		content 에 들어갈땐 글번호를 받아서 들어가도록, 세션이 없어도 들어갈수 있게 해야함.
		관리자가 content 에 들어갔으면, 최하단에 수정하기, 글삭제 버튼이 보이도록 하는것이 좋음. 
	--%>
<html>
<head>
<meta charset="UTF-8">
<title>news</title>
<style>
* {
	margin: 0px;
	padding: 0px;
}

table {
	/*border: 1px solid black;*/
	margin:;
	padding: 0px;
	width: 85%;
	border-collapse: collapse;
}

tr {
	/*border: 1px solid black;*/
}

td {
	/*border: 1px solid black;*/
	
}

.cendiv {
	margin-left: 250px;
	padding-top: 40px;
	width: 1600px;
	height: 1000px;
	/*text-align : left; */
}

tr>td {
	padding-left: 40px;
	height: 40px;
	border-top: 0.5px solid gray;
}

.hover {
	cursor: pointer;
}
</style>
</head>
<body>
	<jsp:include page="../inc/header.jsp" />
	<%ArrayList<AnnounceDTO> list = dao.annList(startRow, endRow);%>

	<div class="cendiv">
		<h1>announce</h1>
		<table>
			<tr>
				<th style="width: 220px;">글번호</th>
				<th style="width: 200px;">카테고리</th>
				<th style="width: 720px;">타이틀</th>
				<th style="width: 220px;">작성시간</th>
			</tr>
			<%-- 여기도 for 문을 통해서 반복해서 글이 나올것임.  --%>
			<%for (AnnounceDTO dto : list) {	%>
			<tr>
				<td><%=cc%></td>
				<%-- 하이퍼링크 or onClick 으로 글 컨텐츠로 들어갈수 있게  --%>
				<td>[<%=dto.getCategory()%>]
				</td>
				<td
					onclick="window.location='annContent.jsp?num=<%=dto.getNum()%>&pageNum=<%=currentPage%>'"
					class="hover"><%=dto.getTitle()%></td>
				<td><%=dto.getAnn_Reg().toString().substring(0, 10)%></td>
			</tr>
			<%cc--;	%>
			<%	}	%>

			<tr>
				<td colspan="4" style="text-align: center">
					<%
					if (count > 0) {
						int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
						int startPage = (int) ((currentPage - 1) / 10) * 10 + 1;

						int pageBlock = 10;

						int endPage = startPage + pageBlock - 1;
						if (endPage > pageCount) {
							endPage = pageCount;
						}

						if (startPage > 10) {		%> 
					<a href="annList.jsp?pageNum=<%=startPage - 10%>">[이전]</a>
					 <% } for (int i = startPage; i <= endPage; i++) { %> 
						 <a href="annList.jsp?pageNum=<%=i%>">[<%=i%>]	</a>
						 	<% } if (endPage < pageCount) {	 %> 
						  		<a href="annList.jsp?pageNum=<%=startPage + 10%>">[다음]</a> 
						 	<%} } %>
						<% if (grade == 3) { %>
					<button onclick="window.location = 'ann_Write.jsp'">글쓰기</button> 
					<% } %>
				
			</tr>
		</table>
	</div>
</body>
</html>
<jsp:include page="../inc/footer.jsp"/>