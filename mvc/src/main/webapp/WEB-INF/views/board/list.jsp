<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h1>/board/list.jsp</h1>

<center>
<b>글목록(전체 글:${count})</b>
<table width="700">
	<tr>
	    <td align="right" >
	    	<a href="../member/main.me">메인</a>
	    	<a href="myList.bo">내글목록</a>
	    	<a href="writeForm.bo">글쓰기</a>
	    </td>
	</tr>
</table>

<c:if test="${count == 0}">
<table width="700" border="1" cellpadding="0" cellspacing="0">
	<tr>
	    <td align="center">
	    	<h1>게시판에 저장된 글이 없습니다.</h1>
	    </td>
	</tr>
</table>
</c:if>

<c:if test="${count > 0}">
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center"> 
	<tr height="30" > 
		<td align="center"  width="50"  >글번호</td> 
		<td align="center"  width="250" >글제목</td> 
		<td align="center"  width="100" >작성자</td>
		<td align="center"  width="150" >작성일</td> 
		<td align="center"  width="50" >조회수</td>  
	</tr>
	
	<c:forEach var="dto" items="${list}">
	<tr height="30">
		<td align="center"  width="50" >
			${dto.num}
		</td>
		<td width="250" >
			<c:if test="${dto.re_level > 0}">
				<img src="../resources/images/level.gif" width="${15*dto.re_level}" height="16">
				<img src="../resources/images/re.gif">
			</c:if>
			<c:if test="${dto.re_level == 0}">
				<img src="../resources/images/level.gif" width="${15*dto.re_level}" height="16">
			</c:if>
		    <a href="content.bo?num=${dto.num}&pageNum=${currentPage}">
				${dto.title }
			</a> 
			<c:if test="${dto.readCount >= 20}">
			<%--
				<img src="<c:url value='/images/hot.gif'/>" border="0"  height="16">
			--%>
				<img src="../resources/images/hot.gif" border="0"  height="16">
				<%--
					c:url 하면 main/webapp 이하의 경로 사용됨.
					src에 직접 주소 쓰면 jsp 파일 경로는 WEB-INF/views/board/list.jsp 지만
					mvc패턴으로 구현해서 브라우저에서 접근한 주소는 /mvc/board/list.bo 임.
					그래서 상대경로를 쓸 때, jsp 파일 위치가 기준이 아닌 위의 경로를 기준으로 삼으니까 나옴.
					혹은 contextPath 사용?
				--%>
			</c:if>
		</td>
		<td align="center"  width="100"> 
	       	${dto.writer }
		</td>
		<td align="center"  width="150">
			${dto.reg }
		</td>
		<td align="center"  width="50">
			${dto.readCount }
		</td>
	</tr>
	</c:forEach>
</table>
</c:if>

<c:if test="${count > 0}">
	<c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
	<c:set var="pageBlock" value="10" />
	<fmt:parseNumber var="result" value="${((currentPage-1)/10)+1}" integerOnly="true"/>
	<c:set var="startPage" value="${result}" />
	<c:set var="endPage" value="${startPage + pageBlock-1}" />
	<c:if test="${endPage > pageCount}">
		<c:set var="endPage" value="${pageCount}" />
	</c:if>
	
	<c:if test="${startPage > 10}">
        <a href="list.bo?pageNum=${startPage-10}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
        <a href="list.bo?pageNum=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${endPage < pageCount}">
        <a href="list.bo?pageNum=${startPage + 10}">[다음]</a>
	</c:if>
</c:if>
</center>
