<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 세션처리 
	String sid = (String)session.getAttribute("sid");
	int mem_num = 0;
	int grade = 0;
	if(sid != null){
		mem_num = (Integer)session.getAttribute("mem_num");
		grade = (Integer)session.getAttribute("grade");
	}
%>