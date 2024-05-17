<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>/test/jstl02.jsp</h1>
<button type="button" onclick="window.location='./main.do'">main</button>

<h3> 숫자 => formatNumber</h3>
money : <fmt:formatNumber value="${money}" type="currency" currencySymbol="\\"/>
<hr color="lightcoral">
pi : <fmt:formatNumber value="${pi}" type="percent" /> <br>
pi : <fmt:formatNumber value="${pi}" pattern=".0000" /> <br>
pi : <fmt:formatNumber value="${pi}" pattern=".0"/> <br>
pi : <fmt:formatNumber value="${pi}" pattern="##0.000000"/> <br>
pi : <fmt:formatNumber value="${pi}" pattern="000.00000"/>
<%--
0 : 빈자리면 0 출력
# : 빈자리면 출력안함
마지막 자리 반올림해서 나오는 것으로 보임.
--%>
<hr color="teal">

<h3>숫자 => 포맷Date</h3>
day1 : <fmt:formatDate value="${day}" /> <br>
day2 : <fmt:formatDate value="${day}" type="date"/> <br>
day3 : <fmt:formatDate value="${day}" type="both"/> <br>
day4 : <fmt:formatDate value="${day }" type="time" /> <br>
day5 : <fmt:formatDate value="${day }" type="time" timeStyle="full"/> <br>
day6 : <fmt:formatDate value="${day }" type="date" dateStyle="full"/> <br>
day7 : <fmt:formatDate value="${day }" type="date" dateStyle="long"/> <br>
day8 : <fmt:formatDate value="${day }" type="date" dateStyle="medium" /> <br>
day9 : <fmt:formatDate value="${day }" type="date" dateStyle="short" /> <br>
day10 : <fmt:formatDate value="${day }" type="date" dateStyle="default" /> <br>

<hr size="7px" style="border:0; background: linear-gradient(0.25turn, red, orange, yellow, green, blue, navy, purple);">
<hr size="4px" style="border:0; background: linear-gradient(90deg, red, orange, yellow, green, blue, navy, purple);">
