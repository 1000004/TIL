<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kr.ac.green.*" %>
<%
	request.setCharacterEncoding("euc-kr");

	Comment cmt = new Comment(
		request.getParameter("writer"),
		request.getParameter("cmt")
	);
	String code = request.getParameter("code");
	DataManager.addCmt(code, cmt);
	
	response.sendRedirect("template.jsp?code=" + code);
%>
