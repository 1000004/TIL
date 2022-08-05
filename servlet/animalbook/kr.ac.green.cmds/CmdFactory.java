package kr.ac.green.cmds;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdFactory {
	private static Hashtable<String, ICmd> cmds = new Hashtable<String, ICmd>();
	
	public static void init(){
		cmds.put("/goList.do", new GoListCmd());
		cmds.put("/goInsert.do", new GoInsertCmd());
		cmds.put("/insert.do", new InsertCmd());
	}
	public static String searchAndDo(String cmd, HttpServletRequest request, HttpServletResponse response){
		return cmds.get(cmd).action(request, response);
	}
}
