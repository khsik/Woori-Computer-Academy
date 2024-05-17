<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="web.bean.board03.Board03DAO"%>
<%@page import="web.bean.board03.Board03DTO"%>

<style>
	div {margin:0 auto; width:max-content;}
	table {max-width:800px;}
	th {width:110px;}
	h1 {text-align:center; line-height:1.2;}
	#rbtn {text-align:right;}
	th, td {border-bottom:1px darkgray dashed;}
	img {max-width:680px;}
	#ci {display:none;}
</style>
<%
	String pageNum = request.getParameter("pageNum");
	int num = Integer.parseInt(request.getParameter("num"));
	
	Board03DAO dao = Board03DAO.getInstance();
	Board03DTO dto = dao.readContent(num);
%>
<div>
<h1>/board03/updateForm</h1>

<form action="updatePro.jsp" method="post" enctype="multipart/form-data">
<input type="hidden" name="pageNum" value="<%=pageNum %>">
<table>
	<tr><th>글번호</th><td><%=dto.getNum() %><input type="hidden" name="num" value="<%=dto.getNum() %>"></td></tr>
	<tr><th>title</th><td><input type="text" name="title" value="<%=dto.getTitle() %>"></td></tr>
	<%if(dto.getImg() != null){ %>
		<tr>
			<th rowspan="2">기존 이미지</th>
			<td>
				<img src="../upload/<%=dto.getImg() %>">
				<input type="hidden" name="orgImg" value="<%=dto.getImg() %>">
			</td>
		</tr>
		<tr>
			<td>
				<label for="keep">유지</label><input type="radio" name="option" value="keep" id="keep" onchange="chan();" checked> &nbsp;
				<label for="del">삭제</label><input type="radio" name="option" value="del" id="del" onchange="chan();"> &nbsp;
				<label for="change">변경</label><input type="radio" name="option" value="change" id="change" onchange="chan();">
				<p id="ci">변경할 이미지 <br> <input type="file" name="img" id="cimg"></p>
			</td>
		</tr>
	<%}else{ %>
	<tr><th>img</th><td><input type="file" name="img"></td></tr>
	<%} %>
	<tr><td colspan="2" id="rbtn"><input type="submit" value="수정">
	<button type="button" onclick="history.back()">돌아가기</button></td></tr>
</table>
</form>
</div>

<script>
	function chan(){
		if(document.getElementById("change").checked == true){
			document.getElementById("ci").style.display = "block";
			console.log(1);
		}else{
			document.getElementById("cimg").value = null;
			document.getElementById("ci").style.display = "none";
			console.log(2);
		}
	}
</script>