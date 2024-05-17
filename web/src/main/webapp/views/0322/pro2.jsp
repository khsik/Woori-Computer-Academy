<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>0322/pro2</h1>
<% request.setCharacterEncoding("UTF-8"); %>

<%-- 자바 bean 사용 --%>

<jsp:useBean class="web.test.jsp.Tv" id="tv" />
<jsp:setProperty property="*" name="tv"/>

<h2><jsp:getProperty property="model" name="tv"/></h2>
<h2><jsp:getProperty property="brand" name="tv"/></h2>
<h2><jsp:getProperty property="color" name="tv"/></h2>

