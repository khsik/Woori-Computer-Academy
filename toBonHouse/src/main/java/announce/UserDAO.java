package announce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class UserDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql ="";
	
	// 연결하기
	public Connection getConn() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.0.138:1521:orcl";
		String user = "project1";
		String pass = "tiger";
		conn = DriverManager.getConnection(url, user, pass);
		return conn;
	}
	
	// 연결끊기
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {if(conn != null) {conn.close();}} catch (SQLException e) {e.printStackTrace();}
		try {if(pstmt != null) {pstmt.close();}} catch(SQLException e) {e.printStackTrace();}
		try {if(rs != null) {rs.close();}} catch(SQLException e) {e.printStackTrace();}
		}
		
	// 유저 Select 
	public ArrayList<UserDTO> userInfo() {
		ArrayList<UserDTO> list = new ArrayList<UserDTO>();
		try {
			conn = getConn();
			sql = "select * from house_member where grade > 0 order by mem_num asc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserDTO dto = new UserDTO();
				dto.setMem_num(rs.getInt("mem_num"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setTel_com(rs.getString("tel_com"));
				dto.setTel(rs.getString("tel"));
				dto.setEmail(rs.getString("email"));
				dto.setAddress(rs.getString("address"));
				dto.setGrade(rs.getInt("grade"));
				dto.setReg(rs.getTimestamp("reg"));
				dto.setBalance(rs.getInt("balance"));
				dto.setPoint(rs.getInt("point"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	
	// 상세보기
	public UserDTO moreInfo(int mem_num) {
		UserDTO dto = new UserDTO();
		
		try {
			conn = getConn();
			sql = "select * from house_member where mem_num = ? and grade > 0 ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setMem_num(rs.getInt("mem_num"));
				dto.setId(rs.getString("id"));
				//dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setTel_com(rs.getString("tel_com"));
				dto.setTel(rs.getString("tel"));
				dto.setEmail(rs.getString("email"));
				dto.setAddress(rs.getString("address"));
				dto.setGrade(rs.getInt("grade"));
				dto.setReg(rs.getTimestamp("reg"));
				dto.setBalance(rs.getInt("balance"));
				dto.setPoint(rs.getInt("point"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		
		return dto;
	}
	
	
	// 검색하는 메서드
		public ArrayList<UserDTO> search(String search1, String search2) {
			ArrayList<UserDTO> list = new ArrayList<UserDTO>();
			
			try {
				conn = getConn();
				if (search1.equals("all")) {
					sql = "select * from house_member where grade > 0 order by mem_num asc";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
				}else if (search1.equals("num") ) {
					sql = "select * from house_member where mem_num = ? and grade > 0 order by mem_num asc ";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, Integer.parseInt(search2));
					rs = pstmt.executeQuery();
					
				}else if (search1.equals("id")) {
					sql = "select * from house_member where id like ? and grade > 0 order by mem_num asc";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%"+search2 + "%");
					rs = pstmt.executeQuery();
					
				}else if (search1.equals("name")){
					sql = "select * from house_member where name like ? and grade > 0 order by mem_num asc ";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, Integer.parseInt(search2));
					rs = pstmt.executeQuery();
					
				} else if (search1.equals("grade")) {
					sql = "select * from house_member where grade = ? and grade > 0 order by mem_num asc ";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%"+search2 + "%");
					rs = pstmt.executeQuery();
					
				}else {
					sql = "select * from house_member order by mem_num asc";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
				}
				while (rs.next()) {
					UserDTO dto = new UserDTO();
					dto.setMem_num(rs.getInt("mem_num"));
					dto.setId(rs.getString("id"));
					dto.setName(rs.getString("name"));
					dto.setGrade(rs.getInt("grade"));
					list.add(dto);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(conn, pstmt, rs);
			}
			
			return list;
		}
	
		// 회원등급 업데이트
		public int updateGrade(int mem_num, int grade) {
			int result = 0;
			try {
				conn = getConn();
				sql = "update house_member set grade=? where mem_num = ? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, grade);
				pstmt.setInt(2, mem_num);
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(conn, pstmt, rs);
			}
			return result;
		}
		
		// 탈퇴 회원 검색
		public ArrayList<UserDTO> retireSerch() {
			ArrayList<UserDTO> list = new ArrayList<UserDTO>();
			
			try {
				conn = getConn();
				sql = "select * from house_resign where resign_day + 30 < sysdate";		// 30일 지난 사람 검색
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					UserDTO dto = new UserDTO();
					dto.setMem_num(rs.getInt("mem_num"));
					dto.setResign_day(rs.getTimestamp("resign_day"));
					list.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(conn, pstmt, rs);
			}
			return list;
		}
		
		// 탈퇴 처리
		public int retire(int mem_num) {
			int result= 0;
			
			try {
				conn = getConn();
				sql = "delete from house_resign where mem_num = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, mem_num);
				pstmt.executeUpdate();
				
				sql = "update house_member set grade = -2  where mem_num = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, mem_num);
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(conn, pstmt, rs);
			}
			
			
			return result;
		}
		
}
