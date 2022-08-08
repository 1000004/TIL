package kr.ac.green.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.ac.green.dao.TempDB;
import kr.ac.green.dto.User;

public class DoWithdrawCmd implements ICmd{
	@Override
	public String doAction(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		Vector<User> list = TempDB.getList(request);
		list.remove(user);
		session.invalidate();
		return "afterWithdraw.do";
	}
}
