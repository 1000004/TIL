package kr.ac.green.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.dao.StudentDAO;
import kr.ac.green.dto.Student;

public class DoUpateCmd implements ICmd {

	@Override
	public String action(HttpServletRequest requset) {
		Student s = new Student(
			requset.getParameter("s_id"),
			requset.getParameter("s_name"),
			Integer.parseInt(requset.getParameter("s_age")),
			requset.getParameter("s_class"),
			requset.getParameter("s_gender")
		);
		
		StudentDAO dao = StudentDAO.getInstance();
		Connection con = dao.connect();
		dao.updateById(con, s);
		dao.disconnect(con);
		
		requset.setAttribute("isRedirect", true);
		return "getAll.do";
	}

}
