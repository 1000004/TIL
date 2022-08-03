<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>LoginForm</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="script/scripts.js"charset="utf-8"></script>
</head>
<body>
	<p class="titleStr">
		Login
	</p>
	<form name="loginForm">
		<div class="centerBox">
			<label for="u_id">ID :</label><input type="text" name="u_id" title="ID"/><br/>
			<label for="u_pw">PW :</label>
			<input type="text" name="u_pw" title="Password"/><br/>
			<div class="btns">
				<input type="button" value="로그인"
					onclick="chkAndMove(this.form, 'chkLogin')"/>
				<input type="button" value="회원가입"
					onclick="justMove(this.form, 'goJoin')">
			</div>
		</div>
		<div class="msgBox">
			<% String msg = (String)session.getAttribute("msg"); %>
			<%= msg == null ? "어서오세요" : msg%>
		</div>
		<input type="hidden" name="cmd"/>
	</form>
</body>
</html>
<%@ include file="jspfs/removeMsg.jspf"%>
