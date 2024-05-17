<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../inc/session.jsp" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page import ="java.util.ArrayList" %>
<%@ page import ="announce.AnnounceDTO" %>
<jsp:useBean id="dao" class = "announce.AnnounceDAO" />
<html>
<head>
<meta charset="UTF-8">
<title>QnA</title>
<style>
* {
	margin: 0;
	padding: 0;
}

.cendiv {
	margin-left: 250px;
	padding-top: 40px;
	width: 1600px;
	height: 1000px;
	/*text-align : left; */
}

table {
	/*border : 1px solid black;*/
	width: 85%;
	border-collapse: collapse;
}

tr {
	height:
}
.hover {
	cursor: pointer;
}
tr>td {
	padding-left: 40px;
	height: 40px;
	border-top: 0.5px solid gray;
}
</style>
</head>
<body>
<jsp:include page="../inc/header.jsp" />
<%
	int pageSize = 10;
	
	String pageNum = request.getParameter("pageNum");
	if( pageNum == null ){
		pageNum = "1";
	}
	int currentPage = Integer.parseInt(pageNum);
	int startRow = ( currentPage - 1 ) * pageSize + 1;
	int endRow = currentPage * pageSize;
	
	int count = dao.qnaCount();
	ArrayList<AnnounceDTO> list = dao.qnaList(startRow, endRow);
	
	int cc = count - (Integer.parseInt(pageNum)-1)*pageSize;
	
%>


<div class = "cendiv">
	<h1> qna </h1>
	<table>
		<tr>
			<th style = "width : 220px;">글번호</th>
			<th style = "width : 200px;"></th>
			<th style = "width : 720px;">타이틀</th>
			<th style = "width : 220px;">작성자</th>
		</tr>
		<tr>
			<td>공지사항</td>
			<td> </td>
			<td><a href="qnaContent1.jsp">회원가입 관련</a></td>
			<td>admin</td>
		</tr>
		<tr>
			<td>공지사항</td>
			<td></td>
			<td><a href="qnaContent2.jsp">탈퇴 회원 관련</a></td>
			<td>admin</td>
		</tr>
		<% for (AnnounceDTO dto : list) { %>
		<tr>
			<td> <%=cc %></td>
			<td> </td>
			<td class="hover" onclick ="window.location='qnaContent.jsp?num=<%=dto.getNum()%>&pageNum=<%=pageNum%>'"><%=dto.getTitle() %></td>
			<td> <%=dto.getId() %></td>
		</tr>
		<% cc--; %>
		<% } %>
		<tr>
			<td colspan = "4" style = "text-align : center">
				<% 
					if( count > 0 ){
						int pageCount = count / pageSize +( count % pageSize == 0 ? 0 : 1 );
						int startPage = (int)((currentPage-1)/10) * 10 +1;
						
						int pageBlock = 10;
						
						int endPage = startPage + pageBlock -1;
						if( endPage > pageCount ){
							endPage = pageCount;
						}
						
						if( startPage > 10 ){ %>
							<a href="qna.jsp?pageNum=<%=startPage-10 %>">[이전]</a>
				<% 		}
						for( int i = startPage; i <= endPage; i++ ){ %>
							<a href="qna.jsp?pageNum=<%=i%>">[<%=i %>]</a>
				<%		}
						if( endPage < pageCount){ %>
							<a href="qna.jsp?pageNum=<%=startPage+10 %>">[다음]</a>
				<%		}
					}
				%>
		<%-- 글 작성인데 이거는 비회원은 안보이게 ! --%>
				<% if ( sid != null ){ %>
					<input type = "button" value = "글작성" onClick = "window.location = 'qnaWrite.jsp'" style = "text-align:right">
				<% } %>
			</td>
		</tr>
	</table>
	
</div>
</body>
</html>
<jsp:include page="../inc/footer.jsp"/>
<%-- 
	QNA 페이지에서는 기본적으로 list 로 글이 보일껀데 ? 이 글은 20개 보일것임.
	근데 ? 일반 글에 답글을 달 수 있어야 함.		<< 답글 형식이 아니라
	content 내에서 댓글 형식으로 쓸 생각. 
	QNA 테이블을 추가 해야 하나 ?  << 일단 필요 없을거같으니 패스
	글 자체에는 제목, 글번호 작성자 가 나와야 하고,
	
	content 안에서는 이미지와 글 내용이 들어가 있어야함.
	시퀀스만 따로 만들어서 써도 되나 ?  로우넘으로 쓸 생각중임.
	
	페이징 처리도 해야할꺼고.
	
	
 --%>