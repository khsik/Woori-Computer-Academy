<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%-- 페이지에 푸터 넣으면 top 버튼 생김 --%>
<style>
	#foot {
		text-align:left;
		margin-left:170px;
		padding:5px 60px 5px 10px;
	<%--	background:#dde; --%>
	}
	#btn_top{
		display:none;
		position:fixed;
		bottom:30px;
		right:30px;
		z-index:999;
		cursor:pointer;
		text-align:center;
		line-height:0.9;
		width:20px;
		height:20px;
		font-size:20px;
		font-weight:700;
		padding:3px;
		/*background:rgba(240,240,240,0.6);*/
		border:1px solid darkgray;
		border-radius:100%;
	}
	#btn_top:hover{background:#bbb;}
</style>
<meta charset="UTF-8">
<title>Footer</title>
</head>
<body>
<span id="btn_top" onclick="go_top()">↑</span>
<script>
	// 페이지 맨위로. 부드럽게.
	function go_top(){
		window.scroll({top:0 , behavior:"smooth"});
	}
	
	// top버튼 표현 전환(block, none)
	const btn_top = document.getElementById("btn_top");
	document.addEventListener("scroll", (event =>{
		let vh = window.innerHeight * 0.7;	// 창 크기 * 0.7
		if(window.scrollY > vh){	// vh 이상 스크롤하면 버튼 보임
			btn_top.style.display="block";
		}else{
			btn_top.style.display="none";
		}
	}))
</script>
<div id="foot">
이용 약관<br>
사업자 등록 번호 <br>
연락처 010-0000-0000 <br>
대량구매 문의 email@email.com <br>
</div>
</body>
</html>