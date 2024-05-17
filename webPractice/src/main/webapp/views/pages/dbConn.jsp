<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%-- request.setCharacterEncoding("UTF-8"); --%>
<meta charset="UTF-8">
<title>emp table</title>
</head>
<body>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "scott";
	String password = "tiger";
	
	Connection conn = DriverManager.getConnection(url, user, password);
	
	String sql = "select * from emp order by deptno, empno";
	PreparedStatement pstmt = conn.prepareStatement(sql);

	ResultSet rs = pstmt.executeQuery();
	while(rs.next()){  
		int empno = rs.getInt(1);
		String ename = rs.getString(2);
		String job = rs.getString(3);
		int mgr = rs.getInt(4);
		Timestamp hiredate = rs.getTimestamp(5);
		int sal = rs.getInt(6);
		int comm = rs.getInt(7);
		int deptno = rs.getInt(8);
		
		String hiredateS = new SimpleDateFormat("yyyy/mm/dd").format(hiredate);

		out.println("<p>부서번호: "+deptno+", 사원번호: "+empno+", 이름: "+ename+", 직무: "+job+", 상사번호:"+mgr+", 고용날짜: "+hiredateS+", 급여: "+sal+", 보너스: "+comm+"</p>");
	}

	conn.close();
	pstmt.close();
	rs.close();
%>
</body>
</html>