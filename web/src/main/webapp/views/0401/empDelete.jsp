<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<h1>/0401/empDelete</h1>

<jsp:useBean class="web.test.bean.EmpDTO" id="dto"/>
<jsp:setProperty name="dto" property="empno"/>

<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "scott";
	String password = "tiger";

	Connection conn = DriverManager.getConnection(url, user, password);

	String sql = "delete from emp where empno=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, dto.getEmpno());

	int result = pstmt.executeUpdate();

	conn.close();
	pstmt.close();
%>
<h2><%=result %>행 삭제되었습니다.</h2>
