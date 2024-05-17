package business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAO {
	// 싱글톤
	private OrderDAO() {}
	private static OrderDAO instance = new OrderDAO();
	public static OrderDAO getInstance() {return instance;}
	
	// 변수
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;
	
	// DB 연결
	public Connection getConn() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.0.138:1521:orcl";
		String id = "project1";
//		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//		String id = "scott";
		String pw = "tiger";
		Connection conn = DriverManager.getConnection(url, id, pw);
		return conn;
	}

	// 연결 끊기
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {if(conn != null) {conn.close();}} catch (SQLException e) {}
		try {if(pstmt != null) {pstmt.close();}} catch (SQLException e) {}
		try {if(rs != null) {rs.close();}} catch (SQLException e) {}
	}
	
	// 받은 주문 목록
	public ArrayList<OrderDTO> orderList(int mem_num) {
		ArrayList<OrderDTO> list = new ArrayList<>();
		try {
			conn = getConn();
			sql = "select pnum, count(bnum), sum(totalPrice), sum(amount), thum2 from house_orderList group by pnum, thum2 having pnum in(select pnum from house_products where mem_num=?) order by pnum desc"; 
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderDTO dto = new OrderDTO();
				dto.setPnum(rs.getInt(1));	// 상품번호
				dto.setBnum(rs.getInt(2));	// bnum 카운트 (주문 건수)
				dto.setTotalPrice(rs.getInt(3));	// 총 합계 금액
				dto.setAmount(rs.getInt(4));	// 총 주문 상품 수량
				dto.setThum2(rs.getString(5));	// 썸네일2
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	

	// 상세 주문 목록
	public ArrayList<OrderDTO> orderListDetail(int mem_num, String pnum){
		ArrayList<OrderDTO> list = new ArrayList<>();
		try {
			conn = getConn();
			if(pnum == null) { // 전체
				sql = "select * from house_orderList where pnum in(select pnum from house_products where mem_num=?) order by bnum asc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, mem_num);
			}else { // 특정상품
				sql = "select * from house_orderList where pnum=? and pnum in(select pnum from house_products where mem_num=?) order by bnum asc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pnum);
				pstmt.setInt(2, mem_num);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderDTO dto = new OrderDTO();
				dto.setBnum(rs.getInt("bnum"));
				dto.setPnum(rs.getInt("pnum"));
				dto.setMem_num(rs.getInt("mem_num"));
				dto.setAmount(rs.getInt("Amount"));
				dto.setTotalPrice(rs.getInt("totalprice"));
				dto.setOrderReg(rs.getTimestamp("orderreg"));
				dto.setRec_addr(rs.getString("rec_addr"));
				dto.setStatus(rs.getString("status"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	
	// 배송처리 (주문 상태 변경)
	public int finishOrder(int[] bnum, int[] pnum) {
		int result = 0;
		try {
			conn = getConn();
			sql = "update house_orderlist set status='배송' where bnum=? and pnum=?";
			pstmt = conn.prepareStatement(sql);
			for(int i=0; i<bnum.length; i++) {
				pstmt.setInt(1, bnum[i]);
				pstmt.setInt(2, pnum[i]);
				pstmt.addBatch();
			}
			int[] arr = pstmt.executeBatch();
			
			for(int ar : arr) {
				result += ar;	// 몇건 update 되었는지 확인하려고 하나의 int 변수에 다 더함.
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
	
}
