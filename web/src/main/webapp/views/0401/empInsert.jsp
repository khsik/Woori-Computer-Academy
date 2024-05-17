<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<h1>0401/empInsert.jsp</h1>

<jsp:useBean class="web.test.bean.EmpDTO" id="empDTO"/>
<jsp:setProperty name="empDTO" property="*"/>

<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "scott";
	String password = "tiger";

	Connection conn = DriverManager.getConnection(url, user, password);

// sql 문장의 ? 들어간 위치만 1부터 시작하는 인덱스로 생각하고, 메서드로 삽입 
	String sql = "insert into emp values(?,?,?,?,sysdate,?,?,?)";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, empDTO.getEmpno());
	pstmt.setString(2, empDTO.getEname());
	pstmt.setString(3, empDTO.getJob());
	pstmt.setInt(4, empDTO.getMgr());
	pstmt.setInt(5, empDTO.getSal());
	pstmt.setInt(6, empDTO.getComm());
	pstmt.setInt(7, empDTO.getDeptno());
	int result = pstmt.executeUpdate();

	conn.close();
	pstmt.close();
%>
<h2><%=result %> 행이 추가되었습니다.</h2>
