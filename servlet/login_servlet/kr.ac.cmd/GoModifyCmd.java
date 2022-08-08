package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class GoModifyCmd implements ICmd{
	@Override
	public String doAction(HttpServletRequest request) {
		request.setAttribute("msg", "패스워드와 닉네임 수정이 가능합니다.");
		return "modify.jsp";
	}
}
