package org.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bean.Student;
import org.dao.StudentDAO;

public class GetAllCmd implements ICmd{
	@Override
	public void action(HttpServletRequest request, HttpServletResponse response) {
		Vector<Student> list = StudentDAO.getAll();
		
		request.setAttribute("list", list);
		request.setAttribute("contextPage", "pages/list.jsp");
		request.setAttribute("cmd", "getAll");
	}
}
