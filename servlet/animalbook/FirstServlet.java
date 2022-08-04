package kr.ac.green;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    @Override
	public void init(ServletConfig config) throws ServletException {
    	ServletContext application = config.getServletContext();
    	AnimalDAO.init(application);
//		System.out.println("init");
	}
    /*
     * 1. 서블릿으로 요청이 들어오다.
     * 2. service()가 호출된다.
     * 3. 전송방식에 따라 doGet, doPost가 service내부에서 호출된다.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();					//session 구하기
//		ServletContext application = session.getServletContext();	//application 구하기
//		System.out.println("GET : " +getInitParameter("myKey"));
		doAction(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("POST");
		doAction(request, response);
	}
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		
		System.out.println(uri);
		System.out.println(contextPath);
		
		String cmd= uri.substring(contextPath.length());
		
		//String cmd = request.getParameter("cmd");
		//if(cmd == null){
		//	cmd= "goList";
		//}
		String nextPage = "list.jsp";
		boolean isRedirect = false;
		if(cmd.equals("/goList.do")){
			request.setAttribute("list", AnimalDAO.getList());
		}else if(cmd.equals("/goInsert.do")){
			nextPage = "input.jsp";
		}else if(cmd.equals("/insert.do")){
			String a_name = request.getParameter("a_name");
			int a_lifespan=Integer.parseInt(request.getParameter("a_lifespan"));
			String a_habitat = request.getParameter("a_habitat");
			String a_feature =  request.getParameter("a_feature");
			
			Animal animal = new Animal();
			animal.setA_name(a_name);
			animal.setA_lifespan(a_lifespan);
			animal.setA_habitat(a_habitat);
			animal.setA_feature(a_feature);
			
			AnimalDAO.addAnimal(animal);
			isRedirect = true;
		}
		if(isRedirect){
			response.sendRedirect(request.getContextPath());
		}else{
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}
	}
}
