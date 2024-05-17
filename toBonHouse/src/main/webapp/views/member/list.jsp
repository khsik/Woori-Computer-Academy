<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "member.ReviewDAO" %>
<%@ page import = "member.ReviewDTO" %>
<%@ page import = "java.util.ArrayList" %>
<%-- 여기 수정 리뷰게시판 --%>

<!-- CSS 스타일 정의 -->
<style>
    /* 테이블 스타일 */
    table {
        border-collapse: collapse;
        text-align: center;
    }
    /* 테이블 내 셀 스타일 */
    tr, td, th {
        border: 1px solid darkgray;
    }
    /* 이미지 스타일 */
    .img {
        width: 40px;
        height: 40px;
        margin-bottom: 3px;
    }
    /* 하이퍼링크 스타일 */
    a {
        text-decoration: none; /* 밑줄 제거 */
    }
</style>
<!-- 리뷰게시판 헤더 -->
<h1>리뷰게시판</h1>

<%
	String sid = (String)session.getAttribute("sid");
	// 페이지 정보 설정
    int pageSize = 10; // 한 페이지에 표시할 게시글 수
    String pageNum = request.getParameter("pageNum");
    if (pageNum == null) {
        pageNum = "1"; // 페이지 번호가 없으면 1페이지로 설정
    }

    int currentPage = Integer.parseInt(pageNum); // 현재 페이지 번호
    int startRow = (currentPage - 1) * pageSize + 1; // 페이지의 시작 행 번호
    int endRow = currentPage * pageSize; // 페이지의 끝 행 번호
    int count = 0; // 전체 게시글 수

    ArrayList<ReviewDTO> list = null; // 리뷰 리스트 초기화
    ReviewDAO dao = ReviewDAO.getInstance(); // 리뷰 DAO 인스턴스 생성
    count = dao.reviewCount(); // 전체 게시글 수 조회
    if (count > 0) {
        list = dao.reviewList(startRow, endRow); // 현재 페이지의 게시글 리스트 조회
    }
%>

<!-- 글목록 출력 -->
<center>
    <b>글목록(전체 글:<%=count%>)</b>
    <table style="width:700">
        <tr>
            <td align="right">
<% 			if(sid == null){ //세션없음 = 로그인상태가아님 %>
				<a href="loginForm.jsp?id=<%= sid%>">로그인</a>
<% 			}else{ %>
                <a href="writeForm.jsp">글쓰기</a>
<%			} %>
            </td>
        </tr>
    </table>

    <!-- 게시글이 없는 경우 -->
    <% if (count == 0) { %>
        <table width="700" border="1" cellpadding="0" cellspacing="0">
            <tr>
                <td align="center">
                    <h1>게시판에 저장된 글이 없습니다.</h1>
                </td>
            </tr>
        </table>
    <% } else { %>
        <!-- 게시글이 있는 경우 -->
        <table border="1" width="700" cellpadding="0" cellspacing="0" align="center">
            <tr height="30">
                <!-- 테이블 헤더 -->
                <td align="center" width="50">글번호</td>
                <td align="center" width="50">상품</td>
                <td align="center" width="250">글제목</td>
                <td align="center" width="50">작성자</td>
                <td align="center" width="50">별점</td>
                <td align="center" width="150">작성일</td>
            </tr>

            <!-- 게시글 출력 -->
            <% for(ReviewDTO dto : list) { %>
                <tr height="30">
                    <td align="center" width="50"><%=dto.getNum()%></td>
                    <td align="center" width="70">
					<%-- 이미지가 있는 경우 이미지를 표시하고, 없는 경우 기본 이미지를 표시합니다. --%>
                	<% if(dto.getImg() == null) { %>
                    	<img src="/toBonHouse/views/images/noimages.png" class="img"/>
					<% } else { %>
                    	<img src="../upload/<%=dto.getImg() %>" class="img" />
                	<% } %>
                    </td>
                    <td width="250">
                        <!-- 글 제목 링크 -->
                        <a href="content.jsp?num=<%=dto.getNum()%>&pageNum=<%=currentPage%>" style="text-decoration: none;">
                            <%=dto.getTitle()%>
                        </a>
                    </td>
                    <td width="50"><%= dto.getId() %></td>
                    <td width="50"><%=dto.getRating()%></td>
                    <td align="center" width="150"><%= dto.getReg()%></td>
                </tr>
            <% } %>
        </table>
    <% } %>

    <!-- 페이지 번호 링크 -->
    <% if (count > 0) {
        int pageCount = count / pageSize + ( count % pageSize == 0 ? 0 : 1);
        int startPage = (int)((currentPage - 1) / 10) * 10 + 1;
        int pageBlock = 10;
        int endPage = startPage + pageBlock - 1;
        if (endPage > pageCount) {
            endPage = pageCount;
        }
        if (startPage > 10) { %>
            <a href="list.jsp?pageNum=<%= startPage - 10 %>">[이전]</a>
        <% }
        for (int i = startPage; i <= endPage; i++) { %>
            <a href="list.jsp?pageNum=<%= i %>">[<%= i %>]</a>
        <% }
        if (endPage < pageCount) { %>
            <a href="list.jsp?pageNum=<%= startPage + 10 %>">[다음]</a>
        <% }
    } %>
</center>
