<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="kr.ac.green.dto.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>lit.jsp</title>
</head>
<body>
	<a href="goInsert.do">학생등록</a>
	<table>
		<caption>학생목록</caption>
		<thead>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>나이</th>
				<th>학급</th>
				<th>성별</th>
			</tr>
		</thead>
		<%
			Vector<Student> list = (Vector<Student>)request.getAttribute("list");
		%>
		<tfoot>
			<tr>
				<th colspan="5"><%= list.size() %> row(s) </th>
			</tr>
		</tfoot>
		<tbody>
		<%
			if(list.size()==0){
		%>
			<tr>
				<th colspan="5">empty</th>
			</tr>
		<%
			}else{
				for(Student temp : list){
		%>
		<tr>
			<td><a href="getStudent.do?s_id=<%=temp.getS_id() %>"><%= temp.getS_id() %></a></td>
			<td><%= temp.getS_name() %></td>
			<td><%= temp.getS_age() %></td>
			<td><%= temp.getS_class() %></td>
			<td><%= temp.getS_gender() %></td>
		</tr>
		<%
				}
			}
		%>
		</tbody>
	</table>
</body>
</html>
