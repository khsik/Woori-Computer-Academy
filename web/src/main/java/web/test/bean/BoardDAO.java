package web.test.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDAO extends DBConnection{
	// 사용 객체, 변수 미리 선언
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;

	// 글 작성
	public int insert(BoardDTO dto) {
		int result = 0;
		try{
			conn = getConn();
//			sql = "insert into board01(num, writer, title, content, reg) values(1, 'java', 'tttt', 'cccc', sysdate)"
			sql = "insert into board01 values(board01_seq.nextval, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			result = pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, rs);
		}
		return result;
	}

	// 글 개수 (글 목록 페이지)
	public int count() {
		int result = 0;
		try {
			conn = getConn();
			sql = "select count(*) from board01";
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
	public ArrayList<BoardDTO> list(int start, int end){
		ArrayList<BoardDTO> list = new ArrayList<>();
		try {
			conn = getConn();
			sql = "select * from (select b.*, rownum as r from (select * from board01 order by num desc) b) where r between ? and ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNum(rs.getInt("num"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
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

	// 글 내용
	public BoardDTO content(int num) {
		BoardDTO dto = new BoardDTO();
		try {
			conn = getConn();
			sql = "select * from board01 where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setNum(rs.getInt("num"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setReg(rs.getTimestamp("reg"));
				dto.setContent(rs.getString("content"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, rs);
		}
		return dto;
	}
	
	// 글 수정 Form
	public BoardDTO updateForm(int num) {
		BoardDTO dto = new BoardDTO();
		try {
			conn = getConn();
			sql = "select * from board01 where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return dto;
	}
	
	// 글 수정 Pro
	public int updatePro(BoardDTO dto) {
		int result=0;
		try {
			conn = getConn();
			sql = " update board01 set writer=?, title=?, content=? where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getNum());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}

	// 글 삭제
	public int delete(int num) {
		int result=0;
		try {
			conn = getConn();
			sql = "delete from board01 where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
}
