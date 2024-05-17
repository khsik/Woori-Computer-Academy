<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="webP.userpage.bean.UserBoardDTO"%>
<jsp:useBean id="dao" class="webP.userpage.bean.UserBoardDAO"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<style>
	#cbox {
		width: 800px;
		margin: 10px auto;
	}
	h2 {text-align:center;}
	table {	width:100%; }
	#bnum {	width:80px;	text-align:center;}	
	#reg { width:180px;	text-align:right;}
	th {border-bottom:double black 5px;}
	td {border-bottom:dashed darkgray 1px; line-height:1.6;}
	#list {text-align:center;}
	.btns {float:right; margin-left:5px;}
	#count {text-align:left;}
	#cl {color:orange;}
</style>
<meta charset="UTF-8">
<%	String sid = null;
	sid = (String)session.getAttribute("sid");
	if(sid == null){ %>
	<script>
		window.location="main.jsp";
	</script>
<%	} %>
<title>회원게시판</title>
</head>
<body>
<%
	int count = dao.count();
	int postPerList = 5; // 페이지당 출력할 게시글 숫자
	int currentList;	// 현제 페이지 번호
	try{currentList = Integer.parseInt(request.getParameter("currentlist"));}
	catch(Exception e){currentList = 1;} // 처음엔 1
	// 출력할 게시글 rownum 범위
	int start = 1 + (currentList-1)*postPerList;
	int end = currentList * postPerList;
%>
<div id="cbox">

<h2>회원게시판</h2>
<span id="count">전체 글 개수 : <%=count %></span>
<button type="button" class="btns" onclick="window.location='main.jsp'">메인</button>
<button type="button" class="btns" onclick="window.location='postUpload.jsp'">글작성</button>
<table>
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성시간</th>
	</tr>
<%
	ArrayList<UserBoardDTO> posts = dao.postList(start, end);
	for(UserBoardDTO dto : posts){
%>
	<tr>
		<td id="bnum"><%=dto.getBnum() %></td>
		<td><a href="postContent.jsp?currentlist=<%=currentList %>&bnum=<%=dto.getBnum()%>"><%=dto.getTitle() %></a></td>
		<td><%=dto.getWriter() %></td>
		<td id="reg"><%=dto.getReg() %></td>
	</tr>
<%	} %>
</table>
<br>
<div id="list">
<%
	int countList = count / postPerList + (count % postPerList != 0? 1 : 0); // 페이지 개수
	int listBlock = 5; // 한번에 표시할 페이지 수
	int blockNum = (currentList-1)/listBlock + 1; // 현제 페이지 목차
	int startList = (blockNum-1)*listBlock+1;
	int endList = blockNum*listBlock;
	if(endList > countList){endList = countList;}
	if(currentList > listBlock){%>
		<a href="userBoard.jsp?currentlist=<%=startList-listBlock %>">&lt;이전</a>&nbsp;
<%	}
	for(int i=startList; i<=endList; i++){
		if(i == currentList){%>
			<span id="cl"><%=i %></span>&nbsp;
<%		}else{ %>
			<span><a href="userBoard.jsp?currentlist=<%=i %>"><%=i %></a>&nbsp;</span>
<%		}
	}
	if(endList < countList){%>
	<a href="userBoard.jsp?currentlist=<%=startList+listBlock %>">다음&gt;</a>
<%	} %>
</div>

</div>
</body>
</html>