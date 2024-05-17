package business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BusinessDAO {
	// 싱글톤
	private BusinessDAO() {};
	private static BusinessDAO instance = new BusinessDAO();
	public static BusinessDAO getInstance() {return instance;}

	// 메서드에서 자주 사용할 변수 미리 선언
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;

	// DB 연결
	public Connection getConn() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.0.138:1521:orcl";
		String id = "project1";
		String pw = "tiger";
//		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//		String id = "scott";
		Connection conn = DriverManager.getConnection(url, id, pw);
		return conn;
	}

	// 연결 끊기
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {if(conn != null) {conn.close();}} catch (SQLException e) {}
		try {if(pstmt != null) {pstmt.close();}} catch (SQLException e) {}
		try {if(rs != null) {rs.close();}} catch (SQLException e) {}
	}
	
	// 상품 추가
	public int insert(BusinessDTO dto) {
		int result = 0;
		try{
			Connection conn = getConn();
			sql = "insert into house_products values(house_products_seq.nextval, ?, sysdate, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getMem_num());
			pstmt.setString(2, dto.getpName());
			pstmt.setString(3, dto.getCook());
			pstmt.setString(4, dto.getThum1());
			pstmt.setString(5, dto.getThum2());
			pstmt.setInt(6, dto.getPrice());
			pstmt.setInt(7, dto.getStock());
			pstmt.setString(8, dto.getDetail());
			pstmt.setString(9, dto.getCompany());
			pstmt.setString(10, dto.getCountry());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
	// 상품 정보 출력
	public BusinessDTO getInfo(int mem_num, int pnum) {
		BusinessDTO dto = new BusinessDTO();
		try {
			conn = getConn();
			sql = "select * from house_products where pnum=? and mem_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pnum);
			pstmt.setInt(2, mem_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setPnum(rs.getInt("pnum"));
				dto.setMem_num(rs.getInt("mem_num"));
				dto.setReg(rs.getTimestamp("reg"));
				dto.setpName(rs.getString("pname"));
				dto.setCook(rs.getString("cook"));
				dto.setThum1(rs.getString("thum1"));
				dto.setThum2(rs.getString("thum2"));
				dto.setPrice(rs.getInt("price"));
				dto.setStock(rs.getInt("stock"));
				dto.setDetail(rs.getString("detail"));
				dto.setCompany(rs.getString("company"));
				dto.setCountry(rs.getString("country"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return dto;
	}

	// 수정
	public int update(BusinessDTO dto) {
		int result = 0;
		try {
			conn = getConn();
			sql = "update house_products set pname=?, cook=?, thum1=?, thum2=?, detail=?, price=?, stock=?, company=?, country=? where pnum=? and mem_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getpName());
			pstmt.setString(2, dto.getCook());
			pstmt.setString(3, dto.getThum1());
			pstmt.setString(4, dto.getThum2());
			pstmt.setString(5, dto.getDetail());
			pstmt.setInt(6, dto.getPrice());
			pstmt.setInt(7, dto.getStock());
			pstmt.setString(8, dto.getCompany());
			pstmt.setString(9, dto.getCountry());
			pstmt.setInt(10, dto.getPnum());
			pstmt.setInt(11, dto.getMem_num());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
	// 삭제
	public String[] delete(int mem_num, int pnum) {
		String[] result = new String[4];
		try {
			conn = getConn();
			sql = "select thum1, thum2, detail from house_products where pnum=? and mem_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pnum);
			pstmt.setInt(2, mem_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result[1] = rs.getString("thum1");
				result[2] = rs.getString("thum2");
				result[3] = rs.getString("detail");
			}

			sql = "delete from house_products where pnum=? and mem_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pnum);
			pstmt.setInt(2, mem_num);
			result[0] = ""+pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
	// 상품 목록
	public ArrayList<BusinessDTO> productList(int mem_num, int start, int end, String search) {
		ArrayList<BusinessDTO> list = new ArrayList<>();
		try {
			conn = getConn();
			if(search.equals("") || search == null) {
				sql = "select * from (select p.*, rownum as r from (select * from house_products where mem_num=? order by pnum desc) p) where r between ? and ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, mem_num);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
				rs = pstmt.executeQuery();
			}else {
				sql = "select * from (select p.*, rownum as r from (select * from house_products where mem_num=? and pname like(?) order by pnum desc) p) where r between ? and ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, mem_num);
				pstmt.setString(2, "%"+search+"%");
				pstmt.setInt(3, start);
				pstmt.setInt(4, end);
				rs = pstmt.executeQuery();
			}
			while(rs.next()) {
				BusinessDTO dto = new BusinessDTO();
				dto.setPnum(rs.getInt("pnum"));
				dto.setReg(rs.getTimestamp("reg"));
				dto.setpName(rs.getString("pname"));
				dto.setCook(rs.getString("cook"));
				dto.setThum1(rs.getString("thum1"));
				dto.setThum2(rs.getString("thum2"));
				dto.setPrice(rs.getInt("price"));
				dto.setStock(rs.getInt("stock"));
				dto.setCompany(rs.getString("company"));
				dto.setCountry(rs.getString("country"));
				list.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	
	// 상품 개수 카운트
	public int countList(int mem_num, String search) {
		int result = 0;
		try {
			conn = getConn();
			if(search == null) {
				sql = "select count(*) from house_products where mem_num=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, mem_num);
			}else {
				sql = "select count(*) from house_products where mem_num=? and pname like(?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, mem_num);
				pstmt.setString(2, "%"+search+"%");
			}
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
	// 총 주문 건수 확인 (판매자 메인 페이지같은 곳에서 위쪽에 출력하는 용도)
	public int countOrder(int mem_num) {
		int result = 0;
		try {
			conn = getConn();
			sql = "select count(*) from house_orderList where pnum in(select pnum from house_products where mem_num=?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
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
}
