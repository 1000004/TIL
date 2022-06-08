public class FileEx1 {
	public static void main(String[] args) {
		File dir = new File("c:\\test\\a");
		File f = new File(dir, "some.txt");
		
		if(!dir.exists()){
			dir.mkdir();//경로를 만들어 낸다.
		}
		
		if(!f.exists()){
			try{
				f.createNewFile();
				//없는 경로로 파일을 만드는 경우
				//'지정되 경로를 찾을 수 없습니다' IOException test 밑에 a가 없다
			}catch (IOException e){
				e.printStackTrace();
			}
		}
	}
}
