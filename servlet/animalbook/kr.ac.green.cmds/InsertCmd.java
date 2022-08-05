package kr.ac.green.cmds;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.green.beans.Animal;
import kr.ac.green.dao.AnimalDAO;

public class InsertCmd implements ICmd{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
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
		
		request.setAttribute("isRedirect", true);
		return request.getContextPath();
	}
	
}
