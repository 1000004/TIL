import java.io.*;
class ExceptionEx4 {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("a.txt");
		} catch(IOException e) {//FileNotFoundExcption 상위 클래스
		}
	}
}
