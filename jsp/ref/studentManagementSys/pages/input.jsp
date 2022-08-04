<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<form action="<%= request.getContextPath()%>/control.jsp" method="post">
	<table id="infoTable">
		<tr>
			<th id="infoHeader">NAME</th>
			<th><input type="text" name="s_name"/></th>
		</tr>
		<tr>
			<th>Tel</th>
			<th><input type="text" name="s_tel"/></th>
		</tr>
		<tr>
			<th>Grade</th>
			<th><input type="text" name="s_grade" id="s_grade"/></th>
		</tr>
		<tr>
			<th>Class</th>
			<th><input type="text" name="s_class"/></th>
		</tr>
		<tr>
			<th colspan="2">
				<input type="submit" value="Insert"/>
			</th>
		</tr>
	</table>
	<input type="hidden" name="cmd" value="doInsert"/>
</form>
