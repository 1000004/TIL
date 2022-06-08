public class FileEx3 {
	public static void main(String[] args) {
		File dir = new File("c:\\test\\a\\b\\c\\d");//디렉토리 지우기
		
		File f = new File(dir, "some.txt");
		f.delete();
		
		dir.delete();//안에 파일이 있으면 안지워짐
		
		dir = new File("c:\\test\\a\\b\\c");
		dir.delete();
		
		dir = new File("c:\\test\\a\\b");
		dir.delete();
		//지우고자하는 디렉토리 안에 file, 디렉토리 있으면 지워지지 않음
		
		
	}
}
