package kr.ac.green.control;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.cmd.DoDeleteCmd;
import kr.ac.green.cmd.DoInsertCmd;
import kr.ac.green.cmd.DoUpateCmd;
import kr.ac.green.cmd.GetAllCmd;
import kr.ac.green.cmd.GetStudentCmd;
import kr.ac.green.cmd.ICmd;
import kr.ac.green.cmd.NullCmd;

public class CmdFactory {
	private static Hashtable<String, ICmd> cmds = new Hashtable<String, ICmd>();
	
	protected static void init(){ //동일한 패키지에서 사용
		cmds.put("/getAll.do", new GetAllCmd());
		cmds.put("/goInsert.do", new NullCmd("insert.jsp"));
		cmds.put("/doInsert.do", new DoInsertCmd());
		cmds.put("/getStudent.do", new GetStudentCmd());
		cmds.put("/doDelete.do", new DoDeleteCmd());
		cmds.put("/doUpdate.do", new DoUpateCmd());
	}
	protected static String searchAndDo(HttpServletRequest request, String cmd){
		return cmds.get(cmd).action(request);
	}
}
