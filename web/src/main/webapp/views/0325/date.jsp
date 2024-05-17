<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page errorPage="error.jsp" %>

<h1>0325/date.jsp</h1>
<h2>고의로 에러를 발생시킬 페이지!</h2>

<%
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String strDate = sdf.format(date);
%>
<%-- 고의로 변수 이름 오타내고 에러페이지 확인 --%>
	오늘 날짜는 <%=strDate %> 입니다.