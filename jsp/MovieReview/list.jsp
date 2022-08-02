<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Vector" %>
<%@ page import="kr.ac.green.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>리뷰목록</h1>
<hr>
<a href="main.jsp?cmd=goInsert">리뷰등록하기</a>
<br><br>
<table border="1" width="50%">
	<tr>
		<th>num</th>
		<th>title</th>
		<th>point</th>
	</tr>
	<%
		Vector<MovieReview> list = (Vector<MovieReview>)request.getAttribute("list");
		if(list.size() == 0){
	%>
	<tr>
		<th colspan="3">empty</th>
	</tr>
	<%
		}else{
			for(MovieReview temp : list){
			//부르는것은?
	%>
	<tr onclick="showReview(<%=temp.getNum() %>)">
		<td><%= temp.getNum() %></td>
		<td><%= temp.getTitle() %></td>
		<td><%= temp.getPoint() %></td>
	</tr>
	<%
			}
		}
	%>
</table>
<script>
	function showReview(){
		location.href = "main.jsp?cmd=showReview&num=" + arguments[0];
	}
</script>
</body>
</html>
