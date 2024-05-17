<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="webP.test.RandomNumber" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Random Numbers</title>
</head>
<body>
	<h2>난수 생성</h2>
	<form action="ranNum.jsp" method="get">
		최소 : <input type="number" name="minNum" placeholder="1" required><br>
		최대 : <input type="number" name="maxNum" placeholder="45" required><br>
		개수 : <input type="number" name="amount" required><br>
		중복 : 	
			허용<input type="radio" name="overlap" value="true" checked="checked"> /&nbsp;
			불가<input type="radio" name="overlap" value="false"><br>
		<input type="submit" value="생성">
	</form>
	<hr>
	
	<%
		int min = Integer.parseInt(request.getParameter("minNum"));
		int max = Integer.parseInt(request.getParameter("maxNum"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		boolean overlap = Boolean.parseBoolean(request.getParameter("overlap"));
		String ox = overlap ? "허용" : "불가";
		RandomNumber rn = new RandomNumber(min, max, amount, overlap);
	%>
	<div>
		<p>
			최소 : <%=min%> &nbsp; 최대 : <%=max %> &nbsp; 
			개수 : <%=amount %> &nbsp; 중복 : <%=ox %>
		</p>
		결과 : 
		<%for(int i=0; i<amount; i++){%>
			<%=rn.getNumbers(i)%>&nbsp;
			<%} %>
	</div>
</body>
</html>
<%--
	무작위 숫자 생성
		개수, 범위 입력으로 조절 가능하게
 --%>