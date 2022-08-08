package org.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.StudentDAO;

public class DoDeleteCmd implements ICmd{
	@Override
	public void action(HttpServletRequest request, HttpServletResponse response) {
		int s_id = Integer.parseInt(request.getParameter("s_id"));
		
		StudentDAO.delete(s_id);
		request.setAttribute("isRedirect", true);
	}
}
