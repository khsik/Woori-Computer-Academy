<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Random Numbers</title>
</head>
<body>
	<h2>난수 생성</h2>
	<form action="ranNum.jsp" method="get">
		최소 : <input type="number" name="minNum" placeholder="1" required><br>
		최대 : <input type="number" name="maxNum" placeholder="45" required><br>
		개수 : <input type="number" name="amount" required><br>
		중복 허용 : 
			O<input type="radio" name="overlap" value="true" checked="checked"> /&nbsp;
			X<input type="radio" name="overlap" value="false"><br>
		<input type="submit" value="생성">
	</form>
</body>
</html>