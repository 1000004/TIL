package org.smart.control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.smart.dao.DAOFactory;

public class MainServle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private void loadProp(String path, Properties prop){
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(path);
			prop.load(fis);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch ( IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext application = config.getServletContext();
		String path = config.getInitParameter("cmdsInfoPath");
		String realPath = application.getRealPath(path);
		Properties prop = new Properties();
		loadProp(realPath, prop);
		CMDFactory.initCmd(prop);
		path = config.getInitParameter("dbTypePath");
		
		realPath = 
		application.getRealPath(path);
		prop = new Properties();
		
		loadProp(realPath, prop);
		System.out.println(prop.getProperty("dbms"));
		DAOFactory.initDaos(prop.getProperty("dbms"));
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc_kr");
		doAction(request, response);
	}
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String what = uri.substring(request.getContextPath().length());
		String nextPage = CMDFactory.doAction(request, what);
		if(request.getAttribute("isRedirect")==null){
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}else{
			response.sendRedirect(nextPage);
		}
	}
}
