<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="org.bean.Student" %>
<%@ page import="org.dao.StudentDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>main.jsp</title>
<style>
	html {
		width: 100%;
		height: 100%;
	}
	body {
		width: 90%;
		height: 90%
	}
	#whole {
		width: 60em;
		height: 35em;
		margin-top: 5%;
		margin-left: 15%;
		text-align: center;
		font-size: 0.8em;
		background-color: #FAFAD2;
		border: 2px solid gray;
	}
	#menuBox {
		width: 20%;
		height: 100%;
		float: left;
	}
	#contentBox {
		width: 80%;
		height: 100%;
		float: right;
		text-align: center;
	}
	#menus {
		text-align: left;
		width: 100%;
		margin-top: 3em;
		
		text-align: center;
	}
	#menus p {
		background-color: #cccccc;
		width: 100%;
		margin-left: 0.5em;
		line-height: 2em;
		font-weight: bold;
		text-align: center;
	}
	.menuStyle {
		text-decoration: none;
		color: black;
		display: block;
		margin-bottom: 1em;
	}
	.menuStyle:hover {
		font-weight: bold;
	}
	table {
		width: 80%;
		text-align: center;
		margin-top: 5%;
		margin-left: 10%;
	}
	#infoTable {
		width: 60%;
		margin-left: 20%;
	}
	#infoHeader {
		width: 40%;
	}
	caption {
		font-size: 1em;
		font-weight: bold;
	}
	th {
		background-color: #cccccc;
	}
	input[type="text"] {
		height: 1.2em;
		border: 1px solid gray;
		text-align: center;
	}
	select, input[type="submit"] {
		width: 5em;
		height: 1.5em;
		border: 1px solid gray;
	}
	#nodata {
		margin-top: 20%;
		font-size: 3em;
		text-align: center;
		font-style: italic;
		color: red;
		font-weight: bold;
	}
</style>
<script src="<%= request.getContextPath() %>/scripts/script.js"></script>
</head>
<%
	String contentPage = (String)request.getAttribute("contentPage");
%>
<body>
	<div id="whole">
		<h1>Student Management System</h1>
		<div id="menuBox">
			<jsp:include page="pages/menu.jsp"/>
		</div>
		<div id="contentBox">
			<jsp:include page="<%=contentPage %>"/>
		</div>
	</div>
</body>
</html>
