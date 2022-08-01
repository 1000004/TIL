package org.dao;

import java.util.Vector;

import javax.servlet.ServletContext;

import org.bean.Student;

public class StudentDAO {
	private static ServletContext application;
	public static void init(ServletContext application){
		StudentDAO.application = application;
	}
	public static Vector<Student> getAll(){
		Vector<Student> list = (Vector<Student>)application.getAttribute("list");
		if(list == null){
			list = new Vector<Student>();
			application.setAttribute("list", list);
		}
		return list;
	}
	public static boolean insert(Student student){
		return getAll().add(student);
	}
	public static boolean delete(int s_id){
		Vector<Student> list = getAll();
		Student s = getStudentById(s_id);
		return list.remove(s);
	}
	public static Student getStudentById(int s_id){
		Vector<Student> list = getAll();
		Student s = new Student(s_id);
		int idx = list.indexOf(s);
		Student target = null;
		if(idx >= 0){
			target = list.get(idx);
		}
		return target;
	}
	public static boolean update(Student s){
		Vector<Student> list = getAll();
		int idx = list.indexOf(s);
		
		boolean flag = false;
		if(idx >= 0){
			list.set(idx, s);
			flag = true;
		}
		return flag;
	}
	public static Vector<Student> getStudentByClass(String s_class){
		Vector<Student> list = getAll();
		Vector<Student> result = new Vector<Student>();
		for(Student s : list){
			if(s.getS_class().equals(s_class)){
				result.add(s);
			}
		}
		return result;
	}
	public static Vector<Student> getStudentByName(String s_name){
		Vector<Student> list = getAll();
		
		Vector<Student> result = new Vector<Student>();
		for(Student s : list){
			if(s.getS_name().equals(s_name)){
				result.add(s);
			}
		}
		return result;
	}
}
