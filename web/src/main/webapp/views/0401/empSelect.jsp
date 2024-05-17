<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<h1>0401/empSelect</h1>

<jsp:useBean class="web.test.bean.EmpDTO" id="empDTO"/>
<jsp:setProperty name="empDTO" property="empno" />

<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "scott";
	String password = "tiger";

	Connection conn = DriverManager.getConnection(url, user, password);

	String sql = "select * from emp where empno=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, request.getParameter("empno"));

	ResultSet rs = pstmt.executeQuery();

	if(rs.next()){
		int empno = rs.getInt("empno");
		String ename = rs.getString("ename");
		String job = rs.getString("job");
		int mgr = rs.getInt("mgr");
		Timestamp hiredate = rs.getTimestamp("hiredate");
		int sal = rs.getInt("sal");
		int comm = rs.getInt("comm");
		int deptno = rs.getInt("deptno");
%>
		<h2>사원번호 : <%=empno %></h2>
		<h2>사원이름 : <%=ename %></h2>
		<h2>사원직무 : <%=job %></h2>
		<h2>사원상사 : <%=mgr %></h2>
		<h2>고용날짜 : <%=hiredate %></h2>
		<h2>사원급여 : <%=sal %></h2>
		<h2>보너스 : <%=comm %></h2>
		<h2>부서번호 : <%=deptno %></h2>
<%	}else{
		out.println("<h2>사원번호를 확인해주세요.</h2>");
	}

	conn.close();
	pstmt.close();
	rs.close();
%>
