<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="jspfs/chksession.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Login Success</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="script/scripts.js" charset="utf-8"></script>
</head>
<body>
	<p class="titleStr">
		Success!!
	</p>
	<form name="successForm">
		<div class="centerBox">
			<div class="btns">
				<input type="button" value="정보보기"
					onclick="justMove(this.form, 'goInfo')"/>
				<input type="button" value="로그아웃"
					onclick="logout(this.form, 'goLogout')"/>
			</div>
		</div>
		<div class="msgBox">
			<%= session.getAttribute("msg") %>
		</div>
		<input type="hidden" name="cmd"/>
	</form>
</body>
</html>
<%@ include file="jspfs/removeMsg.jspf"%>
