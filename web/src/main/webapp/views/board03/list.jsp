<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="web.bean.board03.Board03DTO" %>
<%@ page import="web.bean.board03.Board03DAO" %>
<style>
	* {text-align:center; line-height:1.6;}
	.ltext {text-align:left; text-indent:1.5mm;}
	#cl {color:orange;}
	#rbtn {width:700; height:30; margin:0 auto;}
	h1 {line-height:1.2;}
	button {float:right;}
	img {margin-bottom:-3px;}
	table {
		width:700px;
		border-collapse:collapse;
		margin:0 auto;
	}
	table, tr, td, th {border:1px solid black;}
	th {border-bottom:2px solid black;}
</style>
<h1>/board03/list</h1>
<%
	int pageSize = 5;
    String pageNum = request.getParameter("pageNum");
    if (pageNum == null) {
        pageNum = "1";
    }

    int currentPage = Integer.parseInt(pageNum);
    int startRow	= (currentPage - 1) * pageSize + 1;
    int endRow	= currentPage * pageSize;
    int count	= 0;

    ArrayList<Board03DTO> list = null;
    Board03DAO dao = Board03DAO.getInstance();
    count = dao.imgCount(); %>

<b>글 목록(전체 글 : <%=count %>)</b>
<div id="rbtn">
<button type="button" onclick="window.location='writeForm.jsp'">글쓰기</button>
</div>

<%    if (count > 0) { %>
		<table> 
			<tr height="30" > 
				<th align="center"  width="50"  >글번호</th> 
				<th align="center"  width="250" >글제목</th> 
				<th align="center"  width="150" >작성일</th> 
			</tr>
<%
    	list = dao.imgList(startRow, endRow);
		for(Board03DTO dto : list){ %>
			<tr height="30">
				<td align="center"  width="50" >
					<%=dto.getNum()%>
				</td>
				<td width="250" class="ltext">
					<a href="content.jsp?pageNum=<%=pageNum %>&num=<%=dto.getNum() %>"><%=dto.getTitle() %></a>
				<%	if(dto.getImg() != null){ // 이미지 있는 경우 %>
					<img src="../images/image_file.png" height="20px">
				<%	} %>
				</td>
				<td>
					<%=dto.getReg() %>
				</td>
			</tr>
			<%	}%>
		</table>
		
		<div id="list">
<%
		int countList = count / pageSize + (count % pageSize != 0? 1 : 0); // 페이지 개수
		int listBlock = 5; // 한번에 표시할 페이지 수
		int blockNum = (currentPage-1)/listBlock + 1; // 현제 페이지
		int startList = (blockNum-1)*listBlock+1;
		int endList = blockNum*listBlock;
		if(endList > countList){endList = countList;}
		if(currentPage > listBlock){%>
			<a href="list.jsp?pageNum=<%=startList-listBlock %>">&lt;이전</a>&nbsp;
<%		}
		for(int i=startList; i<=endList; i++){
			if(i == currentPage){%>
				<span id="cl"><%=i %></span>&nbsp;
<%			}else{ %>
				<span><a href="list.jsp?pageNum=<%=i %>"><%=i %></a>&nbsp;</span>
<%			}
		}
		if(endList < countList){%>
		<a href="list.jsp?pageNum=<%=startList+listBlock %>">다음&gt;</a>
<%		}
	}else{ %>
		<h2>게시글이 존재하지 않습니다.</h2>
<%	} %>
</div>