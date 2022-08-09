package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class NullCmd implements ICmd {

	private String nextPage;
	public NullCmd(String nextPage){
		this.nextPage = nextPage;
	}
	
	@Override
	public String action(HttpServletRequest requset) {
		
		return nextPage;
	}

}
