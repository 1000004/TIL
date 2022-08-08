package org.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bean.Student;
import org.dao.StudentDAO;

public class FindCmd implements ICmd{
	@Override
	public void action(HttpServletRequest request, HttpServletResponse response) {
		String forWhat = request.getParameter("forWhat");
		String category = request.getParameter("category");
		String inputVal = request.getParameter("inputVal");
		String contentPage;
		
		Vector<Student> list = new Vector<Student>();
		
		if(forWhat.equals("getAll")){
			if(category.equals("s_id")){
				Student s = StudentDAO.getStudentById(Integer.parseInt(inputVal));
				if(s != null){
					list.add(s);
				}
			}else if(category.equals("s_name")){
				list = StudentDAO.getStudentByName(inputVal);
			}else{
				list = StudentDAO.getStudentByClass(inputVal);
			}
			contentPage = "pages/list.jsp";
			request.setAttribute("list", list);
		}else{
			Student s = StudentDAO.getStudentById(Integer.parseInt(inputVal));
			if(forWhat.equals("modify")){
				contentPage = "pages/modify.jsp";
			}else{
				contentPage = "pages/info.jsp";
			}
			request.setAttribute("student", s);
		}
		request.setAttribute("contentPage", contentPage);
	}
}
