<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h1>member/loginPro.jsp</h1>

<%@ page import="member.MemberDAO" %>
<%@ page import="member.MemberDTO" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%-- 로그인 처리 --%>
<%
    // MemberDAO와 MemberDTO 객체 생성
    MemberDAO dao = MemberDAO.getInstance();
    
    // MemberDTO 객체 생성
    MemberDTO dto = new MemberDTO();

    // 사용자로부터 받은 아이디와 비밀번호 설정
    dto.setId(request.getParameter("id"));
    dto.setPw(request.getParameter("pw"));
    String auto = request.getParameter("auto");
   
    
    // 로그인 확인
    int result = dao.loginCheck(dto); // 0 로그인실패, 1 탈퇴유예기간(로그인x), 2 로그인성공
    if(result == 1){	// 탈퇴유예기간
    	response.sendRedirect("resign.jsp");
    }else if (result == 2) {	// 로그인 성공
        // 로그인 성공 시 세션 설정
        session.setAttribute("sid", dto.getId()); // 세션 이름을 "sid"에서 "id"로 변경
        int[] mg = dao.getMG(dto.getId());
        session.setAttribute("mem_num", mg[0]);
        session.setAttribute("grade", mg[1]);
        
        // 데이터베이스에서 사용자의 이름 가져오기
//        String userName = dao.getName(dto.getId());
//        if (userName != null && !userName.isEmpty()) {
//            session.setAttribute("sname", userName);
//        }
        
		// 자동 로그인 처리
		if( auto != null && auto.equals("1") ){
			// 쿠키 생성
			Cookie coo1 = new Cookie("cid", dto.getId());
			Cookie coo2 = new Cookie("cpw", dto.getPw());
			Cookie coo3 = new Cookie("cauto", auto);
			
			// 쿠키 유효시간 설정 (2일)
			coo1.setMaxAge(60*60*24*2);
			coo2.setMaxAge(60*60*24*2);
			coo3.setMaxAge(60*60*24*2);

			// 쿠키 경로 설정
			coo1.setPath("/toBonHouse/views");
			coo2.setPath("/toBonHouse/views");
			coo3.setPath("/toBonHouse/views");
			
			// 쿠키 추가
			response.addCookie(coo1);
			response.addCookie(coo2);
			response.addCookie(coo3);
		}
	
		// 자동 로그인 처리 결과가 null이면 쿠키 생성 없이 세션 생성됨
		
        // 로그인 성공 시 이동할 페이지로 리다이렉트
        response.sendRedirect("../main.jsp");
    } else {
%>
    <script>
        alert("아이디/비밀번호를 확인해주세요.");
        history.go(-1);
    </script>
<%
    }
%>
