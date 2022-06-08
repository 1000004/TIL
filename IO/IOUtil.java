import java.io.Closeable;

public class IOUtil {
  //인터페이스 Closeable을 구현하는 모든 클래스는 닫을 수 있는 메서드.
	public static void closeAll(Closeable...c){
		for(Closeable temp : c){
			try{
				temp.close();
			}catch(Exception e){}
		}
	}
}
