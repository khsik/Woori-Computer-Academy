<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>scope.jsp</h1>
<%
	// 서버 실행(켜져있는) 상태에서 어디서든 사용 가능.
	// 서버에 저장되기 때문에 어디서든(페이지 달라도) 꺼낼 수 있다.
	application.setAttribute("data", "app");
//	application.removeAttribute("data");
	application.setAttribute("id","app_i");

	// 클라이언트의 상태 정보를 서버상에 저장, 기록
	// 해당 브라우저 유지시 어디서든(페이지 달라도) 사용 가능
	// 브라우저를 껐다 키거나, 다른 브라우저에서 사용 못함.
	session.setAttribute("sdata", "session");
//	session.removeAttribute("sdata");
	session.setAttribute("sid", "sesison_i");
	
	// 해당 페이지, 포워드로 전달받은 페이지에서만 사용 가능
	request.setAttribute("rdata", "request");
//	request.removeAttribute("rdata");
	request.setAttribute("rid", "request_i");

/*
	request.getRequestDispatcher("/views/0320/scopeResult.jsp")
	.forward(request, response);
*/
	request.getRequestDispatcher("/views/0325/scopeResult.jsp").forward(request, response);
%>
<h2>attribute 생성</h2>

<%--
	아마도...
	application 서버기준
	session 클라이언트(브라우저)기준
	request 페이지기준
--%>