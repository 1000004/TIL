package org.controller;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cmd.DoDeleteCmd;
import org.cmd.FindCmd;
import org.cmd.GetAllCmd;
import org.cmd.ICmd;
import org.cmd.NullCmd;

public class CmdFactory {
	private static Hashtable<String, ICmd>cmds;
	
	static void initCmd(){
		cmds = new Hashtable<String, ICmd>();
		cmds.put("/getAll.do", new GetAllCmd());
		cmds.put("/goModify.do", new NullCmd("pages/find.jsp?forWhat=modify"));
		cmds.put("/goDelete.do", new NullCmd("pages/find.jsp?forWhat=delete"));
		cmds.put("/goInsert.do", new NullCmd("pages/input.jsp"));
		cmds.put("/find.do", new FindCmd());
		cmds.put("/doModify", new DoDeleteCmd());
		cmds.put("/doDelete", new DoDeleteCmd());
		cmds.put("/nodata.do", new NullCmd("pages/nodata.jsp"));
	}
	static void searchAndDo(
			String cmd, HttpServletRequest request, HttpServletResponse response){
		cmds.get(cmd).action(request, response);
	}
}
