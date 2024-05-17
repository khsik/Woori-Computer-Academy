<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<h1>0401/empForm</h1>

<form action="empInsert.jsp" method="post">
	사원번호 : <input type="text" name="empno"><br>
	사원이름 : <input type="text" name="ename"><br>
	사원업무 : <input type="text" name="job"><br> 
	사원상사 : <input type="text" name="mgr"><br>
	<%-- 입사날짜 : <input type="text" name="hiredate"><br> --%>
	사원급여 : <input type="text" name="sal"><br>
	보너스 : <input type="text" name="comm"><br>
	부서번호 : <input type="text" name="deptno"><br>
	<input type="submit" value="사원등록">
</form>