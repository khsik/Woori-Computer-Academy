<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	div {margin:0 auto; width:max-content;}
	table {width:300px;}
	th {width:50px;}
	h1 {text-align:center; line-height:1.2;}
	#rbtn {text-align:right;}
</style>

<div>
<h1>/board03/writeForm</h1>

<form action="writePro.jsp" method="post" enctype="multipart/form-data">
<table>
	<tr><th>title</th><td><input type="text" name="title"></td></tr>
	<tr><th>img</th><td><input type="file" name="img"></td></tr>
	<tr><td colspan="2" id="rbtn"><input type="submit" value="등록">
	<button type="button" onclick="window.location='list.jsp'">글목록</button></td></tr>
</table>
</form>
</div>