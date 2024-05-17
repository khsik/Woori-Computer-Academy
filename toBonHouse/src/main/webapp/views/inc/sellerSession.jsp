<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<%
	// 판매자 페이지 세션처리
	String sid = (String)session.getAttribute("sid");
	// DB에 없는 값으로 대충 넣어두는것. 로그인 구분할 때 if(mem_num != 0){} 이런식으로 사용 가능
	int mem_num = 0;	
	int grade = 0;
	
	if(sid != null){
		// sid는 세션 값이 없어도 null이 들어와서 오류가 안생기지만
		// int는 오류가 생김.
		mem_num = (Integer)session.getAttribute("mem_num");
		grade = (Integer)session.getAttribute("grade");
	}

	if(grade != 2){ %>
		<script>
			window.location="../main.jsp";
		</script>
	<%	}%>
</body>
</html>