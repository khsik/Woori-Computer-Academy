<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>/test/jstl01</h1>
<button type="button" onclick="window.location='./main.do'">main</button>

<c:set var="id" value="java"></c:set>
<c:set var="pw" value="test"/>
<h3>id : ${id}</h3>
<h3>pw : ${pw}</h3>

<hr color="#ff08ff">
<c:remove var="id"/>
<h3>id : ${id}</h3>


<hr color="#ff08ff">
<c:set var="country" value="korea"/>

<c:if test="${country != null}">
	<h3>country : ${country}</h3>
</c:if>

<c:if test="${country == null}">
	<h3>나라 없음</h3>
</c:if>
<hr>
<c:if test="${country == 'korea'}">
	<h3>한국</h3>
</c:if>

<hr color="#ff08ff">
<c:set var="name" value="java" />
<c:if test="${ name != null}">
	<h3>이름 : ${ name }</h3>
</c:if>

<c:if test="${ name == null }">
	<h3>이름 없음</h3>
</c:if>

<hr color="#ff08ff">
<h3>${ 10+10 }</h3>
<h3>${ "10"+'10'+10 }</h3>
<h3>문자열 연결 못함</h3>

<hr color="#0808ff">
<c:set var="count" value="55"/>
<h3>
<c:choose>
	<c:when test="${ count >= 100 }">100이상</c:when>
	<c:when test="${ count >= 50 }">100미만 50이상</c:when>
	<c:when test="${ count >= 0 }">50미만 0이상</c:when>
</c:choose>
</h3>

<hr color="#0808ff">
<c:forEach var="i" begin="1" end="10" step="1">
	${i}
</c:forEach>
<h3>for(int i=1; i&lt;=10; i++){i}하고 같음</h3>

<hr color="#0808ff">
<c:forTokens var="i" items="aa,bb,cc,dd,ee" delims=",">
	<h4>${i}</h4>
</c:forTokens>

<hr color="#0808ff">
${d1} <br>
${d1.num} <br>
${d1.name} <br>
<br>
${d2} <br>
${d2.getNum()} <br>
${d2.name}

<hr color="#08ffff">
<%-- 아마도 d1, d2 주소를 String 배열처럼 쓴거같음 --%>
<c:forEach var="dto" items="${d1}, ${d2}" >
	${dto} <br>
</c:forEach>

<hr color="#08ffff">
<c:forEach var="subject" items="${list}" >
	<h3>${subject}</h3>
</c:forEach>



