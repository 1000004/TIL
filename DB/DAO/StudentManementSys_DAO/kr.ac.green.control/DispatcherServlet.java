package kr.ac.green.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.green.dao.DAOFactory;
import kr.ac.green.dao.DAOProvider;
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
//		String path = getServletContext().getRealPath(getInitParameter("propPath"));
		//내부경로이기 때문에 디스크 상의 경로 바꾼다 
//		Properties prop = new Properties();
//		FileInputStream fis = null;
//		try {
//			fis = new FileInputStream(new File(path, "dao.properties"));
//			prop.load(fis);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally{
//			try{
//				fis.close();
//			}catch(Exception e){}
//		}
//		DAOFactory.init(prop);
		DAOProvider.init(getInitParameter("kind"));
		CmdFactory.init();
		try{
			Class.forName(getInitParameter("DRIVER"));
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		doAction(request, response);
	}
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(request.getContextPath().length());
		
		System.out.println(cmd);
		String nextPage = CmdFactory.searchAndDo(request, cmd);
		
		if(request.getAttribute("isRedirect") == null){
			request.getRequestDispatcher(nextPage).forward(request, response);
		}else{
			response.sendRedirect(nextPage);
		}
	}
}
