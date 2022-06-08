public class FileEx7 {
	public static void printFileInfo(File temp){
		System.out.println("parent : "+temp.getParent());
		System.out.println("name : "+temp.getName());
		System.out.println("path : "+temp.getPath());
	}
	
	public static void printFileInfo2(File temp){
		File absFile = temp.getAbsoluteFile();//절대경로표기법으로 변경
		
		printFileInfo(absFile);
	}
	public static void printFileInfo3(File temp){
		try{
			String path1 = temp.getAbsolutePath();
			//내부적으로 사용시 path1 이용해도 무관하지만 사용자에게 보여줘야 할때 path2 
			String path2 = temp.getCanonicalPath();
			System.out.println("absolute path : "+path1);
			System.out.println("canonical path : "+path2);
			//01 문제열로 가져온다.
			File canFile = temp.getCanonicalFile();//실제 위치 경로를 계산
			//02 file로 돌려준다
			printFileInfo(canFile);
		}catch(IOException e){//네칸 위 오류 - 잘못된 상대 경로인 경우 getCanonicalFile 예외처리
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		File f1 = new File("c:\\test\\a.text");
		printFileInfo(f1);
		
		File f2 = new File("what.txt");//상대경로 표기법으로 접근
		printFileInfo2(f2);//parent가 왜 null로 나올까? 경로가 있어도 안나오는 이유 - 상대경로 표기
		
		File f3 = new File("..\\..\\some.txt");
		//D:\java\eclipse_workspace\06_07\..\..\some.txt
		//06_07의2칸 위로 java에 있다
		//f2의 위치를 찾고 뒤에 상대 경로를 붙이는 방식
		//사용자에게 파일위를 알려줄때 이해하기 어렵다
		printFileInfo3(f2);
		printFileInfo3(f3);
	}
}
