package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class CancelWithdrawCmd implements ICmd{
	@Override
	public String doAction(HttpServletRequest request) {
		request.setAttribute("msg", "탈퇴가 철회되었습니다.");
		return "loginSuccess.jsp";
	}
}
