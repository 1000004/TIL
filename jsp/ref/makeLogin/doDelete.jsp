<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="jspfs/chksession.jspf" %>
<%@ page import="org.login.data.*"%>
<%
	String cmd = "deleteFailed";
	if(MemberManager.deleteMember(application, member.getU_id())){
		session.invalidate();
		cmd="deleteOk";
	}
	response.sendRedirect(request.getContextPath() + "?cmd=" + cmd);
%>
