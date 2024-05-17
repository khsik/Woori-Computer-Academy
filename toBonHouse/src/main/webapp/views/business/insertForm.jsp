<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	body {width:800px; margin:20px auto; text-align:center;}
	img {width:150px; height:150px;}
	table{margin:0 auto;}
	td{padding:2px;}
	button{margin-top:5px;}
</style>
<meta charset="UTF-8">
<title>상품 등록</title>
</head>
<body>
<%@ include file="../inc/sellerSession.jsp" %><%-- 세션처리 --%>
 <form action="insertPro.jsp" method="post" enctype="multipart/form-data" onsubmit="return imgCheck()">
 	<input type="hidden" name="mem_num" value="<%=mem_num %>">
	상품 이름 : <input type="text" name="pName" required> <br>
	조리 방법 :
		<select name="cook" required>
			<option value="비조리">비조리</option>
			<option value="끓이기">끓이기</option>
			<option value="굽기">굽기</option>
			<option value="에어프라이">에어프라이</option>
			<%--
			<option value="삶기">삶기</option>
			<option value="튀기기">튀기기</option>
			<option value="전자레인지">전자레인지</option>
			<option value="기타">기타</option>
			--%>
		</select> <br>
	썸네일 1 : <input type="file" name="thum1" class="inimg" accept=".jpg, .jpeg, .png, .apng, .bmp, .gif, .webp, .avif" required> <br>
	썸네일 2 : <input type="file" name="thum2" class="inimg" accept=".jpg, .jpeg, .png, .apng, .bmp, .gif, .webp, .avif" required> <br>
	가격 : <input type="number" name="price" required> <br>
	재고 : <input type="number" name="stock" required> <br>
	상세정보 : <input type="file" name="detail" class="inimg" accept=".jpg, .jpeg, .png, .apng, .bmp, .gif, .webp, .avif" required> <br>
	&nbsp;&nbsp; <font size="0.8em">상세정보는 세로로 긴 이미지 한장으로 만들어서 올려주세요.</font> <br>
	제조사 : <input type="text" name="company" required> <br>
	원산지 : <input type="text" name="country" required> <br>
	<button type="submit">등록</button>
	<button type="button" onclick="history.back()">취소</button>
 </form>
 <script>
 	// 엔터키 방지. keyCode 13 = 엔터
	 document.addEventListener('keydown', function(event) {
		  if (event.keyCode === 13) {
		    event.preventDefault();
		  }
		}, true);
	 
 	// 이미지 확장자, 크기 검사
	const imgs = document.querySelectorAll(".inimg");
 	const fileFormat = /(jpg|jpeg|png|apng|bmp|gif|webp|avif)/;	// 가능한 이미지 확장자
 	const maxSize = 10*1024*1024;	// 최대 크기
	function imgCheck(){
		for(let i=0; i<imgs.length; i++){
			let fn = imgs[i].value.split(".");
			if(fn[fn.length-1].match(fileFormat) == null){
				alert("이미지 파일만 업로드 가능합니다.");
				return false;
			}
			if(imgs[i].files[0].size > maxSize){
				alert("10mb 이하의 크기만 업로드 가능합니다.");
				return false;
			}
		}
	 }
 </script>
</body>
</html>