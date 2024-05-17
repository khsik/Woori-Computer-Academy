<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	div {width:400px; margin:0 auto; text-align:center;}
	button {margin-top:5px;}
</style>
<div>
<h1>/board03/deleteForm</h1>

<%
	String num = "0";
	String pageNum="1";
	try{
		num = request.getParameter("num");
		pageNum = request.getParameter("pageNum");
	}catch(Exception e){} %>
<%	if(num.equals("0")){%>
		<script>
			alert("잘못된 접근입니다.");
			window.location="list.jsp";
		</script>
<%	}else{%>
		글을 삭제하시겠습니까? <br>
		<button type="button" onclick="window.location='deletePro.jsp?num=<%=num %>'">예</button>
		<button type="button" onclick="history.back()">아니오</button>
<%	} %>
</div>