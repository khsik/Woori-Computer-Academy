<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>0320/ex05.jsp</h1>
<span style="font-size:18px; font-weight:bold; display:inline-block; margin-bottom:5px;">
	페이지 이동</span>
<br>
<a href="http://127.0.0.1:8080/web/views/0320/ex01.jsp">ex01</a> <br>
<a href="/web/views/0320/ex02.jsp">ex02</a> <br>
<a href="./ex03.jsp">ex03</a> <br>
<a href="ex04.jsp">ex04</a> &nbsp;&nbsp;&nbsp;
<a href="ex04.jsp" target="_blank">ex04(새창에서 열기)</a> <br>
<br>

<form>
	<input type="button" value="이동" onclick="location='./ex01.jsp'">
</form>

<hr color="blue">
<form action="./ex01.jsp">
	<input type="submit" value="로그인">
</form>

<hr color="red">

<a href="/web/views/0320/ex06.jsp">
	<img src="/web/views/images/cs01.jpg" width="300px">
</a>