<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.ReviewDTO"%> <%-- ReviewDTO 클래스 import --%>
<%@ page import ="com.oreilly.servlet.MultipartRequest" %> <%-- MultipartRequest 클래스 import --%>
<%@ page import ="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%> <%-- DefaultFileRenamePolicy 클래스 import --%>
<%@ page import ="java.io.File" %> <%-- File 클래스 import --%>
<%@ page import ="member.ReviewDAO" %> <%-- ReviewDAO 클래스 import --%>

<%-- 글 수정 프로세스 --%>
<h1>Review/updatePro</h1>

<% request.setCharacterEncoding("UTF-8"); %> <%-- 요청 파라미터의 문자 인코딩을 UTF-8로 설정 --%>

<jsp:useBean id="dto" class="member.ReviewDTO"/> <%-- ReviewDTO 빈 객체 생성 --%>

<% 
	// 업로드할 폴더 경로 설정
	String filePath = request.getRealPath("views/upload"); // 업로드할 실제 폴더 경로
	// 파일 크기 설정
	int max = 1024*1024*5; // 파일 크기 제한: 5MB
	// 인코딩 설정
	String enc = "UTF-8"; // 인코딩 설정
	// 파일 이름 중복 방지 정책 설정
	DefaultFileRenamePolicy dp = new DefaultFileRenamePolicy(); // 같은 파일 이름이 있을 경우에 숫자를 붙여서 이름을 변경함
	// 멀티파트 요청 처리
	MultipartRequest mr = new MultipartRequest(request, filePath, max, enc, dp);
	
    // 요청 파라미터 값 가져오기
    String id = mr.getParameter("id");
    String title = mr.getParameter("title");
    String img = mr.getFilesystemName("img"); // 업로드된 파일의 시스템 이름 가져오기
    int rating = Integer.parseInt(mr.getParameter("rating")); // 별점 가져오기
    int num = Integer.parseInt(mr.getParameter("num")); // 글 번호 가져오기
    String orgImg = mr.getParameter("orgImg"); // 원본 이미지 이름 가져오기
    String pageNum = mr.getParameter("pageNum"); // 페이지 번호 가져오기
    
    // DAO 객체 생성
    ReviewDAO dao = ReviewDAO.getInstance();
    
    // DTO에 값 설정
    dto.setId(id);
    dto.setTitle(title);
    dto.setImg(img);
    if (img == null) { // 이미지 수정 안할 경우 원본 이미지 유지
        dto.setImg(orgImg);
    } else { // 이미지 수정할 경우 원본 이미지 삭제
        File f = new File(filePath + "/" + orgImg);
        f.delete();
    } 
    dto.setRating(rating); // 별점 설정
    dto.setNum(num);
    
    // 리뷰 수정 처리
    int result = dao.ReviewUpdate(dto);
    
    // 수정 결과에 따른 알림 메시지 출력 및 페이지 이동
    if (result == 1) {
%>
        <script>
            alert("글이 수정되었습니다.");
            window.location="list.jsp?pageNum=<%= pageNum %>"; // 리스트 페이지로 이동
        </script>
<% } else { %>
        <script>
            alert("수정 실패");
            window.location="list.jsp?pageNum=<%= pageNum %>"; // 리스트 페이지로 이동
        </script>
<% } %>	
