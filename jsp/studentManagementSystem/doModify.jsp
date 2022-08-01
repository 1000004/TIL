<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="org.bean.Student"%>
<%@ page import="org.dao.StudentDAO" %>
<%
	int s_id=Integer.parseInt(request.getParameter("s_id"));
	String s_name=request.getParameter("s_name");
	int s_grade=Integer.parseInt(request.getParameter("s_grade"));
	String s_tel=request.getParameter("s_tel");
	String s_class=request.getParameter("s_class");
	
	Student s = new Student(s_id, s_name, s_tel, s_grade, s_class);
	
	StudentDAO.update(s);
	
	response.sendRedirect(request.getContextPath());
%>
