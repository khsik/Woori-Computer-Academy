<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dao" class="webP.userpage.bean.UserInfoDAO"/>
<jsp:useBean id="dto" class="webP.userpage.bean.UserInfoDTO"/>
<jsp:setProperty name="dto" property="*"/>
<title>로그인 시도</title>
</head>
<body>
<%
	String auto = null;
	try{auto = request.getParameter("auto");} catch(Exception e){}
	if(dao.login(dto.getId(), dto.getPw())){
		session.setAttribute("sid", dto.getId());
		if(auto != null && auto.equals("auto")){ // cid 쿠키 : 자동로그인 체크해야 생성 
			Cookie c = new Cookie("cid", dto.getId());
			c.setMaxAge(172800); // 쿠키 2일
			response.addCookie(c);
		}
		response.sendRedirect("main.jsp");
	}else{
		Cookie cc = new Cookie("wrong", "wrong");
		cc.setMaxAge(10);
		response.addCookie(cc);
		response.sendRedirect("main.jsp");
	} %>
</body>
</html>