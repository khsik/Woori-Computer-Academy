<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<h1>/0401/empUpdateForm</h1>

<form action="empUpdate.jsp" method="post">
	사원번호 : 	<input type="text" name="empno"> <br>
	업무 : 		<input type="text" name="job"> <br>
	급여 : 		<input type="text" name="sal"> <br>
	보너스 : 		<input type="text" name="comm"> <br>
				<input type="submit" value="정보변경">
</form>