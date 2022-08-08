package kr.ac.green.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.dao.TempDB;
import kr.ac.green.dto.User;

public class DoJoinCmd implements ICmd{
	@Override
	public String doAction(HttpServletRequest request) {
		
		Vector<User> list = TempDB.getList(request);
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		String nick = request.getParameter("nick");
		User user = new User(uid, upw, nick);
		
		String nextPage = "joinOk.do";
		if(list.contains(user)){
			request.setAttribute("msg", "이미 존재하는 아이디입니다.");
			nextPage = "join.jsp";
			request.setAttribute("user", user);
		}else{
			list.add(user);
			request.setAttribute("isRedirect", true);
		}
		return nextPage;
	}
}
