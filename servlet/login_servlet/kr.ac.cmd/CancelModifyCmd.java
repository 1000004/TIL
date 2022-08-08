package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class CancelModifyCmd implements ICmd{
	@Override
	public String doAction(HttpServletRequest request) {
		request.setAttribute("msg", "개인정보수정이 취소되었습니다.");
		return "loginSuccess.jsp";
	}
}
