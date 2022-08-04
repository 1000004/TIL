<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>input.jsp</title>
</head>
<body>
	<h1>동물보감 추가</h1>
	<hr>
	<a href="goList.do">목록으로</a>
	<hr>
	<form action="insert.do" method="post">
		이름 : <input type="text" name="a_name" />
		<br>
		평균 수명 : <input type="text" name="a_lifespan"/>
		<br>
		서식지 : <input type="text" name="a_habitat"/>
		<br>
		특징 : <input type="text" name="a_feature">
		<br>
		<input type="submit" value="등록"/>
		<input type="hidden" name="cmd" value="insert"/>
	</form>
</body>
</html>
