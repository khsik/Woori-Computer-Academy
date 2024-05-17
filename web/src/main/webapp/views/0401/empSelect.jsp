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
		<h2>�����ȣ : <%=empno %></h2>
		<h2>����̸� : <%=ename %></h2>
		<h2>������� : <%=job %></h2>
		<h2>������ : <%=mgr %></h2>
		<h2>��볯¥ : <%=hiredate %></h2>
		<h2>����޿� : <%=sal %></h2>
		<h2>���ʽ� : <%=comm %></h2>
		<h2>�μ���ȣ : <%=deptno %></h2>
<%	}else{
		out.println("<h2>�����ȣ�� Ȯ�����ּ���.</h2>");
	}

	conn.close();
	pstmt.close();
	rs.close();
%>
