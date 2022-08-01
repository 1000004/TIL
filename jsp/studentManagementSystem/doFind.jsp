<%@page import="com.sun.xml.internal.ws.api.ha.StickyFeature"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="org.bean.Student"%>
<%@ page import="org.dao.StudentDAO" %>
<%
	String forWhat = request.getParameter("forWhat");
	String category = request.getParameter("category");
	String inputVal = request.getParameter("inputVal");
	String contentPage;
	
	if(forWhat.equals("list")){
		Vector<Student> list = new Vector<Student>();
		if(category.equals("s_id")){
			Student s = StudentDAO.getStudentById(Integer.parseInt(inputVal));
			if(s != null){
				list.add(s);
			}else if(category.equals("s_name")){
				list = StudentDAO.getStudentByName(inputVal);
			}else{
				list = StudentDAO.getStudentByClass(inputVal);
			}		
		}
		contentPage = "list";
		request.setAttribute("list", list);
	}else{
		Student s = StudentDAO.getStudentById(Integer.parseInt(inputVal));
		if(s != null){
			if(forWhat.equals("modify")){
				contentPage = "modify";
			}else{
				contentPage = "info";
			}
		}else{
			contentPage = "nodata";
		}
		request.setAttribute("student", s);
	}
	request.setAttribute("contentPage", contentPage);
%>
<jsp:forward page="/main.jsp">
	<jsp:param value="<%= contentPage %>" name="contentPage"/>
</jsp:forward>
