<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="org.doo.*" %>
<%
	String msg = (String)session.getAttribute("msg");
	if(msg == null){
		msg = "모든 항목은 필수 입력입니다.";
	}
	Member member = (Member)session.getAttribute("tempMember");
	if(member == null){
		member = MemberManager.getBlankMember();
	}
	session.removeAttribute("tempMember");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>join.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script>
	function checkAndMove(){
		var obj = document.joinForm;
		var flag = true;
		for(var i=0; flag && i<obj.length; i++){
			if(obj[i].type.toLowerCase() != "button"){
				if(obj[i].value.trim().length == 0){
					document.getElementById("msg").innerHTML = 
					"필수입력학목 누락 : " + obj[i].title;
					flag = false;
				}
			}
		}
		if(flag){
			if(obj.u_pw.value != obj.u_re.value){
				document.getElementById("msg").innerHTML = "비밀번호가 일치하지 않습니다.";
				flag = false;
			}
		}
		if(flag){
			obj.method = "post";
			obj.action = "doJoin.jsp";
			obj.submit();
		}
	}
	function cancelJoin(){
		location.href = "cancelJoin.jsp";
	}
</script>
</head>
<body>
	<p class="titleStr">
		Join Member
	</p>
	<form name="joinForm">
		<div class="centerBox">
			<label for="u_id">ID :</label>
			<input type="text" name="u_id" title="ID" value="<%= member.getU_id()%>"/><br/>
			<label for="u_pw">Pw :</label>
			<input type="password" name="u_pw" title="PASSWORD" /><br/>
			<label for="u_re">Retry :</label>
			<input type="password" name="u_re" title="RETRY" /><br/>
			<label for="u_name">Name :</label>
			<input type="text" name="u_name" title="NAME" value="<%=member.getU_name() %>"/>
			<br/>
			<label for="u_nick">Nick :</label>
			<input type="text" name="u_nick" title="NICKNAME"
				value="<%= member.getU_nick()%>">
			<div class="btns">
				<input type="button" value="회원가입" onclick="checkAndMove()"/>
				<input type="button" value="취소" onclick="cancelJoin()"/>
			</div>
		</div>
		<div class="msgBox" id="msg">
			<%=msg %>
		</div>
	</form>
</body>
</html>
<%@ include file="removeMessage.jspf"%>
