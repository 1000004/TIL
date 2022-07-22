<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*"%>
<%@ page import="kr.ac.green.*"%>
<%
	String code = request.getParameter("code");

	System.out.println("contents.jsp : " + code);
	Vector<Comment> list = DataManager.getCmtList(code);
%>
<h1><%= DataManager.getName(code) %></h1>
<form action="save.jsp" method="post">
	메세지 : <input type="text" name="cmt"/>
	<br>
	작성자 : <input type="text" name="writer"/>
	<br>
	<input type="hidden" name="code" value="<%= code %>"/>
	<input type="submit" value="등록"/>
	<hr>
	<table>
		<tr>
			<th>번호</th>
			<th>내용</th>
			<th>작성자</th>
		</tr>
		<%
			for(int i=list.size()-1;i>=0;i--){
				Comment cmt = list.get(i);
		%>
		<tr>
			<td><%= i+1 %></td>
			<td><%= cmt.getValue() %></td>
			<td><%= cmt.getWriter() %></td>
		</tr>
		<%
			}
		%>
	</table>
</form>
