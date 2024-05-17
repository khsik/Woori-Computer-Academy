<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
    .button {
        padding: 10px 20px;
        font-size: 16px;
    }
</style>

<center>
<h1>member/main</h1>
<%-- 메인 페이지 --%>
<% 
    // 세션에서 사용자 이름 가져오기
    String sid = (String)session.getAttribute("sid"); 
    
    // 사용자 이름이 null이면(로그인되어 있지 않으면)
    if(sid == null){
%>
<br />
<input type="button" value="회원가입" onclick="window.location='insertType.jsp'" class="button" /> <%-- 회원가입 버튼 --%>
<input type="button" value="로그인" onclick="window.location='loginForm.jsp'" class="button" style="padding: 10px 20px; font-size: 16px; background-color: blue; color: white;" /> <%-- 로그인 버튼 --%>
<% } else { %>
    <h2>[<%=sid %>] 님 환영합니다 ^^7 </h2> <%-- 사용자 이름 출력 --%>
    <input type="button" value="마이페이지"
        onclick="window.location='myPage.jsp'" /> <%-- 마이페이지로 이동하는 버튼 --%>
    <input type="button" value="개인 정보 수정"
        onclick="window.location='updateForm.jsp'" /> <%-- 개인 정보 수정 페이지로 이동하는 버튼 --%>
    <input type="button" value="로그아웃"
        onclick="confirmLogout()" /> <%-- 로그아웃 버튼 --%>
    <input type="button" value="회원 탈퇴"
        onclick="window.location='deleteForm.jsp'" /> <%-- 회원 탈퇴 페이지로 이동하는 버튼 --%>
    <input type="button" value="리뷰 게시판(임시)"
        onclick="window.location='list.jsp'" /> <%-- 임시 리뷰 게시판으로 이동하는 버튼 --%>
	<input type="button" value="상품 보기"
		onclick="window.location='../products/list.jsp'"/>	<%-- 상품 페이지으로 이동하는 버튼  --%>
	<input type="button" value="상품 추가"
		onclick="window.location='../business/myList.jsp'"/>	<%-- 상품 페이지으로 이동하는 버튼  --%>
    <script>
        function confirmLogout() {
            if (confirm("로그아웃 하시겠습니까?")) {
                window.location = 'logout.jsp'; <%-- 로그아웃 페이지로 이동 --%>
                alert("로그아웃되었습니다"); // 로그아웃되었음을 알리는 경고창 표시
            }
        }
    </script>
<% } %>
</center>
