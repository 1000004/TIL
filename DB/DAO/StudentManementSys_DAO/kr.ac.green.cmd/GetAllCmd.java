package kr.ac.green.cmd;

import java.sql.Connection;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.dao.DAOProvider;
import kr.ac.green.dao.IDAO;
import kr.ac.green.dto.Student;

public class GetAllCmd implements ICmd {

	@Override
	public String action(HttpServletRequest requset) {
		IDAO dao = DAOProvider.getDao();
//		IDAO dao = DAOFactory.getDao();
		Connection con = dao.connect();
		Vector<Student> list = dao.getAll(con);
		dao.disconnect(con);
		
		requset.setAttribute("list", list);//세션 카운터
		
		return "list.jsp";
	}

}
