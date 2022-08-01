<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="org.bean.Student"%>
<%@ page import="org.dao.StudentDAO" %>
<%
	int s_id = Integer.parseInt(request.getParameter("s_id"));
	StudentDAO.delete(s_id);
	response.sendRedirect(request.getContextPath());
%>
