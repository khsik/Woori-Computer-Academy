<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<h1>0401/empForm</h1>

<form action="empInsert.jsp" method="post">
	�����ȣ : <input type="text" name="empno"><br>
	����̸� : <input type="text" name="ename"><br>
	������� : <input type="text" name="job"><br> 
	������ : <input type="text" name="mgr"><br>
	<%-- �Ի糯¥ : <input type="text" name="hiredate"><br> --%>
	����޿� : <input type="text" name="sal"><br>
	���ʽ� : <input type="text" name="comm"><br>
	�μ���ȣ : <input type="text" name="deptno"><br>
	<input type="submit" value="������">
</form>