package org.smart.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.smart.bean.GuestBook;
import org.smart.dao.DAOFactory;
import org.smart.dao.IDAO;

public class WriteCmd implements ICMD {

	@Override
	public String action(HttpServletRequest requset) {
		String content = requset.getParameter("content");
		GuestBook book = new GuestBook(content);
		
		IDAO dao = DAOFactory.getDao();
		Connection con = dao.connect();
		dao.write(con, book);
		dao.disconnect(con);
		requset.setAttribute("isRedirect", true);
		
		return requset.getContextPath();
	}

}
