<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>0321/ex01.jsp</h1>
<%!
/*	선언부
	클래스 영역
		- 변수, 생성자, 메서드
		- jsp 컴파일을 서버가 하기 때문에 생성자 만들 수 없다.
		- 재사용 불가 = 상속 불가 = 접근제어자가 필요 없음
		 그렇기 때문에 클래스부분이 필요 없다.
*/
	int a = 100;
	static int x = 200;
%>

<%
	// 인스턴스 메서드 영역
	int z = 500;

	web.test.jsp.Tv t = new web.test.jsp.Tv();
%>
표현문 (jsp에서의 출력문) <br>
<%=a %><br>
<%=x %><br>
<%=z %><br>
<%=t %>
