<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="org.login.bean.*"%>
<%
	String cmd = request.getParameter("cmd");
	if(cmd == null){
		cmd="start";
	}
	String nextPage = "";
	String msg = null;
	if(cmd.equals("start")){
		nextPage = "loginForm.jsp";
		msg = "어서오세요";
	}else if(cmd.equals("goJoin")){
		nextPage = "join.jsp";
		msg = "모든 사항은 필수입력입니다.";
	}else if(cmd.equals("cancelJoin")){
		nextPage="loginForm.jsp";
		msg = "가입이 취소되었습니다.";
	}else if(cmd.equals("goInfo")){
		nextPage="info.jsp";
		msg="비밀번호, 닉네임이 변경가능 합니다.";
	}else if(cmd.equals("goLogout")){
		nextPage="logout.jsp";
	}else if(cmd.equals("backToSuccess")){
		msg = "장보수정이 취소되었습니다.";
		nextPage="loginSuccess.jsp";
	}else if(cmd.equals("doDelete")){
		nextPage = "doDelete.jsp";
	}else if(cmd.equals("chkLogin")){
		nextPage = "checkLogin.jsp";
	}else if(cmd.equals("doJoin")){
		nextPage = "doJoin.jsp";
	}else if(cmd.equals("doUpdate")){
		nextPage = "doUpdate.jsp";
	}else if(cmd.equals("updateFailed")){
		nextPage = "info.jsp";
		msg = "정보변경 중 오류가 발생했습니다.";
	}else if(cmd.equals("updateOk")){
		nextPage = "loginSuccess.jsp";
		msg = "정보변경 성공";
	}else if(cmd.equals("joinOk")){
		nextPage = "loginForm.jsp";
		msg = "회원가입에 성공하였습니다. 로그인해주세요";
	}else if(cmd.equals("joinFailed")){
		nextPage = "join.jsp";
		msg = "이미 존재하는 ID입니다.";
	}else if(cmd.equals("deleteFailed")){
		nextPage = "info.jsp";
		msg = "회원탈퇴도중 오류가 발생했습니다.";
	}else if(cmd.equals("deleteOk")){
		nextPage = "loginForm.jsp";
		msg="탈퇴처리되었습니다. 이용해주셔서 감사드립니다.";
	}else if(cmd.equals("logout")){
		nextPage = "loginForm.jsp";
		msg="로그아웃되었습니다.";
	}else if(cmd.equals("idNotExists")){
		nextPage="loginForm.jsp";
		msg="등록되지 않은 ID입니다.";
	}else if(cmd.equals("wrongPassword")){
		nextPage = "loginForm.jsp";
		msg ="비밀번호가 일치하지 않습니다.";
	}else if(cmd.equals("loginOk")){
		nextPage="loginSuccess.jsp";
		Member member = (Member)session.getAttribute("loginMember");
		msg= member.getU_nick() + "님 방갑습니다.";
	}else{
		nextPage="loginForm.jsp";
		msg="잘못된 요청입니다.";
	}
	session.setAttribute("msg", msg);
%>
<jsp:forward page="<%= nextPage %>"/>
