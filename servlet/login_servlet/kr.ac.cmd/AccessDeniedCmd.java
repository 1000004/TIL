package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class AccessDeniedCmd implements ICmd{
	@Override
	public String doAction(HttpServletRequest request) {
		request.setAttribute("msg", "유효하지 않은 접근입니다.");
		return "login.jsp";
	}
}
