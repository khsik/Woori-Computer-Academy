<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>/board02/writeForm</h1>

<center><b>글쓰기</b></center>
<br />
<form method="post" name="writeform" action="writePro.bo" enctype="multipart/form-data">
	<input type="hidden" name="num" value="${num}">
	<input type="hidden" name="ref" value="${ref}">
	<input type="hidden" name="re_step" value="${re_step}">
	<input type="hidden" name="re_level" value="${re_level}">

<table width="400" border="1" cellspacing="0" cellpadding="0" align="center">
	<tr>
	    <td  width="70" align="center">작성자</td>
		<td  width="330">
			${sessionScope.sid}
			<input type="hidden" name="writer" value="${sessionScope.sid}">
		</td>
	</tr>
	<tr>
	    <td  width="70" align="center" >글제목</td>
	    <td  width="330">
			   <input type="text" size="40" maxlength="50" name="title"
				<c:if test="${num != 0}"> <%-- 답글 --%>
				   value="[답글]"
				</c:if>
			   required>
		</td>
	</tr>
	<tr>
		<td  width="70" align="center" >글내용</td>
		<td  width="330" >
			<textarea name="content" rows="13" cols="40" required></textarea> 
		</td>
	</tr>
	<tr>
	    <td  width="70" align="center" >이미지</td>
	    <td  width="330" >
			<input type="file" name="img"> 
		</td>
	</tr>
	<tr>
	    <td  width="70" align="center" >비밀번호</td>
	    <td  width="330" >
			<input type="password" size="8" maxlength="12" name="passwd"> 
		</td>
	</tr>
	<tr>
		<td colspan=2 align="center"> 
			<input type="submit"	value="글쓰기" >  
			<input type="reset"		value="다시작성">
			<input type="button"	value="글목록" OnClick="window.location='list.bo'">
		</td>
	</tr>
</table>    
</form>      