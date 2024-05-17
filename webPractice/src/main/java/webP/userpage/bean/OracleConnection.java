package webP.userpage.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleConnection {

	public static Connection getConn() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

	public static void close(Connection conn
							, PreparedStatement pstmt, ResultSet rs) {
		if(conn != null) {
			try {conn.close();}
			catch(SQLException e) {}
		}
		if(pstmt != null) {
			try {pstmt.close();}
			catch(SQLException e) {}
		}
		if(rs != null) { try {rs.close();} catch(SQLException e) {} }
	}
	
}
