<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kr.ac.green.dto.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>info.jsp</title>
</head>
<body>
	<a href="getAll.do">목록으로</a>
	<hr>
	<%
		Student s = (Student)request.getAttribute("student");
	%>
	<form method="post">
		학번 : <input type="text" name="s_id" value="<%= s.getS_id()%>" readonly="readonly"/>
		<br>
		이름 : <input type="text" name="s_name" value="<%= s.getS_name() %>"/>
		<br>
		나이 : <input type="text" name="s_age" value="<%= s.getS_age() %>"/>
		<br>
		학급 : <input type="text" name="s_class" value="<%= s.getS_class() %>"/>
		<br>
		<%
			String gender = s.getS_gender();
		%>
		성별 : <input type="radio" name="s_gender" value="f"
		<%
		if(gender.equals("m")){
		%>
		 checked="checked"
		 <%
		}
		 %>
		 />여자
		<input type="radio" name="s_gender" value="m"
		<%
		if(gender.equals("f")){
		%>
		 checked="checked"
		 <%
		}
		 %>
		/>남자
		<br>
		<input type="button" value="삭제" onclick="doWhat(this.form, 'doDelete')"/>
		<input type="button" value="수정" onclick="doWhat(this.form, 'doUpdate')"/>
	</form>
	<script>
		function doWhat(){
			var obj = arguments[0];
			obj.action = arguments[1] + ".do"
			
			obj.submit();
		}
	</script>
</body>
</html>
