package webP.userpage.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/*
	댓글 위치 잡기
	level 0인 그냥 댓글 -> max(rloc) + 1
	level 0 아닌 대댓글 종류 -> max(rloc) group by rgroup
		구하고 이때의 max(rloc)보다 큰 rloc들 다 +1, 작성한 대댓글은 max(rloc)+1 부여
 */
public class ReplyDAO extends OracleConnection{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = null;
	
	// 댓글 작성
	public int insertReply(ReplyDTO dto) {
		int result = 0;
		try {
			conn = getConn();
			sql = "insert into userreply(bnum, rnum, rloc, lev, writer, content)"
					+ " values(?, userreply_seq.nextval, (select nvl(max(rloc)+1,1) from userreply where bnum=?), 0, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getBnum());
			pstmt.setInt(2, dto.getBnum());
			pstmt.setString(3, dto.getWriter());
			pstmt.setString(4, dto.getContent());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
	// 댓글 수정
	public int updateReply() {
		int result = 0;
		try {
			conn = getConn();
			sql = "";
			pstmt = conn.prepareStatement(sql);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}	
	
	// 댓글 삭제
	public int deleteReply() {
		int result = 0;
		try {
			conn = getConn();
			sql = "";
			pstmt = conn.prepareStatement(sql);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}		

	// 댓글 개수 카운트
	public int countReply(int bnum) {
		int result = 0;
		try {
			conn = getConn();
			sql = "select count(*) from userreply where bnum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bnum);
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
	
	// 댓글 출력용. 페이징 처리 안했음.
	public ArrayList<ReplyDTO> getReplys(int bnum) {
		ArrayList<ReplyDTO> arr = new ArrayList<>();
		try {
			conn = getConn();
			sql = "select * from userreply where bnum=? order by rloc asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bnum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReplyDTO dto = new ReplyDTO();
				dto.setWriter(rs.getString("writer"));
				dto.setContent(rs.getString("content"));
				dto.setReg(rs.getTimestamp("reg"));
				arr.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return arr;
	}		
	
}
