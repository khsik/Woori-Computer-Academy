<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../inc/session.jsp" %>
	<%-- 
			이미지를 넣을껀지 아닌지 생각 해야함. 
			이미지를 넣는다면 수정 해야함 !!! 
			지금 버전은 이미지 안넣고 글만 쓰는 버전임!
	 --%>
	 <%--
	 		+ 로그인도 아직 안되서 id 의 값을 못받아옴 !! 
	 		이거도 생각해서 나중에 id 값을 입력받는것이 아니라 
	 		세션에서 받아 와야함 !!
	  --%>
<html>
<head>
<meta charset="UTF-8">
<title> QNA 작성 페이지 </title>
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
	font-size: 14px;
}

table {
	margin: auto;
	width: 100%;
	height: 600px;
}

td {
	border: 1px solid black;
}

.left {
	width: 160px;
}

.cendiv {
	margin:0 auto;
	padding-left:170px;
	padding-top: 40px;
	width: 800px;
	height: 100vh;
	/*text-align : left; */
}

input:focus {
	outline: none;
}

textarea:focus {
	outline: none;
}
</style>
</head>
<body>
<jsp:include page="../inc/header.jsp" />
<div class = "cendiv">

	<form action = "qnaWritePro.jsp" method = "post" enctype="multipart/form-data">
		<%-- <h1>ann_글작성 페이지</h1>--%>
		<table>
			<tr style = "height : 40px;">
				<td class= "left">제목</td>
				<td>
					<%-- 카테고리를 이용해서 값을 꺼낼꺼기 떄문에 QNA 로 글을 작성함. --%>
					<input type ="hidden" name = "category" value = "QNA" />
					<input type = "text" name = "title" placeholder= "글제목을 입력해주세요" style = "height:38px; width : 300px; border : 0px"/>
					<%-- 지금 당장은 비밀번호가 필요한지 모르겠어서 id 값과 같이 히든으로 넘김. --%>
					<input type = "hidden"  name = "mem_num" value = <%=mem_num %>>
					<input type = "hidden"  name = "id" value = "<%=sid %>" />
					비밀번호 : &nbsp;
					<%-- 작성자가 글에 들어올때 필요한 비밀번호 ? --%>
					<input type = "password" name = "ann_Pw" placeholder= "비밀번호" style=  "height:38px; border : 0px;" />
					
				</td>
			</tr>

			<tr>
				<td>글 내용</td>
				<td><textarea name = "ann_Content" ></textarea></td>	
			</tr>
			

			<tr>
				<td colspan = "2" style = " text-align: right; height : 30px">
					첨부파일 : <input type = "file" name = "ann_Img">
				</td>
			</tr>
			<tr>
				<td colspan = "2" style = "border : 0px; text-align: right; height : 30px;	" >
					<input type ="submit" value = "작성하기" /> 
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>
