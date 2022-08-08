package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class AfterWithdrawCmd implements ICmd{
	@Override
	public String doAction(HttpServletRequest request) {
		request.setAttribute("msg", "그동안 이용해주셔서 감사드립니다.");
		return "login.jsp";
	}
}
