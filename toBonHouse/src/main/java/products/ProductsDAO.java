package products;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import business.BusinessDTO;
import business.OrderDTO;
import member.MemberDTO;

public class ProductsDAO {
	// 싱글톤 인스턴스 변수
	private ProductsDAO () {};
	private static ProductsDAO instance = new ProductsDAO ();
	public static ProductsDAO getInstance() {return instance;}
	
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
	
	// 구매 페이지 멤버 테이블 
	public MemberDTO buyMember(int mem_num){
		MemberDTO dto = new MemberDTO();
			try {
				conn = getConn();
				sql = "select * from house_member where mem_num  = ? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,mem_num);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					dto.setName(rs.getString("name"));
					dto.setTel_com(rs.getString("tel_com"));
					dto.setTel(rs.getString("tel"));
					dto.setEmail(rs.getNString("email"));
					dto.setAddress(rs.getString("address"));
					dto.setBalance(rs.getInt("balance"));
					dto.setPoint(rs.getInt("point"));
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				close(conn, pstmt, rs);
			}
		return dto;
	}
	
	// 구매 페이지 판매 테이블 
	public ArrayList<BusinessDTO> buyBusiness(int pnumArr[] ){
		ArrayList<BusinessDTO> Blist = new ArrayList<BusinessDTO>();	
		try {
			conn = getConn();
			sql = "select * from house_products where pnum = ? " ;
			pstmt = conn.prepareStatement(sql);
			for(int i=0; i< pnumArr.length; i++) {
				pstmt.setInt(1,pnumArr[i]);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					BusinessDTO dto = new BusinessDTO();
					dto.setpName(rs.getString("pName"));
					dto.setThum1(rs.getString("thum1"));
					dto.setThum2(rs.getNString("thum2"));
					dto.setPrice(rs.getInt("price"));
					dto.setCompany(rs.getString("company"));
					dto.setCountry(rs.getString("country"));
					dto.setStock(rs.getInt("stock"));
					dto.setPnum(rs.getInt("pnum"));
					Blist.add(dto);
				}	
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, rs);
		}
		return Blist;
	}

	// 상품 목록
	public ArrayList<BusinessDTO> goodslist(int startRow , int endRow , String cook){
		ArrayList<BusinessDTO> list = new ArrayList<BusinessDTO>();		
		try {
			conn = getConn();
		if(cook == null || cook.equals("null")) {
			sql = "select * from(select b.*,rownum r from(select * from house_products order by pnum desc)b) where r >= ? and r <= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2,endRow);
			rs = pstmt.executeQuery();
		}else {
			sql = "select * from(select b.*,rownum r from(select * from house_products where cook = ? order by pnum desc)b) where r >= ? and r <= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,cook);
			pstmt.setInt(2,startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
		}
			while(rs.next()) {
				BusinessDTO dto = new BusinessDTO();
				dto.setPnum(rs.getInt("pnum"));
				dto.setpName(rs.getString("pname"));
				dto.setPrice(rs.getInt("price"));	// 상품 제목 
				dto.setThum1(rs.getString("thum1"));
				dto.setThum2(rs.getString("thum2"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, rs);
		}
		return list;
	}

	// 상품 목록 count
	public int countList(String cook) {
		int result = 0;
		try {
			conn = getConn();
			if(cook == null || cook.equals("null")) {
				sql = "select count(*) from house_products";
				pstmt = conn.prepareStatement(sql);
			}else {
				sql = "select count(*) from house_products where cook = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cook);
			}
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
	
	// 주문 상세 페이지 
	public BusinessDTO Content(int pnum) {
		BusinessDTO dto = new BusinessDTO();
		try {
			conn = getConn();
			sql = "select * from house_products where pnum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,pnum);
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
				dto.setSales(rs.getInt("sales"));
				dto.setDetail(rs.getString("detail"));
				dto.setCompany(rs.getString("company"));
				dto.setCountry(rs.getString("country"));
			}else {	// 주소창에서 임의로 존재하지 않는 pnum에 접근했다는 뜻
				dto.setPnum(0);	// 페이지에서 pnum == 0 으로 예외처리
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, rs);
		}
		return dto;
	}

	// 장바구니 목록 
	public ArrayList<BusinessDTO> jangList(int mem_num){
		ArrayList<BusinessDTO> list = new ArrayList<BusinessDTO>();	
		try {
			conn = getConn();
			sql = "select * from house_products where pnum in(select pnum from house_orderJang where mem_num = ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,mem_num);
			rs = pstmt.executeQuery();
				while(rs.next()) {
					BusinessDTO dto = new BusinessDTO();
					dto.setPnum(rs.getInt("pnum"));
					dto.setpName(rs.getString("pName"));
					dto.setPrice(rs.getInt("price"));
					dto.setThum1(rs.getString("thum1"));
					dto.setThum2(rs.getString("thum2"));
					list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}

	// 장바구니 추가
	public int jangAdd( int mem_num , int pnum) {
		int result = 0;
		try {
			conn = getConn();
			sql = "insert into house_orderJang values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,mem_num);			// 멤버 테이블 회원 번호 
			pstmt.setInt(2,pnum);				// 판매자 테이블 상품 번호 
			result = pstmt.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			close(conn, pstmt, rs);
		}
		return result;
	}

	// 장바구니 삭제
	public void jangDelete(int mem_num , int numArr[]) {
		try {
			conn = getConn();
			sql = "delete from house_orderJang where mem_num = ? and pnum = ?";
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < numArr.length; i++) {
				pstmt.setInt(1, mem_num); 					// 멤버 테이블 회원번호 
				pstmt.setInt(2, numArr[i]); 				// 판매자 테이블 상품번호 배열로 
				pstmt.addBatch(); 							// 배치에 쿼리 추가
			}
			pstmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, rs);
		}
	}

	// 구매 페이지 저장 
		public int buySet(ArrayList<OrderDTO> list) {
			int result = 0;
			try {
				conn = getConn();
				sql = "insert into house_orderList values(?,?,?,?,'결제완료',sysdate,?,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				String sql2 = "update house_products set stock = stock - ?, sales = sales + ? where pnum=?";
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				int total = 0; // 상품 가격 총합
				for (OrderDTO dto : list) {
					pstmt.setInt(1, dto.getBnum()); 					// 주문번호 
					pstmt.setInt(2, dto.getMem_num()); 					// 멤버 테이블 회원번호 
					pstmt.setInt(3, dto.getPnum()); 				// 판매자 테이블 상품번호 배열로
					pstmt.setInt(4, dto.getTotalPrice()); // totalPrice
					pstmt.setString(5, dto.getPayment()); // payment
					pstmt.setString(6,dto.getMsg() );// msg
					pstmt.setString(7,dto.getThum2());// thum2
					pstmt.setInt(8,dto.getAmount());// amount
					pstmt.setString(9,dto.getRec_addr());// rec_addr
					pstmt.setString(10,dto.getRec_name() );// rec_name
					pstmt.setString(11,dto.getRec_tel());// rec_tel
					pstmt.addBatch();
					
					total += dto.getTotalPrice();

					pstmt2.setInt(1,dto.getAmount());
					pstmt2.setInt(2,dto.getAmount());
					pstmt2.setInt(3,dto.getPnum());
					pstmt2.addBatch();
				}

				int[] arr = pstmt.executeBatch();
				for(int ar : arr) {
					result += ar;
				}
				
				pstmt2.executeBatch();
				pstmt2.close();
				
				if(list.get(0).getPayment().equals("충전")) {	// 충전된 금액으로 결제시 잔액 수정
					String sql3 = "update house_member set balance = balance - ? where mem_num = ?";
					PreparedStatement pstmt3 = conn.prepareStatement(sql3);
					pstmt3.setInt(1, total);
					pstmt3.setInt(2, list.get(0).getMem_num());
					pstmt3.executeUpdate();
					pstmt3.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(conn, pstmt, rs);
			}
			return result;
		}

	// 값 하나로 저장 
	public int buylist(int mem_num) {
		int result = 0;
		try {
			conn = getConn();
			sql = "insert into house_orderNum values(?,house_orderNum_seq.nextval)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,mem_num);
			pstmt.executeUpdate();
			
			sql = "select max(bnum) from house_orderNum where mem_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,mem_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, rs);
		}
		return result;
	}

	// 주문 목록
	public Map<Integer, List<OrderDTO>> getBuyList(int mem_num ) {
		ArrayList<OrderDTO> list = new ArrayList<>();
		Map<Integer, List<OrderDTO>> groupedMap = new HashMap<>();
		try {
			conn = getConn();
			sql = "select * from house_orderlist where bnum in(select bnum from house_ordernum where mem_num = ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderDTO dto = new OrderDTO();
				dto.setThum2(rs.getString("thum2"));
				dto.setTotalPrice(rs.getInt("totalprice"));
				dto.setPnum(rs.getInt("pnum"));
				dto.setBnum(rs.getInt("bnum"));
				list.add(dto);
			}

		    for (OrderDTO dto : list) {
		        int bnum = dto.getBnum();
		        if (!groupedMap.containsKey(bnum)) {
		            groupedMap.put(bnum, new ArrayList<>());
		        }
		        groupedMap.get(bnum).add(dto);
		    }

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, rs);
		}
		return groupedMap;
	}
}
