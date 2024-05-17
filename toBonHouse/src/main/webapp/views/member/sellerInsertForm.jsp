<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 판매자 회원가입 폼 --%>
<%@ include file="../inc/session.jsp" %>
<%
    if (sid != null) {
        // 이미 로그인된 상태이므로 메인 페이지로 리다이렉트
        response.sendRedirect("../main.jsp");
    }
%>

<jsp:include page="../inc/header.jsp"/>
<head>
    <title>판매자 회원가입 폼</title>
 <style>
 	* { margin:0; padding:0; }
    #con{
		padding-left:170px;
		padding-bottom:10px;
		padding-top:10vh;
		min-height:90vh;
		width:max-content;
		margin:0 auto;
		text-align:center;
	}
	#con h1{margin-bottom:15px;}
 </style>    
</head>

<body>

<script>
        // 유효성 검사를 위한 JavaScript 함수 정의
        function memCheck() {
            var userInput = document.userInput;
            var pw = userInput.pw.value;
            var pw2 = userInput.pw2.value;
            var name = userInput.name.value;
            var tel = userInput.tel.value;
            var grade = userInput.grade.value;

            // 각 입력 필드의 값을 확인하고 필요한 경우 경고 메시지를 표시
            if (!userInput.id.value) {
                alert("아이디를 입력해주세요.");
                userInput.id.focus();
                return false;
            }
            if (!pw) {
                alert("비밀번호를 입력해주세요.");
                userInput.pw.focus();
                return false;
            }
            if (pw !== pw2) {
                alert("입력한 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
                userInput.pw2.focus();
                return false;
            }
            if (!name) {
                alert("이름을 입력해주세요.");
                userInput.name.focus();
                return false;
            }
            if (!tel) {
                alert("전화번호를 입력해주세요.");
                userInput.tel.focus();
                return false;
            }
            if (!grade) {
                alert("등급을 입력해주세요.");
                userInput.grade.focus();
                return false;
            }
            if (!userInput.address.value) {
                alert("주소를 입력해주세요.");
                userInput.address.focus();
                return false;
            }
            return true;
        }

        // 아이디 중복 확인을 위한 함수
        function idCheck() {
            var id = document.getElementById("id").value;
            // 중복 확인 기능을 구현한 페이지의 경로를 설정합니다.
            open("confirmId.jsp?id=" + id, 'confirm', 'width=400,height=400');
        }
        // 입력값이 영어와 숫자로만 구성되는지 확인하는 함수
        function checkInput(input) {
            var inputValue = input.value;
            var errorMessage = document.getElementById("errorMessage");
            if (!/^[A-Za-z0-9]*$/.test(inputValue)) { // 영어, 숫자 유효성 검사
                errorMessage.textContent = "영어와 숫자로만 입력 가능합니다.";
            } else {
                errorMessage.textContent = "";
            }
        }

        // 페이지 로드시 아이디 입력 필드에 포커스 주기
        window.onload = function() {
            document.getElementById("id").focus();
        };
        
</script>

<div id="con">
    <h1>판매자회원가입</h1> <%-- 제목 --%>
    
        <!-- 회원가입 양식 -->
    <form action="insertPro.jsp" name="userInput" method="post" onsubmit="return memCheck()">
        <!-- 아이디 입력 -->
        아이디: <input type="text" name="id" id="id" pattern="[A-Za-z0-9]+" oninput="checkInput(this)"/>
        <input type="button" value="중복확인" onclick="idCheck();" /><br />
        <!-- 아이디 중복 확인 결과를 표시할 요소 -->
        <span id="idResult"></span>
        
        <div id="errorMessage" style="color: red;"></div><br /> <!-- 에러 메시지를 표시할 영역 -->
        
        <!-- 비밀번호 입력 -->
        비밀번호: <input type="password" name="pw" /><br />
        비밀번호 확인: <input type="password" name="pw2" /><br /><br />
        
        <!-- 기본 정보 입력 -->
        이름: <input type="text" name="name" /><br />
        통신사:
        <select name="tel_com">
            <option value="U+">U+</option>
            <option value="KT">KT</option>
            <option value="SKT">SKT</option>
            <option value="알뜰폰">알뜰폰</option>
        </select><br />
        전화번호: <input type="text" name="tel" /><br />
        이메일: <input type="email" name="email" /><br />
        주소: <input type="text" name="address" /><br />
        
        <!-- 기타 숨겨진 입력 -->
        <input type="hidden" name="grade" value="2" /> <!-- 기본 회원 등급 설정 -->
        
        <!-- 회원가입 제출 버튼 -->
        <input type="submit" value="회원가입" />
	</form>
</div>
<jsp:include page="../inc/footer.jsp"/>
</body>
</html>