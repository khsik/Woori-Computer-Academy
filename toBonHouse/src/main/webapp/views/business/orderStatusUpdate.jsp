<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "business.OrderDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 처리</title>
</head>
<body>
<%
	String[] bnums = request.getParameterValues("bnum");
	String[] pnums = request.getParameterValues("pnum");
	int[] bnum = new int[bnums.length];
	int[] pnum = new int[pnums.length];
	for(int i=0; i<bnums.length; i++){
		bnum[i] = Integer.parseInt(bnums[i]);
		pnum[i] = Integer.parseInt(pnums[i]);
	}
	OrderDAO dao = OrderDAO.getInstance();
	int result = dao.finishOrder(bnum, pnum);
	if(result == 0){ %>
		<script>
			alert("배송 상태 변경 실패");
			location.replace(document.referrer);
		</script>
<%	} else{ %>
		<script>
			alert(<%=result %>+"건의 배송이 처리되었습니다.");
			location.replace(document.referrer);	// 뒤로가기 + 새로고침
			// window.location = "주소", location.href = "주소", history.go(-1)/back() 통해서 페이지 이동하면 현재 페이지에 대한 히스토리가 브라우저에 남음
			// location.replace("주소") 사용하면 브라우저에 현제 페이지의 히스토리 남기지 않고 이동.
			// document.referrer : 현제 페이지로 이동하기 전 url
		</script>
<%	} %>
</body>
</html>