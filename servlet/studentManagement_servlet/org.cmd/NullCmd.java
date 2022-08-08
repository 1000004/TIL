package org.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullCmd implements ICmd{
	private String contentPage;
	public NullCmd(String contentPage){
		this.contentPage = contentPage;
	}
	@Override
	public void action(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("contentPage", contentPage);
	}
	
}
