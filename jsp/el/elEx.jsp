<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- EL을 사용할때 import 안해도 된다
	<%@ page import ="kr.ac.green.Some" %>
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>elEx.jsp</title>
</head>
<body>
	<%--
		${ 값 }
		<%= 값 =%>
		
		EL에서 기본객체(attribute) 접근
		pageContext -> pageScope
		requset -> requestScope
		session -> sessionScope
		application -> applicationScope
		
		기본객체가 생략되는 경우
		${ myObj }
		다음 순서로 속성이 존재하는지 검사하고 있으면 해당 값을 가져온다.
		pageContext.getAttribute("myObj");
		request.getAttribute("myObj");
		session.getAttribute("myObj");
		application.getAttribute("myObj");
		
		만약 위 네가지 기본객체에 해당하는 속성이 없으면 null로 처리한다.
	--%>
	<%-- 
		복수 데이터 : 배열, Vector, Map 원소가 없거나 혹은 null인 경우 true 
	--%>
	<%= request.getContextPath() %>
	<%-- html 테그에는 el 사용 가능 스크립트릿에는 사용 불가--%>
	<%-- 
		pageContext.getRequest()는 ServletRequest으로 타입을 리턴 HttpServletRequest 타입인 경우에만 getContextPath() 메서드 이용 가능
		HttpServletRequest으로 형변환이 필요
	--%>
	<a href="${ pageContext.request.contextPath } /forward.jsp">click</a>
	<%= request.getContextPath() %>
	${ pageContext.request.contextPath }
	<%= application.getInitParameter("myKey") %>
	${ initParam.myKey }
	<br>
	${ param.myParam }
	<%-- el은 스크립트릿에 못 쓴다 자바 문법에도 적용 --%>
	${ empty arr }
	<%-- NullPointerException이 안뜬다 --%>
	${ arr[0] }
	<br>
	<%-- getValue가 있다는 전제 (bean 구조 기본 생성자)--%>
	${ list[1].value }
	<hr>
	<%-- some 의 num을 출력하라. --%>
	<%--
		<%
			Some s = (Some)session.getAttribute("some");
		%>
		<%= s.getNum() %>
	 --%>
	 EL : ${ some.num }
	<hr>
	${ myObj }
	${ requestScope.myObj }
	<%= request.getAttribute("myObj") %>
	<hr>
	${ 10 + 20 }
	<%= 10 + 20 %>
	<br>
	${ 10 / 20 }
	<%= 10/20 %>
	<br>
	<%
		String str = null;
	%>
	<%-- EL은 값이 null인 경우 출력하지 않는다. null에 어떤 연산을 하면 NullPointerException이 발생한다. --%>
	${ str }
	<%= "other : " + str %>
</body>
</html>
