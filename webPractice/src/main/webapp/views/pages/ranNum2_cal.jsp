<%@page import="webP.test.RandomNumber2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/ranNum2.css">
<title>calculate</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:include page="ranNum2_fw.jsp"></jsp:include>
<%
	try{
	int min = Integer.parseInt(request.getParameter("min"));
	int max = Integer.parseInt(request.getParameter("max"));
	int amount = Integer.parseInt(request.getParameter("amount"));
	boolean overlap = Boolean.parseBoolean(request.getParameter("overlap"));
	boolean sort = Boolean.parseBoolean(request.getParameter("sort"));
	boolean canGenerate = false;
	if(overlap){
		canGenerate = max > min;
	}else{
		canGenerate = max-min+1 >= amount;
	}
	
	if(canGenerate){
		String stro = overlap ? "중복 허용" : "중복 불가";
		String strs = sort? "정렬 O" : "정렬 X";
		RandomNumber2 rn = new RandomNumber2(max, min, amount, overlap, sort);
		out.println("최소 : "+min+"&nbsp;&nbsp;최대 : "+max+"&nbsp;&nbsp;개수 : "+amount+"<br>");
		out.println(stro + ", " + strs+"<br><br>");
		out.println(rn.getNumbers().replace("[","").replace("]",""));
	}else{
		out.println("조건이 올바르지 않습니다. 확인 후 다시 입력해주세요.");
	}
	}catch(Exception e){
		
	}
%>
</body>
</html>