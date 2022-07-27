package kr.ac.green;

import java.util.Vector;

import javax.servlet.ServletContext;

/*
 * Singleton Pattern
 * 
 * 단하나의 유일한 객체를 보장하는 방법
 */
public class HumanManager {
	private static final HumanManager INSTANCE = new HumanManager();
	// final로 생성된 INSTANCE는변경이 불가하다
	//전체 어플리케이션에서 한개 존재한다
	//툴킷,켈린더는 새로 생성하지 않는다
	private HumanManager(){} 
	//생성자가 private 하면 HumanManager 객체를 추가로 만들수 없다
	
	public static HumanManager getInstance(){
		//INSTANCE는 getInstance()를 통해서 얻을 수 있다
		return INSTANCE;
	}
	
	public Vector<Human> getList(ServletContext application){
		Vector<Human> list = (Vector<Human>)application.getAttribute("list");
		if(list == null){
			list = new Vector<Human>();
			application.setAttribute("list", list);
		}
		return list;
	}
	public void add(ServletContext application, Human human){
		getList(application).add(human);
	}
}
