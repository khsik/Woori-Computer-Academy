<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../inc/session.jsp" %>
<% request.setCharacterEncoding("UTF-8"); %>
<h1>member/deletePro.jsp</h1>

<%-- 회원탈퇴 처리 --%>
<%@ page import="member.MemberDAO" %>
<%@ page import="member.MemberDTO" %>

<%
    // 싱글톤 객체 생성
    MemberDAO dao = MemberDAO.getInstance();   // MemberDAO 싱글톤 객체 생성
    MemberDTO dto = new MemberDTO();           // MemberDTO 객체 생성
%>

<%
    // 현재 세션에서 사용자 아이디 가져오기
    dto.setMem_num(mem_num);					
    dto.setId(sid);                             // DTO에 사용자 아이디 설정
    dto.setPw(request.getParameter("pw"));     // DTO에 입력된 비밀번호 설정
    int result = dao.deleteMember(dto);         // 회원 탈퇴 메서드 호출하여 결과 반환

    // 회원 탈퇴 결과에 따라 처리
    if (result == 1) {                          // 탈퇴 성공
        session.invalidate();                   // 세션 무효화
%>
    <script>
        alert("탈퇴되었습니다.");              // 탈퇴 완료 메시지 출력
        window.location="../main.jsp";            // 메인 페이지로 이동
    </script>
<% } else { %>
    <script>
        alert("비밀번호를 확인해주세요.");       // 비밀번호 오류 메시지 출력
        history.go(-1);                        // 이전 페이지로 이동
    </script>
<% } %>
