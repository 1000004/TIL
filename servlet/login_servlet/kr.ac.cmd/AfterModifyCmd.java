package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class AfterModifyCmd implements ICmd{
	@Override
	public String doAction(HttpServletRequest request) {
		request.setAttribute("msg", "개인정보가 업데이트 되었습니다.");
		return "loginSuccess.jsp";
	}
}
