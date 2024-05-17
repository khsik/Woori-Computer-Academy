<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	#cbox {
		width: 600px;
		margin: 0 auto;
		line-height:1.6;
	}
	#pwCheckR, #idR {
		color:red;
		display:none;
	}
	#pwCheckB, #idB {
		color:blue;
		display:none;
	}
	#btn {
		display:none;
	}
	#ann {
		color:darkgray;
		margin-left:5px;
	}
</style>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<div id="cbox">
<h2>회원가입</h2>
 <form action="newUserInsert.jsp" method="post" onsubmit="return pwcheck2()">
	아이디 : <input type="text" name="id" id="id" required onchange="changeID()" pattern="^[a-zA-Z0-9]{4,16}">
		<button type="button" onclick="idCheck()" id="idbtn">중복확인</button>
		<span id="idR">이미 존재하는 아이디입니다.</span>
		<span id="idB">사용가능한 아이디입니다.</span> <br>
		<span id="ann">아이디는 4글자 ~ 16글자 사이의 영문자와 숫자로만 이루어져야 합니다.</span> <br>
	비밀번호 : <input type="password" name="pw" id="pw" required onchange="pwcheck()"> <br>
	비밀번호확인 : <input type="password" id="pw2" required onchange="pwcheck()">
		<span id="pwCheckR">비밀번호가 일치하지 않습니다.</span>
		<span id="pwCheckB">비밀번호가 일치합니다.</span> <br>
	이름 : <input type="text" name="name" required><br>
	이메일 : <input type="email" name="email"> <br>
	통신사 : <select name="phoneC" required>
		<option value="SKT">SKT</option>
		<option value="KT">KT</option>
		<option value="U+">U+</option>
		<option value="MVNO">알뜰폰</option>
	</select> <br>
	전화번호 : <input type="tel" name="phoneNum" required placeholder="01012345678" pattern="^[0-9]{6,20}"><br>
	<div>
		<input id="btn" type="submit" value="회원가입">
		<button id="nobtn" onclick="alertID()">회원가입</button>
	</div>
 </form>
</div>
 <script>
 	function pwcheck(){
	 	var pw1 = document.getElementById("pw").value;
	 	var pw2 = document.getElementById("pw2").value;
 		if(pw1 == pw2){
 			document.getElementById("pwCheckR").style.display = "none";
 			document.getElementById("pwCheckB").style.display = "inline";
 		}else{
 			document.getElementById("pwCheckR").style.display = "inline";
 			document.getElementById("pwCheckB").style.display = "none";
 		}
 	}
 	
 	function changeID(){
 		document.getElementById("idR").style.display = "none";
 		document.getElementById("idB").style.display = "none";
 		document.getElementById("btn").style.display = "none";
 		document.getElementById("nobtn").style.display = "block";
 	}
 	
 	function idCheck(){
 		var id = document.getElementById("id").value;
		open("idCheck.jsp?id="+id,'width=0, height=0');
 	}
 	
 	function alertID(){
 		alert("id 중복 확인이 필요합니다.");
 	}
 	function pwcheck2(){
 		var pw1 = document.getElementById("pw").value;
	 	var pw2 = document.getElementById("pw2").value;
 		if(pw1 == pw2){return true;}
 		else{
 			alert("비밀번호를 확인해주세요.");
 			return false;
 		}
 	}
 </script>
</body>
</html>