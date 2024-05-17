<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="products.ProductsDAO"%>
<%@ page import = "java.util.*" %>
<%@ page import = "products.ProductsDTO"%>
<%@ page import = "member.MemberDTO" %>
<%@ page import = "business.BusinessDTO" %>
<% request.setCharacterEncoding("UTF-8");%>
									<%-- 구매 페이지 form--%>
<%@ include file="../inc/session.jsp" %>
<%
    if (sid == null) {
        // 로그인 상태 아님 -> 로그인 페이지로
        response.sendRedirect("../member/loginForm.jsp");
    }
%>
<jsp:include page="../inc/header.jsp"/>
<title>상품 구매</title>
<style>
	* { margin:0; padding:0; }
	#con{
		padding-left:200px;
		padding-right:20px;
		padding-bottom:30px;
		padding-top:20px;
		min-height:calc(100vh - 50px);
		/* width:max-content; */
		margin:0 auto;
		text-align:center;
	}
	#con h1{margin-bottom:15px;}
	#con h2{text-align:left; margin:3px 0;}
	.bbb {padding-bottom:30px;}
	.aaa {padding-top:30px;}
	table, tr {width:100%;}
	.t1{width:300px;}
	.t2{width:30px;}
	.t3{width:30px;}
	.headline1{border-top:1px solid  dotted; border-color: rgba(0, 0, 0, 0.1);}
	.headline2{border-top:3px solid black;}
	img {
		width:110px;
		height:110px;
	}
</style>
<%
		// 장바구니에서 넘어왔는지 체크하는 용도의 변수
		String jang = (String)request.getParameter("jang");

		ProductsDAO dao = ProductsDAO.getInstance();
		request.setCharacterEncoding("UTF-8"); 	// 인코딩 처리
		ArrayList<BusinessDTO> Blist = null;
		int num = 0;
		String[] numStr = (String[])request.getParameterValues("pnum"); 
		int[] pnumArr = Arrays.stream(numStr).mapToInt(Integer::parseInt).toArray();
		
		Blist = dao.buyBusiness(pnumArr);
		MemberDTO mdto = dao.buyMember(mem_num);
%>	
<div id="con">
<h1>상품 주문</h1>
<hr class="headline1">	
<h2>주문자 정보</h2>
<table style = padding-bottom:15px;>	
		<tr class= "bbb">
			<td class="t1"><b>이름</b></td>
			<td><%=mdto.getName()%></td>	
		</tr>
		<tr>
			<td><b>연락처</b></td>
			<td><%=mdto.getTel_com()%>&nbsp;&nbsp; <%=mdto.getTel() %></td>
		</tr>
		<tr>
			<td><b>주소</b></td>
			<td><%=mdto.getAddress() %></td>
		</tr>
		<%--
</table>
<hr class="headline1">

<hr>
<table style = padding-bottom:30px;>
		 --%>
		<tr>
			<td class ="t1"><b>휴대폰</b></td>
			<td><%=mdto.getTel() %></td>
		</tr>
		<tr>
			<td class ="t1"><b>이메일</b></td>
			<td><%=mdto.getEmail()%></td>
		</tr>
</table>
<hr class="headline2">
<table>
		<tr>
			<td class="t1"><h2>주문상품:<%=Blist.size() %>개</h2></td>
		</tr>
</table>
<hr class="headline1">
<form action = "buyPagePro.jsp" method = "post" onsubmit="return on()">
<%	if(jang != null && jang.equals("jang")){ %>
	<input type="hidden" name="jang" value="jang"/>
<%	} %>
<%	for(BusinessDTO bdto : Blist){%>
<table style = padding-bottom:30px;>
		<tr>
			<td class="t2"><img src="../upload/<%=bdto.getThum1() %>"></td>
			<td>
				<input type = "hidden"  name = "pnum" value = "<%=bdto.getPnum()%>"/>
						<input type = "hidden"  name = "thum2" value="<%=bdto.getThum2() %>"/>
				상품 가격:&nbsp;<span class = "product" ><%=bdto.getPrice() %></span>&#8361; <br/>
							<input type = "hidden" class="totalPrice" name = "totalPrice" value = "<%=bdto.getPrice() %>"/>
							원산지:&nbsp;<%=bdto.getCountry() %> <br/>
				&nbsp; &nbsp; ── <br/>
				&nbsp; &nbsp; 수량: <input class="buy" type="number" name= "amount" value="1" min="1" max="<%=bdto.getStock()%>" onchange="updatePrice(this)">
			</td>
		</tr>
</table>	
<%}%>
<hr class="headline1">
		<table>
				<tr>
					<td>
						전체 가격 : <span id="totalPrice2"></span>&#8361; <br>
						<select name="payment" id="payment">
    							<option value="충전" selected>충전 결제</option>
   								<option value="카드">카드 결제</option>
						</select>
						<div id="balance">
							현재 잔고 : <span id="balance1"><%=mdto.getBalance() %></span>&#8361; <br>
							결제 후 잔고 : <span id="balance2"></span>&#8361;
						</div>
						<div id="cardInfo" style="display: none;">
    						<select name = "card">
    								<option value ="국민은행">국민은행</option>
    								<option value ="신한은행">신한은행</option>
    								<option value ="삼성카드">삼성카드</option>
    						</select>
    						<label for="cardNumber">카드번호:</label>
   							<input type="text" id="cardNumber" name="cardNumber">
						</div>
						 <br/>
						<h2> 받는 분 정보</h2>
						배송 요청사항:<input  type = "text"  name = "msg"/>			<br/>
						받는사람 배송지:<input type = "text" name = "rec_addr"/> 	<br/>
						받는사람  이름:<input type = "text" name = "rec_name"/>		<br/>
						받는사람 연락처:<input type = "text" name = "rec_tel"/>		<br/>
						<input type = "submit" value="구매 완료"/>	
					</td>
				</tr>
		</table>
</form>
</div>

<jsp:include page="../inc/footer.jsp"/>

<script>
    // 상품 수량올라 갔을때 가격이 자동으로 상품수량에 맞게 가격이 올라가는 메서드
	const nums = document.querySelectorAll(".buy");
	const totalPrices = document.querySelectorAll(".totalPrice");
	const prices = document.querySelectorAll(".product");
	const priceUnit = [];
	for(let i=0; i<prices.length; i++){
		priceUnit.push(prices[i].innerText);
	}
	
    let totalPrice = 0;
    for(let i=0; i<nums.length; i++){
    	totalPrice += nums[i].value * priceUnit[i];
    }
    document.getElementById("totalPrice2").innerText=totalPrice;
    document.getElementById("balance2").innerText = <%=mdto.getBalance() %> - totalPrice;
	
    function updatePrice(input) {
        let quantity = input.value;
        for(let i=0; i<nums.length; i++){
        	if(input == nums[i]){
	        	let price = quantity * priceUnit[i];
	        	prices[i].innerText = price;
	        	totalPrices[i].value=price;
        	}
        }
        
        let totalPrice = 0;
        for(let i=0; i<nums.length; i++){
        	totalPrice += nums[i].value * priceUnit[i];
        }
        document.getElementById("totalPrice2").innerText=totalPrice;
    	let balance = document.getElementById("balance1").innerText;
    	balance -= document.getElementById("totalPrice2").innerText;
    	document.getElementById("balance2").innerText = balance;
    }

  	// 결제방법을 카드 결제했을때 카드결제에 카드사랑 계좌번호 보이게하는 메서드 
	const selectBox = document.getElementById("payment");
    document.getElementById("payment").addEventListener("change", function() {
		let selectedValue = selectBox.options[selectBox.selectedIndex].value;
        if (selectedValue === "카드") {
            document.getElementById("cardInfo").style.display = "block";
        } else {
            document.getElementById("cardInfo").style.display = "none";
        }
        
        if (selectedValue === "충전") {
            document.getElementById("balance").style.display = "block";
        } else {
            document.getElementById("balance").style.display = "none";
        }
    });

  	// 구매시 잔액 체크
  	const b2 = document.getElementById("balance2"); // 잔액
    function on(){
		let selectedValue = selectBox.options[selectBox.selectedIndex].value;
    	if( selectedValue === "충전" && b2.innerText < 0 ){
    		alert("잔액이 부족합니다.");
    		return false;
 		}
    }
</script>
