package kr.ac.green;

import java.util.Vector;

import javax.servlet.ServletContext;

public class MovieReviewDAO {
	private static ServletContext application;
	
	public static void init(ServletContext app){
		if(MovieReviewDAO.application == null){
			application = app;
		}
	}
	
	public static Vector<MovieReview> getAll(){
		Vector<MovieReview> list = (Vector<MovieReview>)application.getAttribute("list");
		if(list == null){
			list = new Vector<MovieReview>();
			application.setAttribute("list", list);
		}
		return list;
	}
	
	public static void addReview(MovieReview mr){
		getAll().add(mr);
	}
	
	public static MovieReview find(int num) {
		MovieReview temp = new MovieReview(num);
		Vector<MovieReview> list = getAll();
		int idx = getAll().indexOf(temp);
		
		MovieReview target = null;
		if(idx >= 0){
			target = list.get(idx);
		}
		return target;
	}
	public static void update(MovieReview mr){
		Vector<MovieReview> list = getAll();
		int idx = list.indexOf(mr);
		if(idx >= 0){
			list.set(idx, mr);
		}
	}
	public static void delete(int num){
		Vector<MovieReview> list=getAll();
		list.remove(new MovieReview(num));
	}
}
