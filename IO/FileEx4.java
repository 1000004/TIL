public class FileEx6 {
	public static void main(String[] args) {
		File f = new File("c:\\text\\a.txt");
		//File은 파일,경로 표현 가능
		//파일인지 경로인지 확인
		System.out.println("file : "+ f.isFile());
		System.out.println("directory : " + f.isDirectory());
		
		File f2 = new File("c:\\test\\a\\b\\some.txt");
		//논리적 파일은 판별할 수 없다.
		//파일도 디렉토리도 아니다
		//확장자로 파일과 디렉토리 구별 불가
		//확장자가 없는 파일 존재
		//판별은 디스크상 존재해야만 할 수 있다
		
		System.out.println("file : "+ f2.isFile());
		System.out.println("dirctory : " + f2.isDirectory());
	}
}
