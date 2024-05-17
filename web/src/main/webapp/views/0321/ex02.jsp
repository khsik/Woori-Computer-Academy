<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>ex02.jsp</h2>
<%--
	JSP 페이지에 대한 정보를 페이지 디렉티브 속성들을 사용하여 정의.
	
	info =""
		: 간단한 정보. 화면에 나오지 않음.
	language =""
		: 속성 생략 가능. 기본값 "java", java만 지원하기 때문에 안써도 된다.
	pageEncoding =""
		: 인코딩 정보
	contentType=""
		: 현제 JSP 페이지의 내용이 어떤 타입의 문서로 생성되는지 지정하는 속성
		 여러 형태의 문서를 생성할 수 있음
		기본값 text/html - 응답결과를 html 문서 형식으로 생성하고 출력하겠다.
	extends=""
		: 상속받을 클래스 풀네임
		: 쓰이지 않음.
	import=""
		: java의 import와 같음
		: 이 속성은 유일하게 한 페이지 내에서 여러개 사용 가능
	buffer="8kb"
		: 현제 페이지에서 한번에 출력될 수 있는 양
		: 버퍼 - 입출력 데이터 등의 정보를 전달할 때 사용되는 임시저장소
				한 장소에서 다른 장소로 데이터를 송신할 때 일어나는
				시간의 차이나 데이터 흐름 속도 차이를 맞추기 위해 사용
		: 기본값 8kb
			none - 사용하지 않겠다는 의미
				-> 바로 웹브라우저로 출력
		: 더 많은 내용 출력할 때 크기를 늘려주면 된다.
	autoFlush="true"
		: JSP 페이지의 내용들이 웹브라우저에 출력되기 전 출력 버퍼가 다 찰 경우
		 buffer의 양을 자동으로 늘리겠다 = "true"
	errorPage=""
		: 에러가 났을 때 보여줄 페이지 지정
	isErrorPage="false"
		: errorPage에 설정
		 true 예외 처리 자동으로 처리
		: web.xml 파일에서 <error-page>로 처리하도록 되어있어 현재 안쓰이는 기능
	isThreadSafe="true"
		: 멀티 스레드(여러 브라우저에서 동시에 실행) 사용 여부
		: false - 다수의 사용자들의 요청을 동시에 처리하지
				 못하고 순차적으로 처리하기 때문에 진행 시간이 많이 소요된다.
	isELIgnored="false"
		: EL(표현 언어)식 출력에 관한 것. 반드시 사용함.
	deferredSyntaxAllowedAsLiteral="false"
		: 표현식에 관한 것. EL과 같이 사용됨
	trimDirectiveWhitespaces="false"
		: 공백 제공. 큰 차이 없는 기능.
--%>