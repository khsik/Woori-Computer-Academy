<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dao" class="webP.userpage.bean.UserInfoDAO"/>
<jsp:useBean id="dto" class="webP.userpage.bean.UserInfoDTO"/>
<jsp:setProperty name="dto" property="id" />
<%
	boolean result = dao.idCheck(dto.getId()); // 중복이면 flase
	if(result == true){ %>
		<script>
			opener.document.getElementById("idB").style.display = "inline";
			opener.document.getElementById("idR").style.display = "none";
			opener.document.getElementById("btn").style.display = "block";
			opener.document.getElementById("nobtn").style.display = "none";
			self.close();
		</script>
<%	}else{ %>
		<script>
			opener.document.getElementById("idR").style.display = "inline";
			opener.document.getElementById("idB").style.display = "none";
			opener.document.getElementById("btn").style.display = "none";
			opener.document.getElementById("nobtn").style.display = "block";
			self.close();
		</script>
<%	} %>
</body>
</html>