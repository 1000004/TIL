public class PropertiesEx {
	public static void store(){
		Properties prop = new Properties();
    /*
      Map > Hashtable > Properties Key(String) Value(String) 제네릭 없다
      Map 추가할 때 쓰는 put이 가능하지만 setProperty 메소드가 있다
      파일로 쓸수 있는 기능 제공
      어떻게 파일로 저장하고 어떻게 불러올지 알아서 해준다
      똑같은 종류 값이 반복되는 경우 적합하지 않다
      다 다른 여러가지 값과 형태로 저장되는 경우 ex 프로그램 설정 정보
      자바로 만들어지 프로그램은 Properties 형식의 파일을 가지고 있다.
      이클립스의 경우 프로그램의 설정을 저장 형식이 properties와 같고 확장자는 properties를 사용하지 않고 있다.
      (properties는 권장일뿐 다른 확장자 사용 가능)
    */
		prop.setProperty("aKey", "aValue");
		prop.setProperty("bKey", "bValue");
		prop.setProperty("cKey", "cValue");
		prop.setProperty("dKey", "dValue");
		//스코프 블럭밖에서 선언 정의가 되야 여러 블럭에서 시용 가능
		//try catch 실행보장 x
		FileOutputStream fos = null;
		try {
			//properties 파일 을 만들 수 있다
			//이클립스의 기능 한글을 쓰면 유니코드 변경
			//이클립스에서 properties 파일을 만드는 경우 한글이 가능하지만 다른 프로그램에는 안되므로 쓰지 않는 것 이 좋다
			//case : text file
//			fos = new FileOutputStream("myValue.properties"); //properties 파일 을 만들 수 있다
//			prop.store(fos, "my comment");
			//case : XML tile (soure)
			fos = new FileOutputStream("myValue.xml");
			prop.storeToXML(fos, "this is a XML");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			IOUtil.closeAll(fos);
		}
	}
	public static void load(){
		//어떻게 불러올지도 정하지 않아도 된다.
		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
//			case : text file
//			fis = new FileInputStream("myValue.properties");
//			prop.load(fis);
			
//			case : XML file
			fis = new FileInputStream("myValue.xml");
			prop.loadFromXML(fis);
			
			System.out.println(prop.getProperty("cKey"));
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			IOUtil.closeAll(fis);
		}
		
	}
	public static void main(String[] args) {
		store();
		load();
	}
}
