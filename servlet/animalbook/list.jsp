<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kr.ac.green.Animal" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>list.jsp</title>
</head>
<body>
<h1>동물보감</h1>
<hr>
	<a href="goInsert.do">동물보감 등록</a>
<hr>
<table>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>평균수명</th>
		<th>서식지</th>
		<th>특징</th>
	</tr>
	<%
		Animal[] list = (Animal[])request.getAttribute("list");
		if(list.length == 0){
	%>
	<tr>
		<th colspan="5">도감을 등록해주세요</th>
	</tr>
	<%
		}else{
			for(int i=list.length-1;i>=0;i-- ){
			Animal animal=list[i];	
	%>
	<tr>
		<td><%=animal.getA_num() %></td>
		<td><%=animal.getA_name() %></td>
		<td><%=animal.getA_lifespan() %></td>
		<td><%=animal.getA_habitat() %></td>
		<td><%=animal.getA_feature() %></td>
	</tr>
	<%
			}
		}
	%>
</table>
</body>
</html>
