<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<h1>0401/connection</h1>
<%
// 1. ����Ʈ
// 2. JDBC ����̹� �ε�
Class.forName("oracle.jdbc.driver.OracleDriver");
String url = "jdbc:oracle:thin:@localhost:1521:orcl";
String user = "scott";
String password = "tiger";

// 3. Connection ��ü ����
Connection conn = DriverManager.getConnection(url, user, password);

// 4. ������ �ۼ�
String sql = "select * from emp";
PreparedStatement pstmt = conn.prepareStatement(sql);

/* 5. ������ ����
pstmt.executeQuery(); : select
						��� ���� return Ÿ�� ResultSet
pstmt.executeUpdate(); : insert, update, delete
						return Ÿ�� int  (��ȯ�� ���ڵ� �Ǽ� (~�� ����, ����...))
�̶� ����� ���ڵ� ���پ�
*/
ResultSet rs = pstmt.executeQuery();
while(rs.next()){ // ���ڵ�(��������) ������ true, ������ false 
	int empno = rs.getInt("empno");
	String ename = rs.getString("ename");
	Timestamp hiredate = rs.getTimestamp("hiredate");
	out.println("<h2>"+empno+" "+ename+" "+hiredate+"</h2>");
}

// 6. ���� ���� - �����ؼ� �̷������ ��� �ݵ�� ���� ������� �Ѵ�.
conn.close();
pstmt.close();
rs.close();
%>
