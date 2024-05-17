<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="business.BusinessDAO"%>
<%@page import="business.BusinessDTO"%>
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
<title>등록 상품 수정</title>
</head>
<body>
<%@ include file="../inc/sellerSession.jsp" %><%-- 세션처리 --%>
<%
// 그 전 페이지에서 pnum 받을수 있게 넘겨줘야함.
	int pnum = Integer.parseInt(request.getParameter("pnum"));
	BusinessDAO dao = BusinessDAO.getInstance();
	BusinessDTO dto = dao.getInfo(mem_num, pnum);
	if(dto.getpName() == null){
%>
		<script>
			alert("잘못된 접근입니다.");
			window.location="myList.jsp";
		</script>
<%	} else{ %>
		 <form action="updatePro.jsp" method="post" enctype="multipart/form-data" onsubmit="return imgCheck()">
		 	글 번호 : <%=dto.getPnum() %> <br>
		 		<input type="hidden" name="pnum" value="<%=pnum %>">
		 	판매자 : <%=sid %> <br>
		 		<input type="hidden" name="mem_num" value="<%=mem_num %>">
		 	등록일자 : <%=dto.getReg() %> <br>
			상품 이름 : <input type="text" name="pName" value="<%=dto.getpName() %>" required> <br>
			조리 방법 : <%=dto.getCook() %> <br>
			조리 방법 변경 :
				<select name="cook" required>
					<option value="<%=dto.getCook() %>" selected>변경 안함(<%=dto.getCook() %>)</option>
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
			<table>
				<tr>
					<td>썸네일 1</td>
					<td><img src="../upload/<%=dto.getThum1() %>"></td>
				</tr>
				<tr>
					<td>썸네일 1 변경 : </td>
					<td> <input type="file" name="thum1" class="inimg" accept=".jpg, .jpeg, .png, .apng, .bmp, .gif, .webp, .avif"></td>
				</tr>
				<tr>
					<td>썸네일 2</td>
					<td><img src="../upload/<%=dto.getThum2() %>"></td>
				</tr>
				<tr>
					<td>썸네일 2 변경 : </td>
					<td> <input type="file" name="thum2" class="inimg" accept=".jpg, .jpeg, .png, .apng, .bmp, .gif, .webp, .avif"></td>
				</tr>
				<tr>
					<td>상세정보</td>
					<td><img src="../upload/<%=dto.getDetail() %>"></td>
				</tr>
				<tr>
					<td>상세정보 변경 : </td>
					<td> <input type="file" name="detail" class="inimg" accept=".jpg, .jpeg, .png, .apng, .bmp, .gif, .webp, .avif"></td>
				</tr>
			</table>
			&nbsp;&nbsp; <font size="0.8em">상세정보는 세로로 긴 이미지 한장으로 만들어서 올려주세요.</font> <br>
			<input type="hidden" name="thum1Org" value="<%=dto.getThum1() %>">
			<input type="hidden" name="thum2Org" value="<%=dto.getThum2() %>">
			<input type="hidden" name="detailOrg" value="<%=dto.getDetail() %>">
			가격 : <input type="number" name="price" value="<%=dto.getPrice() %>" required> <br>
			재고 : <input type="number" name="stock" value="<%=dto.getStock() %>" required> <br>
			제조사 : <input type="text" name="company" value="<%=dto.getCompany() %>" required> <br>
			원산지 : <input type="text" name="country" value="<%=dto.getCountry() %>" required> <br>
			<button type="submit">변경</button>
			<button type="button" onclick="history.back()">취소</button>
		 </form>
<%	} %>

<script>
	const img = document.getElementsByTagName("img");
    for (let x = 0; x < img.length; x++) {
		img.item(x).onclick = function() {
			let pop = window.open(this.src, "_blank", "menubar=no, toolbar=no"); // 이미지 클릭시 팝업으로 열기
			// pop.onclick = function(){pop.close();} 	// 팝업창 클릭시 닫기. 이미지 확대표시 떠서 눌러도 닫아져서 보류.
		};	 
    }
    
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
			if(imgs.value !== undefined && fn[fn.length-1].match(fileFormat) == null){
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