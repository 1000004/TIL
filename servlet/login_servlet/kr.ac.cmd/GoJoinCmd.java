package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class GoJoinCmd implements ICmd{
	@Override
	public String doAction(HttpServletRequest request) {
		request.setAttribute("msg", "모든항목은 필수 입력입니다.");
		return "join.jsp";
	}
}
