<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>cookie/main</h1>

<%
	// 세션 확인
	String sid = (String)session.getAttribute("sid");

	if(sid==null){ // 세션 없음
		// 쿠키에 사용할 변수 선언
		String cid = null, cpw=null, cauto=null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null){ // 쿠키가 있으면
			for(Cookie c : cookies){ // 쿠키에서 값을 받아옴
				if( c.getName().equals("cid") ){ cid=c.getValue(); }
				if( c.getName().equals("cpw") ){ cpw=c.getValue(); }
				if( c.getName().equals("cauto") ){ cauto=c.getValue(); }
			}
		}
		if(cid != null || cpw != null || cauto != null){ response.sendRedirect("loginPro.jsp"); }
%>
	<button onclick="window.location='../member/insertForm.jsp'">회원가입</button> <%-- '/web/views/member/insertForm.jsp' --%>
	<button onclick="window.location='loginForm.jsp'">로그인</button>
<%	} else{%>
	<h2>[<%=sid %>]님 환영합니다.</h2>
	<button onclick="window.location='../member/allMember.jsp'">전체회원</button>
	<button onclick="window.location='../member/updateForm.jsp'">내정보</button>
	<button onclick="window.location='logout.jsp'">로그아웃</button>
<%	}%>