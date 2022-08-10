package kr.ac.green.dao;

import java.util.Properties;

public class DAOFactory {
	private static IDAO dao;
	
	public static void init(Properties prop){
		String fullName = prop.getProperty("dao");
		try {
			// reflection 클래스 정보를 가지고 객체 만든다
			// 코드 짤때 쓰는게 아닌 useBean
			dao = (IDAO)Class.forName(fullName).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static IDAO getDao(){
		return dao;
	}
}
