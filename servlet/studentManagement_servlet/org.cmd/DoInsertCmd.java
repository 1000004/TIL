package org.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bean.Counter;
import org.bean.Student;
import org.dao.StudentDAO;

public class DoInsertCmd implements ICmd{
	@Override
	public void action(HttpServletRequest request, HttpServletResponse response) {
		String s_name = request.getParameter("s_name");
		int s_grade = Integer.parseInt(request.getParameter("s_grade"));
		String s_tel = request.getParameter("s_tel");
		String s_class = request.getParameter("s_class");
		
		Student s = new Student(Counter.getCount(), s_name, s_tel, s_grade, s_class);
		
		if(!StudentDAO.insert(s)){
			Counter.rollback();
		}
		request.setAttribute("isRedirect", true);
	}
}
