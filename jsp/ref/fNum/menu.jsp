<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*"%>
-Menu-
<br>
<ul>
	<%
		Map<String, String> nameList =
			(Map<String, String>)application.getAttribute("nameList");
		Set<String> names = nameList.keySet();
		for(String name : names){
	%>
	<li><a href="template.jsp?code=<%= name %>"><%= nameList.get(name) %></a></li>
	<%
		}
	%>
</ul>
