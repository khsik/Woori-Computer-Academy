<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="business.OrderDAO" %>
<%@ page import="business.OrderDTO" %>
<!DOCTYPE html>
<html>
<head>
<style>
	body{max-width:1320px; margin:0 auto;}
	h2, h4 {text-align:center;}
	button[type="submit"] {margin-top:3px;}
	#orders {
		display:flex;
		flex-direction:row;
		flex-wrap:wrap;
		margin:0 auto;
		min-width:800px;
	}
	.order {
		border:1px solid black;
		margin:7px 3px;
		padding:3px;
		width:250px;
		height:max-content;
	}
	.btcenter {display:block; text-align:right; border-top:2px dotted darkgray;}
	.btcenter:has(.bnum:disabled) {display:none;}
</style>
<meta charset="UTF-8">
<title>상세 주문 목록</title>
</head>
<body>
<%@ include file="../inc/sellerSession.jsp" %><%-- 세션처리 --%>
<%
	String pnum = request.getParameter("pnum");
	// pnum == null 이면 전체 상세목록. 아니면 pnum 제품 상세목록
	OrderDAO dao = OrderDAO.getInstance();
	ArrayList<OrderDTO> list = dao.orderListDetail(mem_num, pnum);
	if(list.size()==0){
%>		<h2>주문이 없습니다.</h2>
<%-- 0이면 사실 잘못된 접근이라 볼 수 있음 -> script로 예외처리 --%>
<%	}else{ %>
	<h2>상세 주문 목록</h2>
	<h4>배송 필요한 주문 : <span id="count"></span> 건</h4>
	상태 : 
	<label for="결제완료">결제 완료</label> <input type="checkbox" id="결제완료" onclick="option('결제완료')" checked>
	<label for="배송">배송</label> <input type="checkbox" id="배송" onclick="option('배송')" checked>

	<form action="orderStatusUpdate.jsp" method="post" onsubmit="return nocheck()">
	<button type="submit"><b><i>배송 처리</i></b></button>
	<button type="button" id="allbtn"><b>전체 선택</b></button>
	<button type="button" id="resetbtn"><b>선택 취소</b></button>
	<button type="button" onclick="location.href='orderList.jsp'">주문 목록</button>
	<button type="button" onclick="location.href='sellerMain.jsp'">판매자 메인</button>
	<div id="orders">
	<%-- bnum(주문번호) 기준 오름차순 --%>
<%		for(OrderDTO dto : list){ %>
		<div class="order <%=dto.getStatus()%>">
			주문번호 : <%=dto.getBnum() %> <br>
			상품번호 : <%=dto.getPnum() %> <br>
			구매자(회원번호) : <%=dto.getMem_num() %> <br>
			주문수량 : <%=dto.getAmount() %> <br>
			결제금액 : <%=dto.getTotalPrice() %> <br>
			주문일자 : <%=dto.getOrderReg() %> <br>
			배송지 : <%=dto.getRec_addr() %> <br>
			상태 : <%=dto.getStatus() %> <br>
				<% if(dto.getStatus().equals("결제완료")){ // 결제완료만 체크박스, pnum(hidden) 생성.%>
					<span class="btcenter">
						<label for="<%=dto.getBnum()%>_<%=dto.getPnum()%>">배송</label>
						<input type="checkbox" name="bnum" class="bnum" id="<%=dto.getBnum()%>_<%=dto.getPnum()%>" value="<%=dto.getBnum()%>" onclick="toggleHiddenInput(this)">
						<input type="hidden" name="pnum" class="pnum" id="hd_<%=dto.getBnum()%>_<%=dto.getPnum()%>" value="<%=dto.getPnum() %>" disabled>
							<%-- 체크박스 체크하면 disalbed 바꾸기 --%>
					</span>
				<%}%>
		</div>
<%		} %>
	</div>
	</form>
<%	} %>
<script>
	const checklist = document.querySelectorAll(".bnum");
	const pnumlist = document.querySelectorAll(".pnum");
	const orderlist = document.querySelectorAll(".order");
	const listcount = document.getElementById("count");
	
	// 체크박스 따라서 pnum 활성/비활성
	function toggleHiddenInput(checkbox) {
		  let hiddenInput = document.getElementById("hd_"+checkbox.id);
		  hiddenInput.disabled = !checkbox.checked;
	}
	
	function ordercount(){
		let count = 0;
		for(let i=0; i<checklist.length; i++){
			if(!checklist[i].disabled){
				count++;
			}
		}
		return count;
	}
	listcount.innerText = ordercount();	// 배송 필요한 주문 : n 건  에서 n
	
	function nocheck(){	// 1개라도 체크해야 submit 가능
		for(let i=0; i<checklist.length; i++){
			if(checklist[i].checked){	// 체크된게 있다면
				return true;
			}
		}
		alert("선택된 주문이 없습니다.");
		return false;	// 체크된게 하나도 없으면
	}
	
	function option(status){	// 체크된 옵션에 맞춰 출력, 숨김
		let list = document.querySelectorAll(".order."+status);	// .order 클래스이면서 .status 클래스인거 선택
		for(let i=0; i<list.length; i++){
			if(document.getElementById(status).checked){	// 체크되있으면 보임
				list[i].style.display="block";
			}else{
				list[i].style.display="none";
			}
		}
	}
	
	// 전체선택
	const allbtn = document.getElementById("allbtn");
	allbtn.onclick = function(){
		for(let i=0; i<checklist.length; i++){
			checklist[i].checked = true;
			pnumlist[i].disabled = false;
		}
	}
	
	// 전체 선택 취소
	const resetbtn = document.getElementById("resetbtn");
	resetbtn.onclick = function(){
		for(let i=0; i<checklist.length; i++){
			checklist[i].checked = false;
			pnumlist[i].disabled = true;
		}
	}
	
	
</script>

<%--
	form태그 안쓰고 button onclick으로 구현할 때. 변수를 get방식으로 넘기는거로 표현.
<script>
	const checklist = document.querySelectorAll(".bnum");	// 체크박스 배열
	function check_submit(){
		let check_value = [];	// 배열 선언
		for(let i=0; i<checklist.length; i++){
			if(checklist[i].checked){	// 체크되있으면
				check_value.push(checklist[i].value);	// 배열에 값 저장
			}
		}
		if(check_value.length == 0){
			alert("선택된 주문이 없습니다.");
		}else{
			window.location="orderStatusUpdate.jsp?bnums="+check_value;
		}
	}
</script>
--%>
</body>
</html>