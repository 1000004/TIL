package kr.ac.green.dao;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import kr.ac.green.dto.User;

public class TempDB	 {
	public static Vector<User> getList(HttpServletRequest request){
		ServletContext application = request.getSession().getServletContext();
		Vector<User> list = (Vector<User>)application.getAttribute("list");
		if(list == null){
			list = new Vector<User>();
			application.setAttribute("list", list);
		}
		return list;
	}
}
