package kr.ac.green.cmds;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.green.dao.AnimalDAO;

public class GoListCmd implements ICmd{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("list", AnimalDAO.getList());
		return "list.jsp";
	}
	
}
