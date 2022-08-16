<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>list.jsp</title>
</head>
<body>
	<%--
		<c:if test="${ empty list }">
			empty 
		</c:if>
		<c:if test="${ not empty list }">
			not empty
		</c:if>
	 --%>
	 <%
	 	int num = 100;
	 %>
	 result : ${ num }
	<br>
	<c:choose>
		<c:when test="${ empty list }">
			empty
		</c:when>
		<c:otherwise>
			<%--
				for(String some : list : ){}
			--%>
			<c:forEach items="${ list }" var="some" begin="1" end="2">
				${ some.num  } : ${ some.value }
				<br>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</body>
</html>
