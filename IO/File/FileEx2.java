public class FileEx2 {
	public static void main(String[] args) {
		File dir = new File("c:\\test\\a\\b\\c\\d");
		//parents가 존재한는 경우 파일이 만들어진다
		//디렉토리는 디스크상에 실제로 존재하지 않다
		//파일을 구별하기 위한 논리적 식별자
		//하드디스크상 존재하지 않고 UI로 눈에 보이게 만들었다.
		//패키지와 유사
		//파일 상제 경로를 삭제 접근 못하게 하여 쓸수 없게 만든다
		//새로 만들면서 덮어씀
		//실제 파일 삭제 안함 recover 할 수 있다
		//util 지운 파일 되돌리기
		if(!dir.exists()){
			dir.mkdir();
			//dir.mkdirs();//파일을 만들기 위해 필요한 경로를 다 만든다
		}
		File f = new File(dir, "some.txt");
		if(!f.exists()){
			try{
				f.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
