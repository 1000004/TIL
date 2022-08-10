package kr.ac.green.dao;

public class DAOProvider {
	private static final StudentDAO DAO1 = StudentDAO.getInstance();
	private static final HyperStudentDAO DAO2 = new HyperStudentDAO();
	private static IDAO dao;
	public static void init(String kind){
		dao = DAO2;
		if(kind.equals("studentDAO")){
			dao = DAO1;
		}
	}
	public static IDAO getDao(){
		return dao;
	}
}
