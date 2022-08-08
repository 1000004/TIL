package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class CancelJoinCmd implements ICmd{
	@Override
	public String doAction(HttpServletRequest request) {
		request.setAttribute("msg", "어서오세요.");
		return "login.jsp";
	}
}
