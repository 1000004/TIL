import java.io.*;
/*
public class FileReader {
	public FileReader(String fileName) throws FileNotFoundException {
		...
	}
}

*/
class ExceptionEx9 {
	public static void method1() throws FileNotFoundException {
		new FileReader("a.txt");
	}
	public static void method2() throws FileNotFoundException {		
		method1();		
	}
	public static void main(String[] args) {
		try {
			method2();
		} catch(FileNotFoundException e) {
			
		}
	}
}