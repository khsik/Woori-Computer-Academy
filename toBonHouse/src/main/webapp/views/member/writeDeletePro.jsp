<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.ReviewDAO" %>
<%@ page import="java.io.File"%>

<%--  글 삭제 --%>
<%
    request.setCharacterEncoding("UTF-8");   // 요청 파라미터의 문자 인코딩 설정
    int num = Integer.parseInt(request.getParameter("num"));    // 삭제할 글의 번호를 파라미터로부터 가져옴
    String pageNum = request.getParameter("pageNum");            // 페이지 번호를 파라미터로부터 가져옴

    ReviewDAO dao = ReviewDAO.getInstance();    // ReviewDAO 객체 생성
    String[] img = dao.delete(num);             // 글 삭제 메서드 호출하여 삭제된 이미지 파일 정보 가져옴

    // 이미지 파일이 있으면 파일 삭제
    if (!(img[0] == null)) {
        String filePath = request.getRealPath("views/upload");   // 이미지 파일 경로 설정
        File f = new File(filePath + "/" + img[0]);             // 파일 객체 생성
        f.delete();     // 파일 삭제
    }
%>  

<%-- 삭제 성공 여부에 따라 메시지 출력 및 페이지 이동 --%>
<% if(img[1].equals("1")){ %>
    <script>
        alert("글이 삭제되었습니다.");
        window.location = "list.jsp?pageNum=<%=pageNum%>";    // 리스트 페이지로 이동
    </script>   
<% } else { %>
    <script>
        alert("글 삭제에 실패했습니다.");
        window.location = "list.jsp?pageNum=<%=pageNum%>";    // 리스트 페이지로 이동
    </script>
<% } %>