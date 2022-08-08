package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class JoinOkCmd implements ICmd{
	@Override
	public String doAction(HttpServletRequest request) {
		request.setAttribute("msg", "가입이 성공적으로 이루어졌습니다.");
		return "login.jsp";
	}
}
