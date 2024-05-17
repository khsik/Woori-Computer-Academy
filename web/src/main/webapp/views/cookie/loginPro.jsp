<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>cookie/loginPro</h1>

<jsp:useBean id="dao" class="web.test.bean.MemberDAO"/>
<jsp:useBean id="dto" class="web.test.bean.MemberDTO"/>
<jsp:setProperty name="dto" property="*"/>

<%
	// 쿠키 먼저 확인
	Cookie[] cookies = request.getCookies();
	for(Cookie c : cookies){
		if(c.getName().equals("cid")){
			dto.setId(c.getValue());
		}
		if(c.getName().equals("cpw")){dto.setPw(c.getValue());}
		if(c.getName().equals("cauto")){dto.setAuto(c.getValue());}		
	}

	// DB에서 확인
	boolean result = dao.loginCheck(dto);
	if(result == true){ // id, pw 일치
		// 자동 로그인 확인
		if(dto.getAuto() != null && dto.getAuto().equals("1")){
			// 쿠키생성
			Cookie coo1 = new Cookie("cid",dto.getId());
			Cookie coo2 = new Cookie("cpw",dto.getPw());
			Cookie coo3 = new Cookie("cauto",dto.getAuto());

			// 쿠키 유효시간 설정 (생성 or 갱신)
			coo1.setMaxAge(172800); // 60*60*24*2
			coo2.setMaxAge(172800);
			coo3.setMaxAge(172800);
			
			// 쿠키 추가
			response.addCookie(coo1);
			response.addCookie(coo2);
			response.addCookie(coo3);
		}

		// 자동로그인 x면 쿠키 없이 세션만 생성
		session.setAttribute("sid", dto.getId());
		response.sendRedirect("main.jsp");
	}else{ // id, pw 불일치
%>
		<script>
			alert("id와 pw를 확인하세요.");
			// history.go(-1);
			window.location="loginForm.jsp";
		</script>
<%	}%>