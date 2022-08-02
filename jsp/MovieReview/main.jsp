<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Vector" %>
<%@ page import="kr.ac.green.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
// * 아스테리스크
// '' 코테이션
	MovieReviewDAO.init(application);

	String cmd = request.getParameter("cmd");
	if(cmd == null){
		cmd="getAll";
	}
	String nextPage = "list.jsp";
	boolean isRedirect = false;
	if(cmd.equals("getAll")){
		Vector<MovieReview> list = MovieReviewDAO.getAll();
		request.setAttribute("list", list);
	}else if(cmd.equals("goInsert")){
		nextPage = "insert.jsp";
	}else if(cmd.equals("insert")){
		String title = request.getParameter("title");
		int point = Integer.parseInt(request.getParameter("point"));
		String password = request.getParameter("password");
		String review = request.getParameter("review");
		
		MovieReview mr = new MovieReview();
		mr.setTitle(title);
		mr.setPoint(point);
		mr.setPassword(password);
		mr.setReview(review);
		
		MovieReviewDAO.addReview(mr);
		
		isRedirect = true;
	}else if(cmd.equals("showReview")){
		int num = Integer.parseInt(request.getParameter("num"));
		request.setAttribute("review", MovieReviewDAO.find(num));
		nextPage = "showReview.jsp";
	}else if(cmd.equals("update")){
		int num = Integer.parseInt(request.getParameter("num"));
		String title = request.getParameter("title");
		String review = request.getParameter("review");
		int point = Integer.parseInt(request.getParameter("point"));
		String password = request.getParameter("password");
		MovieReview mr = new MovieReview(num);
		mr.setTitle(title);
		mr.setReview(review);
		mr.setPoint(point);
		mr.setPassword(password);
		
		MovieReview target = MovieReviewDAO.find(num);
		if(password.equals(target.getPassword())){
			MovieReviewDAO.update(mr);
			isRedirect = true;
		}else{
			nextPage = "wrongPassward.jsp";
		}
	}else if(cmd.equals("delete")){
		int num = Integer.parseInt(request.getParameter("num"));
		String password = request.getParameter("password");
		
		MovieReview mr =MovieReviewDAO.find(num);
		if(password.equals(mr.getPassword())){
			MovieReviewDAO.delete(num);
			isRedirect = true;
		}else{
			nextPage = "wrongPassword.jsp";
		}
	}
	if(isRedirect){
		response.sendRedirect(request.getContextPath());//list로 바로 보내며 안된다
	}else{
		request.getRequestDispatcher(nextPage).forward(request, response);//어디로 가는지 설정 (forward 기능)
	}
%>
