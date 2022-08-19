<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>main.jsp</title>
</head>
<body>
	<form action="insertCar" method="post">
		<table>
			<caption>차량 등록</caption>
			<tr>
				<td>모델</td>
				<td><input type="text" name="c_model"/></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="c_price"/></td>
			</tr>
			<tr>
				<td>색상</td>
				<td><input type="text" name="c_color"/></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit"/></th>
			</tr>
		</table>	
	</form>
	<hr>
	<table>
		<tr>
			<th>아이디</th><th>모델</th><th>가격</th><th>색상</th>
		</tr>
		<c:choose>
			<c:when test="${ empty list}">
				<tr>
					<th colspan="4"> empty</th>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list}" var="temp">
					<tr>
						<td>${ temp.c_id }</td>
						<td>${ temp.c_model }</td>
						<td>${ temp.c_price }</td>
						<td>${ temp.c_color }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>
