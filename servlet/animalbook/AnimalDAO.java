package kr.ac.green.dao;

import java.util.Vector;

import javax.servlet.ServletContext;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import kr.ac.green.beans.Animal;

public class AnimalDAO {
	private static ServletContext application;
	
	public static void init(ServletContext app){
		application = app;
		application.setAttribute("list", new Vector<Animal>());
	}
	/*
	 * length -> 0
	 */
	public static Animal[] getList() {
		Vector<Animal> list = (Vector<Animal>)application.getAttribute("list");
		return list.toArray(new Animal[0]);
	}
	public static void addAnimal(Animal animal){
		Vector<Animal> list = (Vector<Animal>)application.getAttribute("list");
		list.add(animal);
	}
}
