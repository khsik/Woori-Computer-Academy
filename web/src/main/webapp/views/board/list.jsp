<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="web.test.bean.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<style>
	table, tr, td, th {
		border-collapse:collapse;
		border:solid black 1px;
		margin:5px 0;
		width:700px;
		text-align:center;
	}
	th {
		border-bottom:solid black 2px;
	}
</style>
<h1>/board/list</h1>
<jsp:useBean id="dao" class="web.test.bean.BoardDAO"/>
<%-- for문에서 dto 사용. DTO를 useBean으로 안씀. --%>

<%
	// 페이징 처리
	int pageSize = 3;	// 한 페이지에 보여질 글 개수
	String pageNum = request.getParameter("pageNum");	// 페이지 번호
	if(pageNum == null){ // 페이지 번호 없는 경우
		pageNum = "1"; // 기본값
	}
	int currentPage = Integer.parseInt(pageNum); // 계산에 사용할거라 int로
	// 현재 페이지에서 보일 글 db에서의 rownum 시작과 끝
	int start = (currentPage - 1) * pageSize + 1;
	int end = currentPage * pageSize;
	int count = dao.count();
%>

글목록(전체 글 개수 : <%=count %>)
<table>
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
	</tr>
<%
	ArrayList<BoardDTO> list = dao.list(start, end);
	for(BoardDTO dto : list){
%>
	<tr>
		<td><%=dto.getNum() %></td>
		<td>
			<a href="content.jsp?num=<%=dto.getNum() %>"><%=dto.getTitle() %></a>
		</td>
		<td><%=dto.getWriter() %></td>
		<td><%=dto.getReg() %></td>
	</tr>
<%	} %>
</table>
<%
	// 페이지처리 공식
	if(count > 0){ // 글 있는 경우
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		int startPage = (int)((currentPage-1) / 10) * 10 + 1;
		
		// 한번에 나올 페이지 수
		int pageBlock = 10;
		int endPage = startPage + pageBlock - 1; // 이전 1 2 ... 9 10 다음   에서 이전, 다음 계산용
		if(endPage > pageCount){ // 글 개수보다 많은 페이지 생성 안되도록
			endPage = pageCount;
		}
		
		if(startPage > 10){ %>
			<a href="list.jsp?pageNum=<%=startPage-10 %>">[이전]</a>
<%		}
		for(int i=startPage; i<=endPage; i++){ %>
			<a href="list.jsp?pageNum=<%=i %>">[<%=i %>]</a>
<%		}
		if(endPage < pageCount){ %>
			<a href="list.jsp?pageNum=<%=startPage+10 %>">[다음]</a>
<%		}
	}
%>
<button onclick="window.location='writeForm.jsp'">글쓰기</button>
