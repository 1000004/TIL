package org.smart.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.smart.bean.GuestBook;
import org.smart.dao.DAOFactory;
import org.smart.dao.IDAO;

public class ReadCmd implements ICMD {

	@Override
	public String action(HttpServletRequest requset) {
		IDAO dao = DAOFactory.getDao();
		Connection con = dao.connect();
		System.out.println(con);
		GuestBook[] books = dao.readBook(con);
		dao.disconnect(con);
		requset.setAttribute("books", books);
		return "main.jsp";
	}

}
