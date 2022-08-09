package kr.ac.green.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.dao.StudentDAO;
import kr.ac.green.dto.Student;

public class DoInsertCmd implements ICmd {

	@Override
	public String action(HttpServletRequest requset) {
		String s_id=requset.getParameter("s_id");
		String s_name=requset.getParameter("s_name");
		int s_age = Integer.parseInt(requset.getParameter("s_age"));
		String s_class = requset.getParameter("s_class");
		String s_gender = requset.getParameter("s_gender");
		Student s = new Student(s_id, s_name, s_age, s_class, s_gender);
		
		StudentDAO dao = StudentDAO.getInstance();
		Connection con = dao.connect();
		dao.insert(con, s);
		dao.disconnect(con);
		
		requset.setAttribute("isRedirect", true);
		return "getAll.do";
	}

}
