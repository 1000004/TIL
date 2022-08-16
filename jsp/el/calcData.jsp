<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import ="java.util.*" %>
<%@ page import = "kr.ac.green.Some" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>calcData</title>
</head>
<body>
	<%
	//cmd 클래스에서 작동
		Vector<Some> list = new Vector<Some>();
	
		list.add(new Some(10, "abc"));//0
		list.add(new Some(12, "def"));//1
		list.add(new Some(15, "ghi"));//2
		list.add(new Some(11, "jkl"));//3
	
		request.setAttribute("list", list);
	%>
	<jsp:forward page="list.jsp"/>
</body>
</html>
