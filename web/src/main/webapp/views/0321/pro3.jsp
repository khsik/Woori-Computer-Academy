<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<h1>pro3</h1>
<hr size="10px" style="background: linear-gradient(0.25turn, red, orange, yellow, green, blue, navy, purple);">
<%
	int localNum = Integer.parseInt(request.getParameter("localNum"));
	String localName;
	switch(localNum){
	case 1 :
		localName="종로, 중구, 용산";
		break;
	case 2 :
		localName="도봉, 강북, 노원, 성북";
		break;
	case 3 :
		localName="동대문, 성동, 중랑, 광진";
		break;
	case 4 :
		localName="강동, 송파";
		break;
	case 5 :
		localName="서초, 강남";
		break;
	case 6 :
		localName="동작, 관악, 금천";
		break;
	case 7 :
		localName="강서, 양천, 영등포, 구로";
		break;
	default :
		localName="없는 권역";
	}
	out.println("<b>"+localNum+"번 권역 : "+localName+"</b>");
%>