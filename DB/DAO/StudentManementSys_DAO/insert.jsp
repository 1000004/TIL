<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>insert.jsp</title>
</head>
<body>
	<a href="getAll.do">목록으로</a>
	<hr>
	<form action="doInsert.do" method="post">
		학번 : <input type="text" name="s_id"/>
		<br>
		이름 : <input type="text" name="s_name"/>
		<br>
		나이 : <input type="text" name="s_age"/>
		<br>
		학급 : <input type="text" name="s_class"/>
		<br>
		성별 : <input type="radio" name="s_gender" value="f" checked="checked"/>여자
		<input type="radio" name="s_gender" value="m"/>남자
		<br>
		<input type="submit" value="추가하기">
	</form>
</body>
</html>
