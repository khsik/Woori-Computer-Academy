<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/adminSession.jsp"%>
<!DOCTYPE html>
<%-- 
			이미지를 넣을껀지 아닌지 생각 해야함. 
			이미지를 넣는다면 수정 해야함 !!! 
			지금 버전은 이미지 안넣고 글만 쓰는 버전임!
	 --%>
<%--
	 		+ 로그인도 아직 안되서 id 의 값을 못받아옴 !! 
	 		이거도 생각해서 나중에 id 값을 입력받는것이 아니라 
	 		세션에서 받아 와야함 !!
	  --%>
<html>
<head>
<meta charset="UTF-8">
<title>글작성 페이지</title>
<style>
* {
	margin: 0px;
	padding: 0px;
}

textarea {
	height: 6.25em;
	border: none;
	resize: none;
	width: 98%;
	height: 98%;
}

table {
	margin: auto;
	width: 800px;
	height: 600px;
}

td {
	border: 1px solid black;
}
.cendiv {
	margin:0 auto;
	padding-left:170px;
	padding-top: 40px;
	width: 800px;
	height: 100vh;
	/*text-align : left; */
}
.left {
	width: 160px;
}

#eventRow {
	display: none;
}
</style>
</head>

<jsp:include page="../inc/header.jsp" />

<body>
	<div class = "cendiv">
		<form action="annWritePro.jsp" method="post"
			enctype="multipart/form-data">
			<%-- <h1>ann_글작성 페이지</h1>--%>
			<table>
				<tr style="height: 40px;">
					<td class="left">제목</td>
					<td><select name="category" id="category"
						onchange="changeCategory()">
							<%-- <option value = "" disabled selected>전체</option>--%>
							<option value="announce" selected>안내</option>
							<option value="event">이벤트</option>
					</select> <input type="text" name="title" placeholder="글제목을 입력해주세요" /> <%-- 지금 당장은 비밀번호가 필요한지 모르겠어서 id 값과 같이 히든으로 넘김. --%>
						<input type="hidden" name="mem_num" value=<%=mem_num%>> <%-- 비밀번호 값을 필요 없다 생각함. > 어차피 관리자가 쓴 글이기에 삭제는 자유롭게 가능하다 생각. --%>
						<input type="hidden" name="ann_Pw" placeholder="비밀번호" value="1234" />

					</td>
				</tr>

				<tr id="announceRow">
					<td class="left">글 내용</td>
					<td><textarea name="ann_Content"></textarea></td>
				</tr>

				<tr id="eventRow">
					<td class="left">이미지</td>
					<td>img : <input type="file" name="ann_Img" />
					</td>
				</tr>
				<tr>
					<td colspan="2"
						style="border: 0px; text-align: right; height: 30px;"><input
						type="submit" value="수정하기" /></td>
				</tr>
			</table>

			<%-- 전체 일경우 글이 써지지 않게 수정해야 함. --%>
		</form>
	</div>
	<script>
		
	<%-- 안내 - 글내용만, 이벤트 - 이미지만 나오게 하는 스크립트 --%>
		function changeCategory() {
			var category = document.getElementById("category").value;
			var announceRow = document.getElementById("announceRow");
			var eventRow = document.getElementById("eventRow");

			if (category === "announce") {
				announceRow.style.display = "table-row";
				eventRow.style.display = "none";
			} else if (category === "event") {
				announceRow.style.display = "none";
				eventRow.style.display = "table-row";
			} else {
				announceRow.style.display = "none";
				eventRow.style.display = "none";
			}
		}
	</script>
</body>
</html>
