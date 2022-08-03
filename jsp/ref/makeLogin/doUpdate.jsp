<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="jspfs/chksession.jspf" %>
<%@ page import="org.login.data.*"%>
<%
	member.setU_pw(request.getParameter("u_pw"));
	member.setU_nick(request.getParameter("u_nick"));
	String msg = "정보변경 성공!!";
	String cmd = "updateOk";
	if(!MemberManager.updateMember(application, member)){
		msg = "정보변경중 오류가 발생했습니다.";
		cmd = "updateFiled";
	}
	session.setAttribute("msg", msg);
	response.sendRedirect(request.getContextPath() + "?cmd=" + cmd);
%>
