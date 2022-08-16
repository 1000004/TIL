<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>jstlEx.jsp</title>
</head>
<body>
<%--
	begin : 시작수(포함)
	end : 끝수(포함)
	step : 증가량
	
	for(int i=0; i>=0; i--) -> JSTL에서는 정방향만 지원함(x)
 --%>
	<c:forEach var="no" begin="0" end="10" step="3">
		no : ${no}
		<br>
	</c:forEach>
	<hr>
	after : ${ no }
	<br>
	<%-- no가 쓰일 수 있는 범위가 있다 --%>
	
	<% pageContext.setAttribute("myNum", 5); %>
	<%-- page(default), requset, session, application --%>
	<c:set var="myNum" scope="page" value="5"/>
	
	in : ${ myNum }
	
	<c:remove var="myNum" scope="page"/>
	out : ${ myNum }
	<%-- status 반복문에 대한 정보를 가지고 있는 객체 ex ${status.count} 반복한 횟수를 나타낸다 --%>
	<c:forEach begin="100" end="120" var="myNum" varStatus="status">
		index : ${ status.index } -> count : ${ status.count -1 } -> ${ myNum }
		<br>
	</c:forEach>
</body>
</html>
