<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
	<style>
		* {
			margin-left:auto;
			margin-right:auto;
		}
		h1 {
			text-align:center;
		}
		table, tr, th, td {
			border-collapse:collapse;
			border:1px solid black;
			text-align:center;
			padding:5px;
			font-size:20px;
			color:white;
		}
		table {
			background:linear-gradient(-30deg, black, darkgray);
		}
	</style>
</head>
<h1>pro4</h1>
<hr size="8px" style="background: linear-gradient(0.25turn, red, orange, yellow, green, blue, navy, purple);">
<%
	String name = request.getParameter("name");
	int grade = Integer.parseInt(request.getParameter("grade"));
	String studentNum = request.getParameter("studentNum");
	String subject = request.getParameter("subject");
%>
<table>
	<tr>
		<th>이름</th>
		<th>학년</th>
		<th>학번</th>
		<th>선택과목</th>
	</tr>
	<tr>
		<td><%=name %></td>
		<td><%=grade %></td>
		<td><%=studentNum %></td>
		<td><%=subject %></td>
	</tr>
</table>