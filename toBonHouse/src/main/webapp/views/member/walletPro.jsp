<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="member.MemberDTO" %> <%-- MemberDTO 클래스 import --%>
<%@ page import="member.MemberDAO" %> <%-- MemberDAO 클래스 import --%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%> <%-- 필요한 Java 클래스 import --%>
<%@ page import="javax.servlet.http.*"%> <%-- HttpSession 클래스 import --%>

<%-- 지갑 충전 처리 --%>
<%
    // 세션에서 사용자 아이디 가져오기
    String id = (String)session.getAttribute("sid");

    // DAO 및 DTO 생성
    MemberDAO dao = MemberDAO.getInstance(); // MemberDAO 싱글톤 객체 생성
    MemberDTO dto = new MemberDTO(); // MemberDTO 객체 생성

    // 회원 정보 조회
    dto = dao.idInfo(id); // 사용자 아이디로 회원 정보 조회

    // 충전할 금액 파라미터 받아오기
    int amount = Integer.parseInt(request.getParameter("amount")); // 충전할 금액 파라미터를 정수형으로 변환

    // 기존 잔고에 충전할 금액 추가
    int newBalance = dto.getBalance() + amount; // 기존 잔고에 충전할 금액을 더하여 새로운 잔고 계산

    // 새로운 잔고를 DTO에 설정
    dto.setBalance(newBalance); // 새로운 잔고를 DTO에 설정

    // 잔고 업데이트
    int result = dao.updateBalance(dto); // 잔고를 업데이트하고 그 결과를 받음

    // 업데이트 결과에 따라 처리
	if( result==1 ){ %> <%-- 업데이트가 성공한 경우 --%>
		<script>
			alert("충전 완료"); <%-- 충전 완료 메시지 출력 --%>
			window.location="walletForm.jsp"; <%-- 충전 완료 후 지갑 페이지로 이동 --%>
		</script>
<%}else{%> <%-- 업데이트가 실패한 경우 --%>
	<script>
			alert("충전 실패"); <%-- 충전 실패 메시지 출력 --%>
			window.location="walletForm.jsp"; <%-- 충전 실패 후 지갑 페이지로 이동 --%>
	</script>
<%	} %> <%-- 결과에 따른 처리 종료 --%>
