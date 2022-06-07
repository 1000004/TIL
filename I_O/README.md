
## I/O - 입출력
* java.io - 입출력이 없는 프로그램은 없으므로 가장 중요한 패키지일 수 있다. 발전된 패키지 nio
* 프로그램 성능에 영향을 미친다.
* 영속적 저장소 (vs휴발성 저장소 저장 공간이 없었다)
    * file 읽고/쓰기
    * DataBase - file에 비해 데이터 공유 가능하다는 장점을 가진다
    * 일회성이 아닌 이전 데이터를 이어받아 연속적으로 이용
    * file을 컨트롤이 가능해지면 프로그램에서 할수 있는게 많아진다
## File
* ### class file
    * 01.파일(a.txt)
    * 02.디렉토리(경로) : 논리적 식별자 - 크기가 없다(윈도우 폴더 = 디렉토리)
* UNIX 구별자 '/' 
* 윈도우 구분자 '\' 자바에서 이미 쓰고 있기 때문에 '\\' (2개로 표현)
* USB나 CD-ROM도 file개념 인지
* file class는 불변(immytable) 변경 불가
* 컴퓨터에서 파일을 관리해주는 file-system = O/S
* 자바가 운영체제에게 파일을 만들어달라고 요청 
* 거부하는 경우가 있다 권한이 없다 또는 접근할 수 없는 위치 코드로 해결 불가능 : 강제 예외처리
```java
public class FileEx2 {
	public static void main(String[] args) {
		/*
		 * 물리적 파일 : 디스크상에 실제로 존재하는 파일
		 * 논리적 파일 : 코드상에서만 존재
		 */
		
		File f = new File("c:\\test\\some.txt"); //논리적인 파일
		
		System.out.println(f.exists());//실제 경로에 파일이 존재하는지 확인
		
		if(!f.exists()){//이미 존재하는 파일인지 확인
			try{
				f.createNewFile();//파일 생성
			}catch(IOException e){//강제 예외처리
				//file 관리 system o/s 자원관리 요청
            			//코드로 해결 x 외부 문제
				e.printStackTrace();
			}
		}else{
			f.delete();//파일 삭제
		}
	}
}

public class FileEx2 {
	public static void main(String[] args) {
		// c:\\test\\a.txt
		File f1 = new File("c:\\test\\a.txt");
      
		File dir = new File("c:\\text");//파일이 아닌 경로를 나타낸다.
		File f2 = new File(dir,"a.txt");
		
		File f3 = new File("c:\\text", "a.txt");
      //f1, f2, f3 동일한 파일 표현
		//경로 나타내는 거지 저장 공간을 가지는게 아님
	}
}
```
