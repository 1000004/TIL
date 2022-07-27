<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="kr.ac.green.*"%>
<%@page import="java.util.Vector"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<a href="input.jsp">등록</a>
	<hr>
	<table>
		<tr>
			<th>이름</th>
			<th>나이</th>
		</tr>
		<%
			Vector<Human> list = HumanManager.getInstance().getList(application);
			if(list.size() == 0){
		%>
		<tr>
			<td colspan="2">없어요~</td>
		</tr>
		<%
			}else{
				for(Human h : list){
		%>
		<tr>
			<td><%= h.getName() %></td>
			<td><%= h.getAge() %></td>
		</tr>
		<%
				}
			}
		%>
	</table>
</body>
</html>
