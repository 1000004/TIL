package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.ac.green.dto.User;

public class LogoutCmd implements ICmd{
	@Override
	public String doAction(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		request.setAttribute("msg", user.getNick() + "님 안녕히 가세요.");
		session.invalidate();
		return "login.jsp";
	}
}
