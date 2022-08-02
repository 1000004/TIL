<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="js/common.js"></script>
</head>
<body>
	<h1>리뷰등록</h1>
	<form action="main.jsp" name="insertForm">
		title : <input type="text" name="title"/>
		<br>
		point : 
		<select name="point">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
		</select>
		<br>
		password : <input type="password" name="password" />
		<br>
		review :
		<br>
		<textarea rows="5" cols="30" name="review"></textarea>
		<br>
		<input type="button" value="등록" onclick="moveTo(this.form, 'insert')"/>
		<input type="button" value="목록보기" onclick ="moveTo(this.form, 'getAll')"/>
		<input type="hidden" name="cmd"/>
	</form>
</body>
</html>
