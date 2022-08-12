package org.smart.control;

import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.smart.cmd.ICMD;

public class CMDFactory {
	private static Hashtable<String , ICMD> cmds = new Hashtable<String, ICMD>();
	public static void initCmd(Properties prop){
		try {
			//Reflection
			Set<?> keys =prop.keySet();
			for(Object keyObj : keys){
				String key = keyObj.toString();
				String className = prop.getProperty(key);
				ICMD cmdObj;
				cmdObj = (ICMD)Class.forName(className).newInstance();
				cmds.put(key, cmdObj);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static String doAction(HttpServletRequest request, String key){
		return cmds.get(key).action(request);
	}
}
