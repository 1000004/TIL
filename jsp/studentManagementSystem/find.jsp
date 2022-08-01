<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String forWhat = request.getParameter("forWhat");
%>
<div>
	<form action="<%= request.getContextPath()%>/pages/doFind.jsp">
		<table>
			<tr>
				<td>
			검색 : 
				</td>
				<td>
			<select name="category">
				<option value="s_id">ID</option>
				<% if(forWhat.equals("list")){ %>
				<option value="s_name">Name</option>
				<option value="s_class">Class</option>
				<% } %>
			</select>
				</td>
				<td>
			내용 :
				</td>
				<td>
			<input type="text" name="inputVal"/>
				</td>
				<td>
					<input type="submit" value="go"/>
				</td>
			</tr>
		</table>
		<input type="hidden" name="forWhat" value="<%= forWhat%>">
	</form>
</div>
