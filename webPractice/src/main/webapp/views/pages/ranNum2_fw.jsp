<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/ranNum2.css">
<title>ranNum2</title>
</head>
<body>
	<h1>무작위 숫자 생성</h1>
	<div id="setNum">
		<form action="ranNum2.jsp" method="post">
			최소 : <input type="number" name="min" placeholder="1" required> <br>
			최대 : <input type="number" name="max" placeholder="45" required> <br>
			개수 : <input type="number" name="amount" placeholder="6" required> <br>
			중복 : 
			<label for="can">허용<input type="radio" name="overlap" value="true" id="can"></label>
			<label for="cant">불가<input type="radio" name="overlap" value="false" id="cant" checked></label><br>
			숫자 정렬 : 
			<label for="ySort">O<input type="radio" name="sort" value="true" id="ySort"></label>
			<label for="nSort">X<input type="radio" name="sort" value="false" id="noSort" checked></label><br>
			<input type="submit" value="생성" id="btn">
		</form>
	</div>
	
	<hr id="midLine">
</body>
</html>