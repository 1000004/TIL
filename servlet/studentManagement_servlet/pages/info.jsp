<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="org.bean.*" %>
<%
	Student s = (Student)request.getAttribute("student");
	if(s == null){
%>
	<jsp:forward page="nodata.do"/>
<%
	}else{
%>
<form action="doDelete.do" method="post">
	<table id="infoTable">
		<tr>
			<th>ID</th>
			<th><input type="text" name="s_id" value="<%= s.getS_id()%>"
			readonly="readonly"/></th>
		</tr>
		<tr>
			<th>NAME</th>
			<th><input type="text" name="s_name" value="<%= s.getS_name() %>"
					readonly="readonly"/></th>
		</tr>
		<tr>
			<th>Tel</th>
			<th><input type="text" name="s_tel" value="<%= s.getS_tel() %>"
					readonly="readonly"/></th>
		</tr>
		<tr>
			<th>Grade</th>
			<th><input type="text" name="s_class" value="<%= s.getS_class() %>"
					readonly="readonly"/></th>
		</tr>
		<tr>
			<th colspan="2">
				<input type="submit" value="Delete"/>
			</th>
		</tr>
	</table>
</form>
<%
	}
%>
