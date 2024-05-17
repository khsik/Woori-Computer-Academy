<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dao" class="webP.userpage.bean.ReplyDAO"/>
<jsp:useBean id="dto" class="webP.userpage.bean.ReplyDTO"/>
<jsp:setProperty name="dto" property="bnum"/>
<jsp:setProperty name="dto" property="writer"/>
<jsp:setProperty name="dto" property="content"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 등록</title>
</head>
<body>
댓글등록중
<%
	int result = 0;
	result = dao.insertReply(dto);
	if(result != 1){%>
		<script>
			opener.alert("댓글 등록 실패");
		</script>
<%	}%>
<script>
	opener.location.reload();
	self.close();
</script>

</body>
</html>