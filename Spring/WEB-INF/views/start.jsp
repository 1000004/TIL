<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>start.jsp</title>
</head>
<body>
	<h1>start</h1>
	<hr>
	${ attr }
	<hr>
	<form action="processData" method="post">
		name : <input type="text" name="bean_name"/>
		<br>
		num : <input type="text" name="bean_num"/>
		<br>
		password : <input type="password" name="bean_password"/>
		<br>
		<input type="submit" />
	</form>
</body>
</html>
