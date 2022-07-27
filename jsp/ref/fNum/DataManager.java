import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletContext;

public class DataManager {
	private static ServletContext application;
	
	public static void setApplication(ServletContext app){
		if(application == null){
			application = app;
		}
		Map<String, String> nameList =
			(Map<String, String>)application.getAttribute("nameList");
		if(nameList == null){
			nameList = new Hashtable<String, String>();
			
			Enumeration<String> names = application.getInitParameterNames();
			while(names.hasMoreElements()){
				String name = names.nextElement();
				nameList.put(name, application.getInitParameter(name));
			}
			application.setAttribute("nameList", nameList);
		}
		
	}
	public static String getName(String code){
		Map<String, String> nameList =
				(Map<String, String>)application.getAttribute("nameList");
		return nameList.get(code);
	}
	public static Vector<Comment> getCmtList(String code){
		Map<String, Vector<Comment>> cmtList =
				(Map<String,Vector<Comment>>)application.getAttribute("cmtList");
		if(cmtList == null){
			cmtList = new Hashtable<String, Vector<Comment>>();
			application.setAttribute("cmtList", cmtList);
		}
		Vector<Comment> list = cmtList.get(code);
		if(list == null){
			list = new Vector<Comment>();
			cmtList.put(code, list);
		}
		return list;
	}
	public static void addCmt(String code, Comment cmt){
		getCmtList(code).add(cmt);
	}
}
