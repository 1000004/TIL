<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="kr.ac.green.Some" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>forward.jsp</title>
</head>
<body>
	<%
		Some s = new Some();
		s.setNum(100);
		s.setValue("myValue");
		
		Some s2 = new Some();
		s2.setNum(100);
		s2.setValue("yourValue");
		
		Vector<Some> list = new Vector<Some>();
		list.add(s);		// 0
		list.add(s2);		// 1
		
		Some[] arr = null;
		
		request.setAttribute("arr", arr);
		request.setAttribute("list", list);
		
		session.setAttribute("some", s);
		
		request.setAttribute("myObj", "abc");
	%>
	<jsp:forward page="elEx.jsp">
		<jsp:param value="hello" name="myParam"/>
	</jsp:forward>
</body>
</html>
