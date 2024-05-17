<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="webP.userpage.bean.UserBoardDAO"/>
<jsp:useBean id="dto" class="webP.userpage.bean.UserBoardDTO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
<%
	String sid = null;
	int bnum = 0;
	boolean access = false;
	try{
		sid = (String)session.getAttribute("sid");
		bnum = Integer.parseInt(request.getParameter("bnum"));
		access = dao.checkUpdate(bnum, sid);
	}catch(Exception e){%>
<%	}
	if(!access){%>
		<script>
			alert("잘못된 접근입니다.");
			window.location="main.jsp"
		</script>
<%	} %>
<%	dto = dao.getPostContent(bnum); %>
 <form action="postEditTry.jsp" method="post">
 	<input type="hidden" name="writer" value="<%=sid %>">
 	<input type="hidden" name="bnum" value="<%=bnum %>">
 	제목 : <input type="text" name="title" value="<%=dto.getTitle() %>" required> <br>
 	내용 : <br>
 	<textarea name="content" rows="15" cols="55" required><%=dto.getContent() %></textarea>
 	<button type="submit">게시글 수정</button>
 </form>
</body>
</html>