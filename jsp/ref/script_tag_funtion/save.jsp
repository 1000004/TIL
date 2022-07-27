<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kr.ac.green.*" %>
<%
	request.setCharacterEncoding("euc-kr");

	String name = request.getParameter("h_name");
	int age = Integer.parseInt(request.getParameter("h_age"));
	
	Human h = new Human();
	h.setName(name);
	h.setAge(age);
	
	HumanManager.getInstance().add(application, h);
	
	response.sendRedirect("output.jsp");
%>
