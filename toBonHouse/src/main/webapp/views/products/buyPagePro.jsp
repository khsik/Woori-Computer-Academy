<%@page import="business.OrderDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Arrays"%>
<%@ page import="products.ProductsDAO"%>
<% request.setCharacterEncoding("UTF-8");%>
						<%-- 구매 페이지 pro --%>
<%@ include file="../inc/session.jsp" %>
<% 
	// 장바구니에서 넘어왔는지 체크하는 용도의 변수
	String jang = (String)request.getParameter("jang");

	ProductsDAO dao = ProductsDAO.getInstance();
	// mem_num은 세션에서 가져옴
	String payment = request.getParameter("payment");
	String msg = request.getParameter("msg");
	String rec_addr = request.getParameter("rec_addr");
	String rec_name = request.getParameter("rec_name");
	String rec_tel = request.getParameter("rec_tel");
	String thum2[] = request.getParameterValues("thum2");
	String pnums[] = request.getParameterValues("pnum");
	String amounts[] = request.getParameterValues("amount");
	String[] totalPrices = request.getParameterValues("totalPrice");
	int[] totalPrice = Arrays.stream(totalPrices).mapToInt(Integer::parseInt).toArray(); 
	int[] pnum = Arrays.stream(pnums).mapToInt(Integer::parseInt).toArray(); 
	int[] amount = Arrays.stream(amounts).mapToInt(Integer::parseInt).toArray();
	
	int bnum = dao.buylist(mem_num);
	
	ArrayList<OrderDTO> list = new ArrayList<>();
	for(int i=0; i<thum2.length; i++){
		OrderDTO dto = new OrderDTO();
		dto.setBnum(bnum);
		dto.setMem_num(mem_num);
		dto.setTotalPrice(totalPrice[i]);
		dto.setPayment(payment);
		dto.setMsg(msg);
		dto.setRec_addr(rec_addr);
		dto.setRec_name(rec_name);
		dto.setRec_tel(rec_tel);
		dto.setThum2(thum2[i]);
		dto.setPnum(pnum[i]);
		dto.setAmount(amount[i]);
		list.add(dto);
	}
	dao.buySet(list);
	
	if(jang != null && jang.equals("jang")){	// 장바구니에서 구매한거라면
		dao.jangDelete(mem_num, pnum);	// 장바구니에서 삭제
	}
%>	
<script>
		window.location="buyList.jsp";
</script>
				