package kr.ac.green.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.dao.TempDB;
import kr.ac.green.dto.User;

public class LoginCmd implements ICmd{
	@Override
	public String doAction(HttpServletRequest request) {
		String nextPage = "loginSuccess.jsp";
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		User user = new User();
		user.setUid(uid);
		user.setUpw(upw);
		
		Vector<User> list = TempDB.getList(request);
		int idx = list.indexOf(user);
		nextPage = "login.jsp";
		String msg = "가입되지 않은 사용자 입니다.";
		if(idx != -1){
			User savedUser = list.get(idx);
			if(savedUser.getUpw().equals(upw)){
				nextPage = "loginSuccess.jsp";
				msg = savedUser.getNick() + "님 반갑습니다.";
				request.getSession().setAttribute("loginUser", savedUser);
			}else{
				msg = "비밀번호가 일치하지 않습니다.";
			}
		}
		request.setAttribute("msg", msg);
		return nextPage;
	}
}
