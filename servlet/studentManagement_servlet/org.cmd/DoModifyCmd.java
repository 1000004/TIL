package org.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bean.Student;
import org.dao.StudentDAO;

public class DoModifyCmd implements ICmd{
	@Override
	public void action(HttpServletRequest request, HttpServletResponse response) {
		int s_id = Integer.parseInt(request.getParameter("s_id"));
		String s_name=request.getParameter("s_name");
		int s_grade = Integer.parseInt(request.getParameter("s_grage"));
		String s_tel = request.getParameter("s_tel");
		String s_class = request.getParameter("s_class");
		
		Student s = new Student(s_id, s_name, s_tel, s_grade, s_class);
		
		StudentDAO.update(s);
		
		request.setAttribute("isRedirect", true);
	}
}
