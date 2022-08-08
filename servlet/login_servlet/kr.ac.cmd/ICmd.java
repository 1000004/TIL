package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public interface ICmd {
	String doAction(HttpServletRequest request);
}
