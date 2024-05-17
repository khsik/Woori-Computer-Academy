<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, th, tr, td {
		border: 1px solid black;
		border-collapse: collapse;
		padding: 4px 5px;
	}
	.num {
		text-align:center;
	}
	div {
		border:3px dotted gray;
		display: inline-block;
		padding: 5px;
		margin-right:10px;
	}
	div h3 {
		margin:6px;
		text-align:center;
	}
</style>
</head>
<body>
	<h1>0320/ex03.jsp</h1>
	<%for(int i=0; i<3; i++){ %>
			<h1><%=i+1 %>. hello world</h1>
	<%} %>
	
	<hr color="green">
	<%String[] name = {"java", "jsp", "spring"}; %>
	
	<%for(int i=0; i<3; i++){
		out.println("<h3>"+(i+1)+". "+name[i]+"</h3>");
	}%>
	
	<%for(int i=0; i<3; i++){ %>
	<span style="font-size:18px;"><%=i+1%>. <%=name[i] %></span><br>
	<%} %>

	<hr color="red">
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
		</tr>
		<%for(int i=0; i<3; i++){ %>
		<tr>
			<td class="num"><%=i+1%></td>
			<td><%=name[i] %></td>
		</tr>
		<%} %>	
	</table>
	
	<hr color="blue">
	<%for(int i=2; i<10; i++){ %>
		<div>
		<h3><%=i %>단</h3>
		<%for(int j=1; j<10; j++){ %>
			<%=i+" x "+j+" = "+i*j%><br>
		<%} %>
		</div>
	<%} %>
</body>
</html>