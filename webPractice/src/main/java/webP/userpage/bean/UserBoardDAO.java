package webP.userpage.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserBoardDAO extends OracleConnection {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = null;
	
	// 게시글 등록
	public int postUpload(UserBoardDTO dto) {
		int result = 0;
		try {
			conn = getConn();
			sql = "insert into userboard values(userboard_seq.nextval, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
	// 게시글 확인
	public UserBoardDTO getPostContent(int bnum) {
		UserBoardDTO dto = new UserBoardDTO();
		try {
			conn = getConn();
			sql = "select * from userboard where bnum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bnum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setBnum(rs.getInt("bnum"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setReg(rs.getTimestamp("reg"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return dto;
	}
	
	// 수정 전 작성자 확인
	public boolean checkUpdate(int bnum, String sid) {
		boolean result = false;
		try {
			conn = getConn();
			sql = "select * from userboard where bnum=? and writer=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bnum);
			pstmt.setString(2, sid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
	// 게시글 수정
	public int postUpdate(UserBoardDTO dto) {
		int result = 0;
		try {
			conn = getConn();
			sql = "update userboard set title=?, content=? where bnum=? and writer=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getBnum());
			pstmt.setString(4, dto.getWriter());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
	// 게시글 삭제
	public int delete(int bnum, String sid) {
		int result = 0;
		try {
			conn = getConn();
			sql = "delete from userboard where bnum=? and writer=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bnum);
			pstmt.setString(2, sid);
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
	// 총 게시글 개수
	public int count() {
		int count = 0;
		try {
			conn = getConn();
			sql = "select count(*) from userboard";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return count;
	}
	
	// 게시글 목록(한 페이지에 n개 출력)
	public ArrayList<UserBoardDTO> postList(int start, int end) {
		ArrayList<UserBoardDTO> postList = new ArrayList<>();
		try {
			conn = getConn();
			sql = "select * from (select rownum as r, b.* from "
					+ "(select bnum, writer, title, reg from userboard order by bnum desc) b)"
					+ " where r between ? and ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserBoardDTO dto = new UserBoardDTO();
				dto.setBnum(rs.getInt(2));
				dto.setWriter(rs.getString(3));
				dto.setTitle(rs.getString(4));
				dto.setReg(rs.getTimestamp(5));
				postList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return postList;
	}
	
}
