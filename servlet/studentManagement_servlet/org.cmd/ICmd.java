package org.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICmd {
	void action(HttpServletRequest request, HttpServletResponse response);
}
