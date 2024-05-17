<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>pro3</h1>
<% request.setCharacterEncoding("UTF-8");%>

<jsp:useBean class="java.util.Date" id="date"></jsp:useBean>
<jsp:useBean id="cal" class="web.test.jsp.Calc"/>
<jsp:setProperty name="cal" property="*"/>

<h1>
날짜
<jsp:getProperty name="date" property="year"/>년
<jsp:getProperty name="date" property="month"/>월
<jsp:getProperty name="date" property="date"/>일
<jsp:getProperty name="date" property="hours"/>시
<jsp:getProperty name="date" property="minutes"/>분
<jsp:getProperty name="date" property="seconds"/>초
</h1>

<h1>
계산 : 
<jsp:getProperty name="cal" property="num1"/>
<jsp:getProperty name="cal" property="oper"/>
<jsp:getProperty name="cal" property="num2"/>
=
<jsp:getProperty name="cal" property="result"/>
</h1>