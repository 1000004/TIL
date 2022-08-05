package kr.ac.green.cmds;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoInsertCmd implements ICmd {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		return "input.jsp";
	}
	
}
