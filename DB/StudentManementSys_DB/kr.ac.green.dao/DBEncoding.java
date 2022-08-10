package kr.ac.green.dao;

import java.io.UnsupportedEncodingException;

public class DBEncoding {
	//JSP : euc-kr -> euc_kr, 8859-1 -> 8859_1, UTF-8 -> UTF-8
	//1. JSP (euc-kr) -> DB(8859_1) : insert, update
	public static String toEn(String kor) throws UnsupportedEncodingException{
		String result = null;
		result = new String(kor.getBytes("euc_kr"),"8859_1");
		return result;
	}
	//2. DB(8855_1) -> JSP(euc-kr) : select
	public static String toKor(String en) throws UnsupportedEncodingException{
		String result = null;
		result = new String(en.getBytes("8859_1"),"euc_kr");
		return result;
	}
}
