<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kr.ac.green.*"%>
<%
	request.setCharacterEncoding("euc-kr");
	String words = request.getParameter("words");
	String writer = request.getParameter("writer");
	Doc doc = new Doc(words, writer);
	
	DocManger.addDoc(doc, application);
	
	response.sendRedirect(request.getContextPath());
%>
