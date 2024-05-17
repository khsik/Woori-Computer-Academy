package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReviewDAO {

    private static ReviewDAO instance = new ReviewDAO();

    public static ReviewDAO getInstance() {
        return instance;
    }

    private ReviewDAO() {};

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private String sql;

    private Connection getConn() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String dburl = "jdbc:oracle:thin:@localhost:1521:orcl";
        String user = "project1";
        String pw = "tiger";

        Connection conn = DriverManager.getConnection(dburl, user, pw);
        return conn;
    }

    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } // 각각 끊어주지 않으면 서로 영향을 끼칠 수있기에 예외를 각각처리함
        // 연결을 끊지 않으면 메모리 누수 발생
    }

 // 리뷰 등록 메서드
    public int insertReview(ReviewDTO dto) {
        int result = 0;
        try {
            conn = getConn();
            // 리뷰를 데이터베이스에 삽입하는 SQL 쿼리
            sql = "INSERT INTO review VALUES (review_seq.nextval, ?, ? , ? , ? , ? , ? , SYSDATE , ? )";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dto.getMem_num());
            pstmt.setString(2, dto.getId());
            pstmt.setInt(3, dto.getPnum());
            pstmt.setString(4,dto.getTitle());
            pstmt.setString(5, dto.getImg());
            pstmt.setString(6, dto.getContent()); // 리뷰 내용 설정
            pstmt.setInt(7, dto.getRating()); // 별점 설정
            result = pstmt.executeUpdate(); // 쿼리 실행 및 결과 반환
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs); // 리소스 해제
        }
        return result; // 삽입 결과 반환
    }

    /* 전체 게시글 수 조회 */
    public int reviewCount() {
        int result = 0;
        try {
            conn = getConn();
            // 전체 게시글 수를 조회하는 SQL 쿼리
            sql = "select count(*) from Review";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery(); // 쿼리 실행 및 결과 반환
            if (rs.next()) {
                result = rs.getInt(1); // 결과 확인
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs); // 리소스 해제
        }
        return result; // 조회 결과 반환
    }

    /* 게시글 목록 조회 */
    public ArrayList<ReviewDTO> reviewList(int start, int end) {
        ArrayList<ReviewDTO> list = new ArrayList<ReviewDTO>();
        try {
            conn = getConn();
            // 페이징 처리를 위해 start부터 end까지의 게시글 목록을 조회하는 SQL 쿼리
            sql = "select * from(select b.*, rownum as r from(select * from Review order by num desc)b) where r between ? and ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, start);
            pstmt.setInt(2, end);
            rs = pstmt.executeQuery(); // 쿼리 실행 및 결과 반환
            while (rs.next()) {
                // 각 게시글의 정보를 DTO에 저장하여 리스트에 추가
                ReviewDTO dto = new ReviewDTO();
                dto.setNum(rs.getInt("num"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setReg(rs.getTimestamp("reg"));
                dto.setId(rs.getString("id"));
                dto.setImg(rs.getString("img"));
                dto.setRating(rs.getInt("rating"));
                list.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs); // 리소스 해제
        }
        return list; // 게시글 목록 반환
    }

    /*게시글 상세보기*/
    public ReviewDTO content(int num) {
        ReviewDTO dto = new ReviewDTO();
        try {
            conn = getConn();
            // 게시글 번호에 해당하는 게시글 내용을 조회하는 SQL 쿼리
            sql = "select * from Review where num = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery(); // 쿼리 실행 및 결과 반환
            if(rs.next()) {
                // 조회된 게시글 정보를 DTO에 저장
                dto.setNum(rs.getInt("num"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setImg(rs.getString("img"));
                dto.setRating(rs.getInt("rating"));
                dto.setReg(rs.getTimestamp("reg"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(conn, pstmt, rs); // 리소스 해제
        }
        return dto; // 게시글 정보 반환
    }
    
    // 글 삭제
    public String[] delete(int num) {
        String[] img = new String[2];
        try {
        conn= getConn();
        // 게시글 번호에 해당하는 게시글을 조회하는 SQL 쿼리
        sql = "select * from  Review where num=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, num);
        rs = pstmt.executeQuery();    // 쿼리 실행 및 결과 반환
        if(rs.next()) {    // 결과가 있다면
            img[0] = rs.getString("img");
        }
        // 게시글 번호에 해당하는 게시글을 삭제하는 SQL 쿼리
        sql = "delete from Review where num=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, num);
        img[1] = ""+ pstmt.executeUpdate(); // 삭제된 행의 수를 문자열로 변환하여 저장
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(conn, pstmt, rs); // 리소스 해제
        }
        return img; // 삭제 결과 반환
    }
    
    // 글 수정
    public int ReviewUpdate(ReviewDTO dto) {
        int result = 0;
        try {
            conn = getConn();
            // 게시글 번호에 해당하는 게시글의 정보를 수정하는 SQL 쿼리
            sql = " update Review set id = ? , pnum = ? , title = ? , img = ?, rating = ? , content = ? where num = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getId());
            pstmt.setInt(2, dto.getPnum());
            pstmt.setString(3, dto.getTitle());
            pstmt.setString(4, dto.getImg());
            pstmt.setInt(5, dto.getRating());
            pstmt.setString(6,dto.getContent());
            pstmt.setInt(7,dto.getNum());
            result = pstmt.executeUpdate(); // 수정된 행의 수를 결과 변수에 저장
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs); // 리소스 해제
        }
        return result; // 수정된 행의 수를 반환
    }
}