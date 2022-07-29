<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="org.doo.*" %>
<%
	String u_id = request.getParameter("u_id");
	String u_pw = request.getParameter("u_pw");
	
	Member member = MemberManager.findMember(application, u_id);
	String msg;
	String nextPage = "loginForm.jsp";
	if(member==null){
		msg="가입 후 이용해 주세요";
	}else{
		if(!member.getU_pw().equals(u_pw)){
			msg = "비밀번호가 일치하지 않습니다.";
		}else{
			msg = member.getU_nick() + "님 환영합니다.";
			nextPage = "loginSuccess.jsp";
			session.setAttribute("member", member);
		}
	}
	session.setAttribute("msg", msg);
%>
<jsp:forward page="<%= nextPage %>" />
