<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="jspfs/chksession.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Info.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="script/scripts.js" charset="utf-8"></script>
</head>
<body>
	<p class="titleStr">
		Info
	</p>
	<form name="infoForm">
		<div class="centerBox">
			<label for="u_id">ID :</label>
			<input type="text" name="u_id" title="ID" readonly="readonly"
				value="<%= member.getU_id()%>"/><br/>
			<label for="u_pw">PW :</label>
			<input type="password" name="u_pw" title="Password"/><br/>
			<label for="u_re">Retry :</label>
			<input type="password" name="u_re" title="Retry"/><br/>
			<label for="u_name">Name :</label>
			<input type="text" name="u_name" title="Name" readonly="readonly"
				value="<%= member.getU_name() %>"/><br/>
			<label for="u_nick">Nick :</label>
			<input type="text" name="u_nick" title="Nickname"
				value="<%= member.getU_nick()%>"/><br/>
			<div class="btns">
				<input type="button" value="수정"
					onclick="justMove(this.form, 'doUpdate', true)"/>
				<input type="button" value="취소"
					onclick="justMove(this.form, 'backToSuccess')"/>
				<input type="button" value="회원탈퇴" onclick="doDelete(this.form)"/>
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
