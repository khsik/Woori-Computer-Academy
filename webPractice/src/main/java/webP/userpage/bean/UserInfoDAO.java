package webP.userpage.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserInfoDAO extends OracleConnection {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = null;

	// id 중복 확인
	public boolean idCheck(String id) {
		boolean result = false;
		try {
			conn = getConn();
			sql="select id from userinfo where id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(!rs.next()) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
	// 회원가입. 가입성공 true 리턴
	public boolean newUserInsert(UserInfoDTO dto) {
		boolean result=false;
		try {
			conn = getConn();
			sql="insert into userinfo values(?,?,?,?,?,?,sysdate)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPhoneC());
			pstmt.setString(6, dto.getPhoneNum());
			int row = pstmt.executeUpdate();
			if(row == 1) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
	// 로그인
	public boolean login(String id, String pw) {
		boolean result = false;
		try{
			conn = getConn();
			sql = "select * from userinfo where id=? and pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	// 회원 정보 확인
	public UserInfoDTO viewInfo(String sid) {
		UserInfoDTO dto = new UserInfoDTO();
		try {
			conn = getConn();
			sql = "select * from userinfo where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setId(sid);
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhoneC(rs.getString("phonec"));
				dto.setPhoneNum(rs.getString("phonenum"));
			}else {
				dto = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return dto;
	}
	
	// 회원 정보 수정 TODO 조인으로 다른 table에서 writer 같이 수정
	public int changeInfo(UserInfoDTO dto) {
		int result = 0;
		try {
			conn = getConn();
			sql = "update userinfo set pw=?, email=?, phonec=?, phonenum=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getPhoneC());
			pstmt.setString(4, dto.getPhoneNum());
			pstmt.setString(5, dto.getId());
			result = pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
}
