<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="org.login.bean.*" %>
<%@ page import="org.login.data.*" %>
<jsp:useBean id="member" class="org.login.bean.Member"/>
<jsp:setProperty name="member" property="*"/>
<%
	String cmd="joinOk";
	if(!MemberManager.addMember(application, member)){
		cmd="joinFailed";
	}
	response.sendRedirect(request.getContextPath() + "?cmd=" +cmd);
%>
