<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<h1>/0401/empUpdate</h1>
<jsp:useBean class="web.test.bean.EmpDTO" id="empDTO"/>
<jsp:setProperty property="*" name="empDTO"/>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "scott";
	String password = "tiger";

	Connection conn = DriverManager.getConnection(url, user, password);

	String sql = "update emp set job=?, sal=?, comm=? where empno=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, empDTO.getJob());
	pstmt.setInt(2, empDTO.getSal());
	pstmt.setInt(3, empDTO.getComm());
	pstmt.setInt(4, empDTO.getEmpno());

	int rows = pstmt.executeUpdate();
	out.println("<h3>"+rows+"개의 행이 수정되었습니다.</h3>");

	conn.close();
	pstmt.close();
%>
