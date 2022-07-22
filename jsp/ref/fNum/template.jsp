<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "kr.ac.green.*" %>
<%
	DataManager.setApplication(application);
	String param = request.getParameter("code");
	String code = (param != null)?param : "f1";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="80%">
		<tr>
			<td colspan="2">
				<jsp:include page="logo.jsp"/>
			</td>
		</tr>
		<tr>
			<td>
				<jsp:include page="menu.jsp"/>
			</td>
			<td>
				<jsp:include page="contents.jsp">
					<jsp:param name="code" value="<%= code %>"/>
				</jsp:include>
			</td>
		</tr>
	
	</table>
</body>
</html>
