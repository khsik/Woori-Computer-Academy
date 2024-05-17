package web.bean.board03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Board03DAO {
	private Board03DAO() {}
	private static Board03DAO instance = new Board03DAO();
	public static Board03DAO getInstance() {return instance;}
	
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;
	
	// 연결
	private Connection getConn() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pw = "tiger";
		Connection conn = DriverManager.getConnection(url, id, pw);
		return conn;
	}

	// 연결 끊기
	private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {if(conn != null) {conn.close();}} catch (SQLException e) {}
		try {if(pstmt != null) {pstmt.close();}} catch (SQLException e) {}
		try {if(rs != null) {rs.close();}} catch (SQLException e) {}
	}
	
	// 글 작성
	public int imgInsert(String title, String img) {
		int result = 0;
		try {
			conn = getConn();
			sql = "insert into board03 values(board03_seq.nextval,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,title);
			pstmt.setString(2,img);
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
	// 글 내용
	public Board03DTO readContent(int num) {
		Board03DTO dto = new Board03DTO();
		try {
			conn = getConn();
			sql = "select * from board03 where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setNum(rs.getInt("num"));
				dto.setTitle(rs.getString("title"));
				dto.setImg(rs.getString("img"));
				dto.setReg(rs.getTimestamp("reg"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(conn, pstmt, rs);
		}
		return dto;
	}
	
	// 전체 글 개수
	public int imgCount() {
		int result = 0;
		try {
			conn = getConn();
			sql = "select count(*) from board03";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
	// 글 목록
	public ArrayList<Board03DTO> imgList(int start, int end){
		ArrayList<Board03DTO> list = new ArrayList<>();
		try {
			conn = getConn();
			sql = "select * from (select b.*, rownum as r from (select * from board03 order by num desc) b) where r between ? and ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board03DTO dto = new Board03DTO();
				dto.setNum(rs.getInt("num"));
				dto.setTitle(rs.getString("title"));
				dto.setImg(rs.getString("img"));
				dto.setReg(rs.getTimestamp("reg"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	
	// 글 삭제
	public String[] deleteContent(int num) {
		String[] result = {"0", null};
		try {
			conn = getConn();
			sql = "select img from board03 where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) { // 이미지 있다면 서버에서 실제 파일 삭제
				result[1] = rs.getString(1);
			}
			
			sql = "delete from board03 where num=?"; // DB에서 글 삭제
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			result[0] = ""+pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
	// 삭제 2
	public String delete(int num) {
		String img = null;
		try {
			conn = getConn();
			
			sql = "select img from board03 where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) { // 이미지 있다면 파일 이름 받아오기
				img = rs.getString("img");
			}
			
			sql = "delete from board03 where num=?"; // DB에서 글 삭제
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return img;
	}
	
	// 글 수정
	public int updateContent(String num,String title,String img) {
		int result = 0;
		try {
			conn = getConn();
			sql = "update board03 set title=?, img=? where num=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, img);
			pstmt.setInt(3, Integer.parseInt(num));
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
	// 수정 2
	public int update2(Board03DTO dto) {
		int result = 0;
		try {
			conn = getConn();
			sql = "update board03 set title=?, img=? where num=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getImg());
			pstmt.setInt(3, dto.getNum());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
}
