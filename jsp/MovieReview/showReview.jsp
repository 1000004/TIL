<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kr.ac.green.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="js/common.js"></script>
</head>
<body>
<h1>리뷰보기</h1>
<%
	MovieReview mr = (MovieReview)request.getAttribute("review");
%>
<hr>
	<form action="main.jsp" name="reviewForm">
		num : <input type="text" name="num" value="<%= mr.getNum() %>" readonly="readonly"/>
		<br>
		title : <input type="text" name="title" value="<%= mr.getTitle() %>"/>
		<br>
		point : <select name="point">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
		</select>
		<br>
		password : <input type="password" name="password" />
		<br>
		review :
		<br>
		<textarea rows="5" cols="30" name="review"><%= mr.getReview() %></textarea>
		<br>
		<input type="button" value="목록보기" onclick="moveTo(this.form, 'getAll')"/>
		<input type="button" value="수정보기" onclick="moveTo(this.form, 'update')"/>
		<input type="button" value="삭제하기" onclick="moveTo(this.form, 'delete')"/>
		<input type="hidden" name="cmd" />
		</form>
</body>
<script>
	checkPoint(<%= mr.getPoint() %>);
	function checkPoint(){
		var pointCheck = document.reviewForm.point;
		pointCheck[arguments[0] - 1].selected = true;
	}
</script>
</html>
