import java.util.Vector;

import javax.servlet.ServletContext;

public class DocManger {
	//목록가져오기
	public static Vector<Doc> getList(ServletContext application){
		Vector<Doc> list = (Vector<Doc>)application.getAttribute("docList");
		if(list == null){
			list = new Vector<Doc>();
			application.setAttribute("docList", list);
		}
		return list;
	}
	//글등록
	public static void addDoc(Doc doc, ServletContext application){
		Vector<Doc> docList = getList(application);
		docList.add(doc);
	}
}
