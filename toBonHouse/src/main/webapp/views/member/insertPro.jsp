<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="member.MemberDAO" %>
<h1>InsertPro.jsp</h1>

<%-- 일반회원 판매자회원 둘 다 가입 --%>
<% 
    // POST 방식의 요청에서 한글을 처리하기 위해 인코딩 설정
    request.setCharacterEncoding("UTF-8"); 
%>

<jsp:useBean id="dto" class="member.MemberDTO" />
<jsp:setProperty name="dto" property="*" />

<%
    // MemberDAO 싱글톤 객체 생성
    MemberDAO dao = MemberDAO.getInstance();

    // dto 객체를 사용하여 회원 정보를 데이터베이스에 삽입
    dao.insertMember(dto);
%>

<script>
    // 회원가입이 성공했을 때 알림창을 띄우고 메인 페이지로 이동
    alert("가입되었습니다.");
    window.location="../main.jsp";
</script>
