package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class GoWithdrawCmd implements ICmd{
	@Override
	public String doAction(HttpServletRequest request) {
		request.setAttribute("msg", "이동작은 취소할 수 없습니다.");
		return "withdraw.jsp";
	}
}
