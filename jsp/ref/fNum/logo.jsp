<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*"%>
<%
	Map<String, String> nameList =
		(Map<String, String>)application.getAttribute("nameList");
%>
<h1>F<%= nameList.size() %> 펜페이지</h1
