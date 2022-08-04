<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="org.dao.*"%>
<%@ page import="org.bean.*"%>
<%
	StudentDAO.init(application);
	String cmd=request.getParameter("cmd");
	if(cmd == null) cmd="getAll";
	String contentPage = null;
	boolean isRedirect = false;
	if(cmd.equals("getAll")){
		request.setAttribute("list", StudentDAO.getAll());
		contentPage = "pages/list.jsp";
	}else if(cmd.equals("modify")||cmd.equals("delete")){
		contentPage = "pages/find.jsp";
	}else if(cmd.equals("input")){
		contentPage = "pages/input.jsp";
	}else if(cmd.equals("doInsert")){
		String s_name = request.getParameter("s_name");
		int s_grade = Integer.parseInt(request.getParameter("s_grade"));
		String s_tel = request.getParameter("s_tel");
		String s_class = request.getParameter("s_class");
		Student s = new Student();
		s.setS_id(Counter.getCount());
		s.setS_name(s_name);
		s.setS_grade(s_grade);
		s.setS_tel(s_tel);
		s.setS_class(s_class);
		StudentDAO.insert(s);
		
		isRedirect = true;
	}else if(cmd.equals("find")){
		String forWhat = request.getParameter("forWhat");
		String category = request.getParameter("categry");
		String inputVal = request.getParameter("inputVal");
		Vector<Student> list = null;
		if(forWhat.equals("getAll")){
			if(category.equals("s_id")){
				list = new Vector<Student>();
				Student s = StudentDAO.getStudentById(Integer.parseInt(inputVal));
				if(s != null){
					list.add(s);
				}
			}else if(category.equals("s_name")){
				list = StudentDAO.getStudentByName(inputVal);
			}else{
				list = StudentDAO.getStudentByName(inputVal);
			}
			contentPage = "pages/list.jsp";
			request.setAttribute("list", list);
		}else{
			Student s = StudentDAO.getStudentById(Integer.parseInt(inputVal));
			if(s != null){
				if(forWhat.equals("modify")){
					contentPage = "pages/modify.jsp";
				}else{
					contentPage = "pages/info.jsp";
				}
				request.setAttribute("student", s);
			}else{
				contentPage = "pages/nodata.jsp";
			}
		}
	}else if(cmd.equals("doModify")){
		int s_id=Integer.parseInt(request.getParameter("s_id"));
		String s_name = request.getParameter("s_name");
		int s_grade = Integer.parseInt(request.getParameter("s_grade"));
		String s_tel=request.getParameter("s_tel");
		String s_class=request.getParameter("s_class");
		
		Student s = new Student();
		s.setS_id(s_id);
		s.setS_name(s_name);
		s.setS_grade(s_grade);
		s.setS_tel(s_tel);
		s.setS_class(s_class);
		
		StudentDAO.update(s);
		
		isRedirect = true;
	}else if(cmd.equals("doDelete")){
		int s_id = Integer.parseInt(request.getParameter("s_id"));
		StudentDAO.delete(s_id);
		isRedirect = true;
	}else if(cmd.equals("nodata")){
		contentPage="pages/nodata.jsp";
	}
	request.setAttribute("contentPage", contentPage);
	
	if(!isRedirect){
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}else{
		response.sendRedirect(request.getContextPath());
	}
%>
