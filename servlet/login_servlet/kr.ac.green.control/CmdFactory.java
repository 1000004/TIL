package kr.ac.green.control;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.cmd.AccessDeniedCmd;
import kr.ac.green.cmd.AfterModifyCmd;
import kr.ac.green.cmd.AfterWithdrawCmd;
import kr.ac.green.cmd.CancelJoinCmd;
import kr.ac.green.cmd.CancelModifyCmd;
import kr.ac.green.cmd.CancelWithdrawCmd;
import kr.ac.green.cmd.DoJoinCmd;
import kr.ac.green.cmd.DoModifyCmd;
import kr.ac.green.cmd.DoWithdrawCmd;
import kr.ac.green.cmd.GoJoinCmd;
import kr.ac.green.cmd.GoModifyCmd;
import kr.ac.green.cmd.ICmd;
import kr.ac.green.cmd.JoinOkCmd;
import kr.ac.green.cmd.LoginCmd;
import kr.ac.green.cmd.StartCmd;

public class CmdFactory {
	private static Hashtable<String, ICmd> cmds;
	public static void init(){
		if(cmds == null){
			cmds = new Hashtable<String, ICmd>();
			cmds.put("/start.do", new StartCmd());
			cmds.put("/goJoin.do", new GoJoinCmd());
			cmds.put("/cancelJoin.do", new CancelJoinCmd());
			cmds.put("/doJoin.do", new DoJoinCmd());
			cmds.put("/joinOk.do", new JoinOkCmd());
			cmds.put("/login.do", new LoginCmd());
			cmds.put("/goModify.do", new GoModifyCmd());
			cmds.put("/accessDenied.do", new AccessDeniedCmd());
			cmds.put("/cancelModify.do", new CancelModifyCmd());
			cmds.put("/doModify.do", new DoModifyCmd());
			cmds.put("/afterModify.do", new AfterModifyCmd());
			cmds.put("/cancelWithdraw.do", new CancelWithdrawCmd());
			cmds.put("/doWithdraw.do", new DoWithdrawCmd());
			cmds.put("/afterWithdraw.do", new AfterWithdrawCmd());
		}
	}
	public static String searchAndDo(HttpServletRequest request, String cmd){
		return cmds.get(cmd).doAction(request);
	}
}
