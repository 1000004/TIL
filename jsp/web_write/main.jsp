<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="kr.ac.green.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>main.jsp</title>
</head>
<body>
<%
	Vector<Doc> list = DocManger.getList(application);
%>
<form action="doWriter.jsp" method="post">
	한마디 : <input type="text" name="words"/>
	<br>
	작성자 : <input type="text" name="writer"/>
	<br>
	<input type="submit"/>
</form>
<hr>

<table>
	<caption>글등록</caption>
	<thead>
		<tr>
			<th>번호</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
	</thead>
	<tfood>
		<tr>
			<th colspan="4"><%= list.size() %> rows</th>
		</tr>
	</tfood>
	<tbody>
		<%
			if(list.size() == 0){
		%>
			<tr>
				<th colspan="4">등록된 글이 없습니다.</th>
			</tr>
		<%
			}else{
				for(Doc doc : list){
		%>
			<tr>
				<td><%= doc.getNum() %></td>
				<td><%= doc.getWords() %></td>
				<td><%= doc.getWriter() %></td>
				<td><%= doc.getDate() %></td>
			</tr>
		<%
				}
			}
		%>
	</tbody>
</table>
</body>
</html>
