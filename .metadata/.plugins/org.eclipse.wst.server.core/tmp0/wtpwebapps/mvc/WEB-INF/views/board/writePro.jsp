<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>/board02/writePro.jsp</h1>

<c:if test="${result == 1}">
	<script>
		alert("글이 등록 되었습니다.");
		window.location="list.bo";
	</script>
</c:if>