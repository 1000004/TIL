package kr.ac.green.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.dao.TempDB;
import kr.ac.green.dto.User;

public class DoModifyCmd implements ICmd{
	@Override
	public String doAction(HttpServletRequest request) {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		String nick = request.getParameter("nick");
		
		User user = (User)request.getSession().getAttribute("loginUser");
		user.setUpw(upw);
		user.setNick(nick);
		
		Vector<User> list = TempDB.getList(request);
		int idx = list.indexOf(user);
		list.set(idx, user);
		
		request.setAttribute("isRedirect", true);
		return "afterModify.do";
	}
}
