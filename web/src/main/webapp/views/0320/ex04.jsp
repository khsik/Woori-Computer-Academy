<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="web.test.jsp.Data" %>
<%-- 메모장이나 JSP 주석을 사용하여 필기 --%>
<h1>0320/ex04.jsp</h1>
<% Date day = new Date(); %>
<h1>날짜 : <%=day %></h1>
<hr>

<h1>count : <%=Data.count %></h1>
<h1>name : <%=Data.name %></h1>
<hr color="orange">

<%Data dt = new Data(); %>
<h1>number : <%=dt.number %></h1>
<h1>str : <%=dt.str %></h1>