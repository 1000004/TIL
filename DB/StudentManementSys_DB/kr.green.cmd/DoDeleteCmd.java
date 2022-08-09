package kr.ac.green.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.dao.StudentDAO;
import kr.ac.green.dto.Student;

public class DoDeleteCmd implements ICmd {

	@Override
	public String action(HttpServletRequest requset) {
		String s_id = requset.getParameter("s_id");
		StudentDAO dao = StudentDAO.getInstance();
		
		Connection con = dao.connect();
		dao.deleteById(con, s_id);
		dao.disconnect(con);
		
		requset.setAttribute("isRedirect", true);
		return "getAll.do";
	}

}
