<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.io.File" %>
<%@ page import ="com.oreilly.servlet.MultipartRequest" %>
<%@ page import ="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="member.ReviewDAO" %>
<%@ page import="member.ReviewDTO" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dto" class="member.ReviewDTO"/>
<%-- 글작성 --%>
	<%@ include file="../inc/session.jsp" %>
<%
// 파일 업로드 관련 설정
	String filePath = request.getRealPath("views/upload"); // 실제 파일이 업로드될 경로
	int max = 1024 * 1024 * 5; // 최대 파일 크기 설정 (5MB)
	String enc = "UTF-8";	// 인코딩 설정
	DefaultFileRenamePolicy dp = new DefaultFileRenamePolicy(); // 파일명 중복 시 자동으로 이름 변경하는 정책
	MultipartRequest mr = new MultipartRequest(request, filePath, max, enc, dp); // MultipartRequest 객체 생성
	
	// 폼 데이터 가져오기
	String id = mr.getParameter("id"); // 작성자 아이디
	int pnum = Integer.parseInt(mr.getParameter("pnum")); // 상품 번호
	String title = mr.getParameter("title"); // 리뷰 제목
	String content = mr.getParameter("content"); // 리뷰 내용
	String img = mr.getFilesystemName("img"); // 업로드된 이미지 파일명
	int rating = Integer.parseInt(mr.getParameter("rating")); // 리뷰 별점

	// DAO 및 DTO 객체 생성
	ReviewDAO dao = ReviewDAO.getInstance(); // 싱글톤 DAO 객체 생성
	dto.setId(id); // DTO에 작성자 아이디 설정
	dto.setPnum(pnum); // DTO에 상품 번호 설정
	dto.setTitle(title); // DTO에 리뷰 제목 설정
	dto.setContent(content); // DTO에 리뷰 내용 설정
	dto.setImg(img); // DTO에 이미지 파일명 설정
	dto.setRating(rating); // DTO에 별점 설정
	dto.setMem_num(mem_num);

	// 리뷰 등록 수행
	int result = dao.insertReview(dto); // 리뷰 등록 결과 반환

	// 등록 결과에 따라 처리
	if (result == 1) { // 등록 성공 시
%>
		<script>
			alert("글이 등록되었습니다"); // 알림 메시지 표시
			window.location="list.jsp"; // 리스트 페이지로 이동
		</script>
<%
	} else { // 등록 실패 시
%>
		<script>
			alert("글 등록에 실패했습니다"); // 알림 메시지 표시
			history.go(-1); // 이전 페이지로 돌아가기
		</script>
<%
	}
%>
