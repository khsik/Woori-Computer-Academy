<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<h1>member/updatePro</h1> <%-- 페이지 제목 --%>

<%-- 회원 정보 업데이트 --%>
<% request.setCharacterEncoding("UTF-8"); %> <%-- 요청 파라미터의 문자 인코딩을 UTF-8로 설정 --%>

<%@ page import="member.MemberDAO" %> <%-- MemberDAO 클래스 import --%>
<jsp:useBean id="dto" class="member.MemberDTO" /> <%-- MemberDTO를 사용하여 dto 빈 객체 생성 --%>
<jsp:setProperty name="dto" property="*" /> <%-- dto에 요청 파라미터 값을 설정 --%>

<%
    // 싱글톤 객체 생성
    MemberDAO dao = MemberDAO.getInstance();
%>

<% 
    // 세션에서 현재 로그인한 사용자의 아이디 가져오기
	// String sid = (String)session.getAttribute("sid"); // 안쓰였음
    // 회원 정보 업데이트 수행 후 결과를 result 변수에 저장
	int result = dao.updateMember(dto); // 수정된 행의 수를 반환받음

    // 업데이트 결과에 따라 처리
	if(result > 0) { // 업데이트가 성공했을 경우 
%>
	<script>
		alert("수정이 완료되었습니다."); <%-- 성공 메시지 출력 --%>
		window.location="userInfo.jsp"; <%-- 회원 정보(userInfo.jsp)으로 이동 --%>
	</script>
<%
	} else {
%>
    <script>
        alert("수정에 실패했습니다."); <%-- 실패 메시지 출력 --%>
        window.location="userInfo.jsp"; <%-- 실패 시 회원 정보(userInfo.jsp)으로 이동 --%>
    </script>
<%
	}
%>
