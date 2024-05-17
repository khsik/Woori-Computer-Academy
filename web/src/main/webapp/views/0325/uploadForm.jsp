<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>/0325/uploadForm.jsp</h1>

<%--
	form 태그 설정시
	전송방식 : post, get 은 URL만 보낼 수 있음.
	enctype : multipart/form-data : multipart는 모든 데이터 타입 가능.
	
	문자가 아니기 때문에 request.getParameter(), <jsp:useBean ...> 으로 받지 못함.
	외부 라이브러리 필요
	http://servlets.com/cos/
		- cos-22.05.zip 다운
		- cos : WEB-INF/lib 폴더에 넣음
--%>

<form action="uploadPro.jsp" method="post" enctype="multipart/form-data">
	name : <input type="text" name="name"><br>
	file : <input type="file" name="save"><br>
	<button type="submit">업로드</button>
</form>