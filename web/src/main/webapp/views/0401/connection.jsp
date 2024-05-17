<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<h1>0401/connection</h1>
<%
// 1. 임포트
// 2. JDBC 드라이버 로딩
Class.forName("oracle.jdbc.driver.OracleDriver");
String url = "jdbc:oracle:thin:@localhost:1521:orcl";
String user = "scott";
String password = "tiger";

// 3. Connection 객체 생성
Connection conn = DriverManager.getConnection(url, user, password);

// 4. 쿼리문 작성
String sql = "select * from emp";
PreparedStatement pstmt = conn.prepareStatement(sql);

/* 5. 쿼리문 실행
pstmt.executeQuery(); : select
						결과 있음 return 타입 ResultSet
pstmt.executeUpdate(); : insert, update, delete
						return 타입 int  (변환된 레코드 건수 (~행 삽입, 삭제...))
이때 결과는 레코드 한줄씩
*/
ResultSet rs = pstmt.executeQuery();
while(rs.next()){ // 레코드(가로한줄) 있으면 true, 없으면 false 
	int empno = rs.getInt("empno");
	String ename = rs.getString("ename");
	Timestamp hiredate = rs.getTimestamp("hiredate");
	out.println("<h2>"+empno+" "+ename+" "+hiredate+"</h2>");
}

// 6. 연결 끊기 - 연결해서 이루어지는 경우 반드시 연결 끊어줘야 한다.
conn.close();
pstmt.close();
rs.close();
%>
