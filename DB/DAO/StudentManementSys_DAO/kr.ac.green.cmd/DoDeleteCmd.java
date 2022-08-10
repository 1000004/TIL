package kr.ac.green.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.dao.DAOFactory;
import kr.ac.green.dao.DAOProvider;
import kr.ac.green.dao.IDAO;

public class DoDeleteCmd implements ICmd {

	@Override
	public String action(HttpServletRequest requset) {
		String s_id = requset.getParameter("s_id");
		IDAO dao = DAOProvider.getDao();
//		IDAO dao = DAOFactory.getDao();
		
		Connection con = dao.connect();
		dao.deleteById(con, s_id);
		dao.disconnect(con);
		
		requset.setAttribute("isRedirect", true);
		return "getAll.do";
	}

}
