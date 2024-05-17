<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>member/logout</h1>
<%-- 로그아웃 처리 --%>
<%
	// 쿠키 삭제
	Cookie[] cookies = request.getCookies(); // 현재 요청에서 전송된 모든 쿠키를 가져옴
	for( Cookie c : cookies ){
		if( c.getName().equals("cid") // 아이디 쿠키
			|| c.getName().equals("cpw") // 비밀번호 쿠키
			|| c.getName().equals("cauto") ) // 자동 로그인 여부 쿠키
		{
			c.setPath("/toBonHouse/views");
			c.setMaxAge(0); // 쿠키의 유효 시간을 0으로 설정하여 삭제
			response.addCookie(c); // 삭제된 쿠키를 응답에 추가하여 클라이언트에게 전송
		}
	}
	
	// 세션 삭제
	session.invalidate(); // 현재 세션을 무효화하여 세션 속성을 모두 삭제하고 새로운 세션을 생성
%>
	<script>
		alert("로그아웃 되었습니다.");
		window.location="../main.jsp";// 로그아웃 후 메인 페이지로 리다이렉트
	</script>
