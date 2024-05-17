package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 싱글톤 패턴으로 구현된 DAO 클래스
/**
 * 
 */
public class MemberDAO {
    
    // 싱글톤 인스턴스 변수
    private static MemberDAO instance = new MemberDAO();

    // 생성자를 private으로 선언하여 외부에서 인스턴스를 생성할 수 없도록 함
    private MemberDAO() {
        // 클래스 내부에서만 호출되어야 하므로 private으로 선언
    }
    
    // 인스턴스를 반환하는 정적 메서드
    public static MemberDAO getInstance() {
        return instance;
    }

    // 데이터베이스 연결을 위한 메서드
    private Connection getConn() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.0.138:1521:orcl";
		String id = "project1";
        String pw = "tiger";
        return DriverManager.getConnection(url, id, pw);
    }

    // 데이터베이스 연결 및 리소스 해제를 위한 메서드
    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // 공통 변수 선언
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    // 회원 가입을 위한 메서드
    public void insertMember(MemberDTO dto) {
        try {
            conn = getConn();
            // 회원 정보를 데이터베이스에 삽입하는 SQL 쿼리
            String sql = "insert into house_member values(house_member_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, 0, 0)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getId());
            pstmt.setString(2, dto.getPw());
            pstmt.setString(3, dto.getName());
            pstmt.setString(4, dto.getTel_com());
            pstmt.setString(5, dto.getTel());
            pstmt.setString(6, dto.getEmail());
            pstmt.setString(7, dto.getAddress());
            pstmt.setInt(8, dto.getGrade());
            pstmt.executeUpdate(); // 쿼리 실행
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs); // 리소스 해제
        }
    }
 
    // 아이디 중복 확인을 위한 메서드
    public boolean confirmId(String id) {
        boolean result = false;
        try {
            conn = getConn();
            // 입력된 아이디가 이미 존재하는지 확인하는 SQL 쿼리
            String sql = "SELECT * FROM house_member WHERE id=? and grade > 0";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery(); // 쿼리 실행
            result = rs.next(); // 결과 확인
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs); // 리소스 해제
        }
        return result;
    }
    
    // ┌ 탈퇴 회원과 회원가입 유저랑 id , pw 가 같을때 처리 문제. 
    // 로그인 id, pw 확인
    public int loginCheck(MemberDTO dto) {
    	int result = 0;	// 0 로그인실패, 1 탈퇴유예기간(로그인x), 2 로그인성공
    	try {
    		conn = getConn();
    		// 입력된 아이디와 비밀번호가 일치하는지 확인하는 SQL 쿼리
    		String sql = " select grade from house_member where id=? and pw=? ";
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setString(1, dto.getId());
    		pstmt.setString(2, dto.getPw());
    		rs = pstmt.executeQuery(); // 쿼리 실행
    		if(rs.next()) {
    			int grade = rs.getInt(1);
    			if(grade > -1) {
    				result = 2;
    			}else if(grade == -1) {
    				result = 1;
    			}
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}finally {
    		close(conn, pstmt, rs); // 리소스 해제
    	}
    	return result;
    }

    // 사용자의 회원 번호, 등급 가져오는 메서드
    public int[] getMG(String id) {
    	int[] mg = new int[2];
    	try {
    		conn = getConn();
    		// 입력된 아이디에 해당하는 사용자의 이름을 가져오는 SQL 쿼리
    		String sql = "SELECT mem_num, grade FROM house_member WHERE id=?";
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setString(1, id);
    		rs = pstmt.executeQuery(); // 쿼리 실행
    		if (rs.next()) {
    			mg[0] =	rs.getInt("mem_num");
    			mg[1] = rs.getInt("grade");
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		close(conn, pstmt, rs); // 리소스 해제
    	}
    	return mg;
    }
    
    // 사용자의 이름을 가져오는 메서드
    public String getName(String id) {
        String name = null;
        try {
            conn = getConn();
            // 입력된 아이디에 해당하는 사용자의 이름을 가져오는 SQL 쿼리
            String sql = "SELECT name FROM house_member WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery(); // 쿼리 실행
            if (rs.next()) {
                name = rs.getString("name"); // 결과 확인
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs); // 리소스 해제
        }
        return name;
    }
    
    // 회원 탈퇴
    public int deleteMember(MemberDTO dto) {
        int result = 0;
        try {
            conn = getConn();
            // 입력된 아이디와 비밀번호에 해당하는 회원 정보를 삭제하는 SQL 쿼리
            String sql = "update house_member set grade = -1 where id=? and pw=? and mem_num=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getId());
            pstmt.setString(2, dto.getPw());
            pstmt.setInt(3, dto.getMem_num());
            result = pstmt.executeUpdate(); // 쿼리 실행
            if (result == 1) {
	            sql = "insert into house_resign values(?,sysdate)";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, dto.getMem_num());
	            pstmt.executeUpdate();
	            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(conn, pstmt, rs); // 리소스 해제
        }
        return result;
    }
    
    // 내 정보 확인
    public MemberDTO idInfo(String id) {
        MemberDTO dto = new MemberDTO();
        try {
            conn = getConn();
            // 입력된 아이디에 해당하는 회원 정보를 가져오는 SQL 쿼리
            String sql = " select * from house_member where id=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery(); // 쿼리 실행
            if(rs.next()) {
                // 결과를 DTO 객체에 저장
                dto.setMem_num(rs.getInt("Mem_num"));
                dto.setId(rs.getString("id"));
                dto.setPw(rs.getString("pw"));
                dto.setName(rs.getString("name"));
                dto.setTel_com(rs.getString("tel_com"));
                dto.setTel(rs.getString("tel"));
                dto.setEmail(rs.getString("email"));
                dto.setAddress(rs.getString("address"));
                dto.setGrade(rs.getInt("grade"));
                dto.setBalance(rs.getInt("balance"));
                dto.setPoint(rs.getInt("point"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs); // 리소스 해제
        }
        return dto;
    }
    
    // 회원 정보 수정 
    public int updateMember(MemberDTO dto) {
        int result = 0;
        try {
            conn = getConn();
            // 입력된 아이디에 해당하는 회원 정보를 수정하는 SQL 쿼리
            String sql = "UPDATE house_member set pw =?, name =?, tel_com =?, tel =?, email =?, address =?  where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getPw());
            pstmt.setString(2, dto.getName());
            pstmt.setString(3, dto.getTel_com());
            pstmt.setString(4, dto.getTel());
            pstmt.setString(5, dto.getEmail());
            pstmt.setString(6, dto.getAddress());
            pstmt.setString(7, dto.getId());
            result = pstmt.executeUpdate(); // 쿼리 실행
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs); // 리소스 해제
        }
        return result;
    }
    
    // 돈 충전
    public int updateBalance(MemberDTO dto) {
        int result = 0;
        try {
            conn = getConn();
            // 입력된 아이디에 해당하는 회원의 잔액을 업데이트하는 SQL 쿼리
            String sql = "UPDATE house_member SET balance = ? WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dto.getBalance());
            pstmt.setString(2, dto.getId());
            result = pstmt.executeUpdate(); // 쿼리 실행
        } catch (Exception e) {
            e.printStackTrace(); // 예외 정보를 콘솔에 출력합니다.
        } finally {
            close(conn, pstmt, rs); // 리소스 해제
        }
        return result;
    }
    
    // 사용자의 잔액을 가져오는 메서드
    public int getBalance(String id) {
        int balance = 0;
        try {
            conn = getConn();
            // 입력된 아이디에 해당하는 회원의 잔액을 가져오는 SQL 쿼리
            String sql = "SELECT balance FROM house_member WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery(); // 쿼리 실행
            if (rs.next()) {
                balance = rs.getInt("balance"); // 결과 확인
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs); // 리소스 해제
        }
        return balance;
    }
    
    // 사용자의 포인트를 가져오는 메서드
    public int getPoint(String id) {
        int point = 0;
        try {
            conn = getConn();
            // 입력된 아이디에 해당하는 회원의 포인트를 가져오는 SQL 쿼리
            String sql = "SELECT point FROM house_member WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery(); // 쿼리 실행
            if (rs.next()) {
                point = rs.getInt("point"); // 결과 확인
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs); // 리소스 해제
        }
        return point;
    }
    
    // 탈퇴 회원 복구 메서드
    // 복구시에 일반회원으로 돌리고 ? QNA에 글 쓰는걸로 ㅇㅇ.
    // 아니라면 복구 페이지에서 사업자인지, 일반 유저인지 받아야함.
    public int restore(String id, String pw) {
    	int result = 0;
    	
    	try {
			conn = getConn();
			String sql = "select * from house_member where id = ? and pw = ? and grade = -1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {	// 받은 id, pw로 grade == -1 계정이 있다면
				int mem_num = rs.getInt("mem_num");
				
				sql = "delete from house_resign where mem_num = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, mem_num);
				result = pstmt.executeUpdate();
				
				if (result == 1) {
					sql = "update house_member set grade = 1 where mem_num=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, mem_num);
		            result = pstmt.executeUpdate();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, rs);
		}
    	
    	return result;
    }
    
    
    
}
