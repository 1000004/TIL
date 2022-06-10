public class PropertiesUtil {
	//Properties -> File
	public static void saveProp(
		Properties prop, String path, String comment)
		throws NullPointerException, BadFileException,
		IOException{
		
		if(prop == null){
			throw new NullPointerException(
				"Properties 객체는 null이 될 수 없습니다."
			);
		}
		
		nullCheck(path);
		checkFileExt(path);
		
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream(path);
			if(isXML(path)){
				prop.storeToXML(fos, comment);
			}else{
				prop.store(fos, comment);
			}
		}finally{
			try{
				fos.close();
			}catch(Exception e){}
		}
	}
	private static void checkFileExt(String path)
		throws BadFileException{
		int idx = path.lastIndexOf(".");
		if(idx < 0){
			throw new BadFileException();
		}
	}
	private static boolean isXML(String path){
		boolean isXML = false;
		//.xml
		int idx = path.lastIndexOf(".");
		String ext = path.substring(idx).toLowerCase();//자바는 대문자 소문자 구분
		if(ext.equals(".xml")){
			isXML = true;
		}
		return isXML;
	}
	private static void nullCheck(String path)
		throws NullPointerException{
		if(path == null){
			throw new NullPointerException(
				"파일경로는 null이 될 수 없습니다."	
			);
		}
	}
	// File -> Properties
	public static Properties loadProp(String path)
		throws NullPointerException, BadFileException, IOException {
		
		nullCheck(path);
		checkFileExt(path);
		
		Properties prop = null;
		FileInputStream fis = null;
		
		try{
			fis = new FileInputStream(path);
			prop = new Properties();
			if(isXML(path)){
				prop.loadFromXML(fis);
			}else{
				prop.load(fis);
			}
		}finally{
			try{
				fis.close();
			}catch(Exception e){}
		}
		return prop;
	}
}
class BadFileException extends RuntimeException{
	public BadFileException(){
		super("파일의 형식이 올바르지 않습니다.");
	}
}
