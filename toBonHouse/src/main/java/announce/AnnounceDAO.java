package announce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnnounceDAO {
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
	
	// 글쓰기 페이지	// ann_Write 에서 사용중
	// TODO String sid 값으로 id의 값을 받아야 함. 하지만 로그인 페이지가 없어서 일단 패스
	public int annWrite(AnnounceDTO dto) {
		int result = 0; 
		try {
			conn = getConn();
			sql = "insert into house_announce (num, title, ann_Content, ann_Img, ann_Pw, category, ann_Reg, mem_num, id) values (house_announce_seq.nextval,?,?,?,?,?,sysdate,?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getAnn_Content());
			pstmt.setString(3, dto.getAnn_Img());
			pstmt.setString(4, dto.getAnn_Pw());
			pstmt.setString(5, dto.getCategory());
			pstmt.setInt(6, dto.getMem_num());
			pstmt.setString(7, dto.getId());
			/*if (dto.getCategory().equals("event")) {
				pstmt.setString(1, "se.val");
			}else if (dto.getCategory().equals("announce")) {
				
			}else if (dto.getCategory().equals("event")) {
				
			}*/
			// pstmt.setString(5, sid);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	// 글 쓴거 리스트화 시켜서 출력하는 페이지 // annList.jsp 사용중
	// num 말고 rownum 으로 글번호를 쓰고 싶음.
	public ArrayList<AnnounceDTO> annList(int startRow, int endRow) {
		ArrayList<AnnounceDTO> list = new ArrayList<AnnounceDTO>();
		
		try {
			conn = getConn();
			sql = "select * from(select rownum r, b.* from(select * from house_announce where category != 'QNA' order by num desc) b) where r >= ? and r <= ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				AnnounceDTO dto = new AnnounceDTO();
				dto.setNum(rs.getInt("Num"));
				dto.setTitle(rs.getString("title"));
				dto.setAnn_Content(rs.getString("ann_Content"));
				dto.setAnn_Img(rs.getString("ann_Img"));
				dto.setCategory(rs.getString("category"));
				dto.setAnn_Reg(rs.getTimestamp("ann_reg"));
				dto.setMem_num(rs.getInt("mem_num"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	// 글 갯수 세는 메서드 //annList.jsp 사용중
	public int count() {
		int result = 0;
		
		try {
			conn = getConn();
			sql = "select count(*) from house_announce where category != 'QNA'";
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
	
	// 컨텐츠 보여주는 메서드	// annContent.jsp 에서 사용중
	public AnnounceDTO contentList(int num) {
		AnnounceDTO dto = new AnnounceDTO();
		try {
			conn = getConn();
			sql  = "select * from house_announce where num = ?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setTitle(rs.getString("title"));
				dto.setAnn_Content(rs.getString("ann_Content"));
				dto.setAnn_Img(rs.getString("ann_Img"));
				dto.setCategory(rs.getString("category"));
				dto.setAnn_Reg(rs.getTimestamp("ann_Reg"));
				dto.setMem_num(rs.getInt("mem_num"));	
				dto.setId(rs.getString("id"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return dto;
	}
	
	// 이벤트리스트.		eventList.jsp 에서 사용중. 
	public ArrayList<AnnounceDTO> eventList(int startRow, int endRow) {
		ArrayList<AnnounceDTO> list = new ArrayList<AnnounceDTO>();
		
		try {
			conn = getConn();
			//sql = "select * from (select b.*, rownum r from (select * from house_announce where category = 'event' order by num desc)b order by r desc)where r >= ? and r <= ?";
			sql = "select * from(select rownum r, b.* from(select * from house_announce where category = 'event' order by num desc) b) where r >= ? and r <= ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				AnnounceDTO dto = new AnnounceDTO();
				dto.setNum(rs.getInt("Num"));
				dto.setTitle(rs.getString("title"));
				dto.setAnn_Content(rs.getString("ann_Content"));
				dto.setCategory(rs.getString("category"));
				dto.setAnn_Reg(rs.getTimestamp("ann_reg"));
				dto.setMem_num(rs.getInt("mem_num"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	// 이벤트 글만 세는 메서드  // eventList.jsp 에서 사용
	public int eventCount() {
		int result = 0;
		
		try {
			conn = getConn();
			sql = "select count(*) from house_announce where category = 'event'";
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
	
	// 글 수정
	public int update(AnnounceDTO dto) {
		int result = 0;
		
		try {
			conn = getConn();
			sql = "update house_announce set title = ?, ann_Img = ?, ann_Content = ? where num = ?  ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getAnn_Img());
			pstmt.setString(3, dto.getAnn_Content());
			pstmt.setInt(4, dto.getNum());
			
			result = pstmt.executeUpdate();

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	// 글 삭제 글 삭제 뿐이 아니라, 이미지의 이름까지 받아서 이미지 삭제 할 예정.
	public String delete(int num) {
		String img = "";
		
		try {
			conn = getConn();
			sql = "select * from house_announce where num = ?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				img = rs.getString("ann_Img");
			}
			
			sql = "delete from house_announce where num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			// 나중엔 비밀번호도 받아야 하나 ?
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		
		return img;
	}
	
	// QNA 글 쓰는 메서드	// 생각해보니까 어차피 글쓰는 방식은 같기에 필요 없음. 삭제해도 무방함.
	public int qnaWrite(AnnounceDTO dto) {
		int result = 0;
		//타이틀 컨텐츠 이미지 비밀번호 카테고리 넘
		try {
			conn = getConn();
			sql = "insert into house_announce values(house_announce_seq.nextval, ?, ?, ?, ?,?,sysdate,?,?)";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getAnn_Content());
			pstmt.setString(3, dto.getAnn_Img());
			pstmt.setString(4, dto.getAnn_Pw());
			pstmt.setString(5, dto.getCategory());
			pstmt.setInt(6, dto.getMem_num());
			pstmt.setString(7, dto.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		
		
		
		return result;
	}
	
	// QNA 의 글 갯수를 세는 메서드
	public int qnaCount() {

		int result = 0;
		
		try {
			conn = getConn();
			sql= "select count(*) from house_announce where category = 'QNA'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// QNA 리스트 메서드
	public ArrayList<AnnounceDTO> qnaList(int startRow, int endRow) {
		ArrayList<AnnounceDTO> list = new ArrayList<AnnounceDTO>();
		
		try {
			conn = getConn();
			//sql = "select * from(select rownum r, b.* from(select * from house_announce where category = 'QNA' order by num) b) where r >=? and r <= ? order by r desc";
			sql = "select * from(select rownum r, b.* from(select * from house_announce where category = 'QNA' order by num desc) b) where r >=? and r <= ?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AnnounceDTO dto = new AnnounceDTO();
				dto.setNum(rs.getInt("Num"));			// 글번호
				dto.setTitle(rs.getString("title"));	// 타이틀
				dto.setId(rs.getString("id"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		

		return list;
	}
	
	
	
	
	
	
	
	
}

