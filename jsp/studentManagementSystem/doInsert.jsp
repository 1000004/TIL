<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="org.bean.*"%>
<%@ page import="org.dao.StudentDAO" %>
<%
	String s_name=request.getParameter("s_name");
	int s_grade = Integer.parseInt(request.getParameter("s_grade"));
	String s_tel = request.getParameter("s_tel");
	String s_class = request.getParameter("s_class");
	
	Student s = new Student(Counter.getCount(), s_name, s_tel, s_grade, s_class);
	
	if(!StudentDAO.insert(s)){
		Counter.rollback();
	}
	response.sendRedirect(request.getContextPath());
%>
